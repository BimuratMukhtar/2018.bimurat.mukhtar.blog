import {Component, OnInit} from "@angular/core";
import {HttpService} from "../provider/HttpService";
import "rxjs/add/operator/toPromise"

@Component({
    selector: "blog_app",
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
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
