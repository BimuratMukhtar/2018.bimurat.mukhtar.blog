import {Component, OnInit} from "@angular/core";
import {HttpService} from "../provider/HttpService";
import "rxjs/add/operator/toPromise"

@Component({
    selector: "blog_app",
    template: require('./app.component.html')
})
export class AppComponent implements OnInit{
    private text:string;
    ngOnInit(): void {
        console.log('hi');
        this.httpService.get("/getMainText").toPromise().then(
            result => {
                this.text = result.json().text
            },
            error => {
                this.text = error.toString()
            }
        )
    }
    constructor(private httpService: HttpService){

    }
}
