const gulp = require('gulp');
const del = require('del');
const less = require('gulp-less');
const path = require('path');
const pug = require('gulp-pug');
const webpack = require('webpack');
const gulpLog = require('gulplog');
const notifier = require('node-notifier');
const browserSync = require('browser-sync');

let isWatch = true;

function outDir(){
    return path.resolve(__dirname, 'build', 'public', 'blog')
}

gulp.task('clean', function (){
    return del(["build"]);
});

gulp.task('less', function(){
    return gulp.src("front/less/style.less").pipe(less()).pipe(gulp.dest(path.resolve(outDir(), 'css')))
});

gulp.task('copy-images',function () {
    return  gulp.src('front/images/*')
        .pipe(gulp.dest(path.resolve(__dirname,'build','public','blog','images')));
});

gulp.task('pug', function(){
    return gulp.src("front/pug/*.pug").pipe(pug({pretty:true})).on('error', console.log)
        .pipe(gulp.dest(outDir()));
});

gulp.task('webpack', function (callback) {

    let options = {
        entry: [path.resolve('.', 'front', 'ts', 'main.ts')],
        output: {
            path: path.resolve(outDir(), 'js'),
            publicPath: '/',
            filename: '[name].js',
            sourceMapFilename: '[name].js.map',
        },
        watch: isWatch,
        devtool: 'cheap-module-inline-source-map',
        module: {
            loaders: [{
                test: /\.ts$/,
                include: path.resolve(__dirname, 'front', 'ts'),
                loader: ['ts-loader'],
            }],
        },
        resolve: {
            extensions: [".ts", ".js"]
        },
        plugins: [
            new webpack.NoEmitOnErrorsPlugin() // otherwise error still gives a file
        ]
    };

    webpack(options, function (err, stats) {
        if (!err) { // no hard error
            // try to get a soft error from stats
            err = stats.toJson().errors[0];
        }

        if (err) {
            notifier.notify({
                title: 'Webpack',
                message: err
            });

            gulpLog.error(err);
        } else {
            gulpLog.info(stats.toString({
                colors: true
            }));
        }

        // task never errs in watch mode, it waits and recompile
        if (!options.watch && err) {
            callback(err);
        } else {
            callback();
        }

    });
});

gulp.task('copy', function () {
    return gulp.src([
        "node_modules/zone.js/dist/zone.min.js",
        "node_modules/core-js/client/shim.min.js"
    ]).pipe(gulp.dest(path.resolve(outDir(), 'js')));
});

gulp.task("assets", gulp.parallel('copy-images', 'less', "pug"));

gulp.task("build",  gulp.series(
    'clean', 'copy', function(callback){
        isWatch = false;
        callback();
    }, 'webpack', 'assets'
));

gulp.task('server', function (back) {
    browserSync.init({server: path.resolve('build', 'public', 'blog')});
    browserSync.watch('build/public/**/*.*').on('change', browserSync.reload);
    back();
});

gulp.task('start', gulp.series(
    'clean', 'assets', 'copy', function (callback) {
        isWatch = true;
        callback();
    }, 'webpack', 'server',
    function () {
        gulp.watch('front/pug/**/*.pug', gulp.series('pug'));
        gulp.watch('front/less/**/*.less', gulp.series('less'));
    }
));

