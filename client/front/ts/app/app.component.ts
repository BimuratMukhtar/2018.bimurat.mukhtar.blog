import {Component, OnInit} from "@angular/core";
import {HttpService} from "../provider/HttpService";
import "rxjs/add/operator/toPromise"

@Component({
    selector: "blog_app",
    template: require('./app.component.html'),
    styles: [require('./app.component.css')]
})
export class AppComponent implements OnInit{
    private text:string;
    private login:string = "";
    private password:string = "";
    private error;

    ngOnInit(): void {
        console.log('hi');
        this.httpService.get("/getMainText").toPromise().then(
            result => {
                this.text = result.json()
            },
            error => {
                this.text = error.toString()
            }
        )
    }

    loginFunc(): void{
        this.httpService.post("/getUsers", {
            login: this.login,
            password: this.password
        }).toPromise().then(
            result => {
                let user_name = result.json()
                if(user_name === "failed"){
                    this.error = "Email or Password incorrect"
                }else{
                    this.error = null;
                    this.text = user_name
                }
            },
            error => {
                this.error = error.toString()
            }
        )
    }

    constructor(private httpService: HttpService){

    }
}
