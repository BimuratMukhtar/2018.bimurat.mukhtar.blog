import {Component} from "@angular/core";
import {HttpService} from "../../provider/HttpService";



@Component({
    selector: "login_page",
    template: require("./login.component.html"),
    styles: [require('./login.component.css')]
})
export class LoginComponent {
    private email: string;
    private password: string;
    private error;

    constructor(private httpService: HttpService){}

    loginFunc(): void{
        this.httpService.post("/loginUser", {
            login: this.email,
            password: this.password
        }).toPromise().then(
            result => {
                console.log(result.toString())
            },
            error => {
                this.error = error.toString()
            }
        )
    }
}