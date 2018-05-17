import {Component} from "@angular/core";
import {HttpService} from "../../provider/HttpService";
import {LoadingWrapper} from "../error/LoadingErrorWrapper";
import {Observable} from "rxjs/internal/Observable";
import {Response} from "@angular/http";


@Component({
    selector: "signup_page",
    template: require("./signup.component.html"),
    styles: [require('./signup.component.css')]
})
export class SignupComponent{
    email: string;
    fullName: string;
    password: string;
    response: Observable<Response>;

    constructor(private httpService: HttpService){}

    onClickSignup(): void{
        console.log(this.email + " " + this.password + " " + this.fullName);
        this.response = new LoadingWrapper(this.httpService.post("/auth", {
            fullName : this.fullName,
            email : this.email,
            password: this.password
        })).data$
    }
}