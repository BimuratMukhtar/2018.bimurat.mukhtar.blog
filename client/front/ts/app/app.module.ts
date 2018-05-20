import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from '@angular/forms';
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {AppRoutingModule} from "./app-routing.module";
import {MessagesComponent} from "./messages/messages.component";
import {HttpClientModule} from "@angular/common/http";
import {AuthService} from "../provider/auth.service";
import {MessageService} from "../provider/message.service";
import {BlogsComponent} from "./blogs/blogs.component";

@NgModule({
    imports:[
        BrowserModule,
        FormsModule,
        AppRoutingModule,
        HttpClientModule
    ],
    declarations:[
        AppComponent,
        LoginComponent,
        SignupComponent,
        MessagesComponent,
        BlogsComponent
    ],
    bootstrap:[AppComponent],
    providers:[AuthService, MessageService]
})
export class AppModule{

}
