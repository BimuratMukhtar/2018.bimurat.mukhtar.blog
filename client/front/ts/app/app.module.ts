
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {BrowserModule} from "@angular/platform-browser";
import {HttpService} from "../provider/HttpService";
import {HttpModule} from "@angular/http";

@NgModule({
    imports:[
        BrowserModule,
        HttpModule
    ],
    declarations:[AppComponent],
    bootstrap:[AppComponent],
    entryComponents:[AppComponent],
    providers:[HttpService]
})
export class AppModule{

}
