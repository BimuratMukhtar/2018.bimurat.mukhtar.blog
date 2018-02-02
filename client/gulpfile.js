const gulp = require("gulp");
const task = gulp.task;
const del = require("del");
const less = require("gulp-less");
const path = require("path");
const pug = require('gulp-pug');

gulp.task('clean', function (){
    return del(["build"]);
});

gulp.task('less', function(){
    return gulp.src("front/less/*.less").pipe(less()).pipe(gulp.dest(path.resolve(__dirname, 'build', 'public', 'blog')))
});

gulp.task('pug', function(){
    return gulp.src("front/pug/index.pug").pipe(pug()).pipe(gulp.dest(path.resolve(__dirname, 'build', 'public', 'blog')));
});

gulp.task('ser', gulp.series('clean','less','pug'))

gulp.task('par', gulp.parallel('pug', 'less'))

gulp.task('task_pug', gulp.series('clean', "par"))