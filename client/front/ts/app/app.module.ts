
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {BrowserModule} from "@angular/platform-browser";
import {BlogService} from "../provider/blog.service";
import {FormsModule} from '@angular/forms';
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {AuthService} from "../provider/auth.service";

@NgModule({
    imports:[
        BrowserModule,
        FormsModule
    ],
    declarations:[
        AppComponent,
        LoginComponent,
        SignupComponent
    ],
    bootstrap:[AppComponent],
    entryComponents:[AppComponent],
    providers:[BlogService, AuthService]
})
export class AppModule{

}
