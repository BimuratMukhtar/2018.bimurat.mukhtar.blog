import {Component} from "@angular/core";
import {Router} from "@angular/router";



@Component({
    selector: "blogs_page",
    template: require("./blogs.component.html"),
    styles: [require('./blogs.component.css')]
})
export class BlogsComponent {

    constructor(private router: Router){}

}