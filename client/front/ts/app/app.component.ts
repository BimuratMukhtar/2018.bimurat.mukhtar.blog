import {Component, OnInit} from "@angular/core";
import {AuthService} from "../provider/auth.service";

@Component({
    selector: "blog_app",
    template: require('./app.component.html'),
    styles: [require('./app.component.css')]
})
export class AppComponent implements OnInit{
    isRegistered = false;

    constructor(private authService : AuthService){
    }

    ngOnInit(): void {
        this.isRegistered = this.authService.isSigned()
    }


}
