import {Component} from "@angular/core";
import {AuthService} from "../../provider/auth.service";
import {User} from "../../models/models";
import {Router} from "@angular/router";


@Component({
    selector: "login_page",
    template: require("./login.component.html"),
    styles: [require('./login.component.css')]
})
export class LoginComponent {
    private email: string;
    private password: string;

    constructor(private router: Router, private authService: AuthService){}

    login(): void{
        this.authService.loginUser(new User(this.email, this.password)).subscribe(token => {
            this.authService.assignToken(token)
            console.log(token)
            this.router.navigate([''])
        })
    }
}