import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {BlogsComponent} from "./blogs/blogs.component";

const routes: Routes = [
    {path: '', redirectTo: '/blogs', pathMatch: 'full'},
    {path: 'blogs', component: BlogsComponent},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: SignupComponent}
];

@NgModule({
    exports: [RouterModule],
    imports: [RouterModule.forRoot(routes)],
})
export class AppRoutingModule {
}
