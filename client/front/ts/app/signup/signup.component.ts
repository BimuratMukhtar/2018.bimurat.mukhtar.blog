import {Component} from "@angular/core";
import {AuthService} from "../../provider/auth.service";
import {User} from "../../models/models";


@Component({
    selector: "signup-page",
    template: require("./signup.component.html"),
    styles: [require('./signup.component.css')]
})
export class SignupComponent{
    email: string;
    fullName: string;
    password: string;

    constructor(private userService: AuthService){}

    signup(): void{
        this.userService.registerUser(new User(this.email, this.fullName, this.password)).subscribe(token => {
            console.log(token);
        })
    }


}