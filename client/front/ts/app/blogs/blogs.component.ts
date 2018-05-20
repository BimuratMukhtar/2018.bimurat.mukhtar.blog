import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";



@Component({
    selector: "blogs_page",
    template: require("./blogs.component.html"),
    styles: [require('./blogs.component.css')]
})
export class BlogsComponent implements OnInit{

    title = "Angular Blog app";

    constructor(private router: Router){}

    ngOnInit(): void {

    }



    posts = '[\n' +
        '  {\n' +
        '        "title": "Blog Post One",\n' +
        '        "body": [\n' +
        '          "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem deleniti quae, neque libero voluptate maiores ullam unde voluptatem assumenda velit dolores impedit quis qui! Neque, cupiditate labore nulla? Atque, tenetur.",\n' +
        '          "Numquam nobis nam voluptas blanditiis eveniet in quasi possimus voluptatem temporibus doloremque delectus dolorum, voluptatum laborum aut dolorem? In rerum necessitatibus soluta incidunt nihil numquam fugit quas pariatur dolores nesciunt?",\n' +
        '          "Quibusdam placeat quisquam iure repellendus ad in, nihil numquam quaerat, facere alias illo. Tempora perferendis incidunt, ratione eveniet esse earum, corporis sit? Modi enim commodi odio placeat minus, error id?",\n' +
        '          "Corrupti voluptates asperiores ratione laudantium, eveniet molestiae possimus deleniti officia, incidunt quae et. Amet, ducimus eum ipsa reprehenderit ad, et nihil, veritatis ea doloremque ab placeat dolore impedit, quia eius."\n' +
        '        ],\n' +
        '        "author": "Nick Moreton",\n' +
        '        "comments": [\n' +
        '          {\n' +
        '            "body":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos possimus porro earum dolor sint fuga laborum velit laudantium distinctio quos sunt veritatis unde inventore, autem ad tenetur voluptatibus mollitia vel!",\n' +
        '            "author": "trollguy87"\n' +
        '          }\n' +
        '        ],\n' +
        '        "likes":0,\n' +
        '        "image":"http://placekitten.com/g/2000/600",\n' +
        '        "createdOn":1408547127216\n' +
        '  },\n' +
        '  {\n' +
        '        "title": "Blog Post Two",\n' +
        '        "body": [\n' +
        '          "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem deleniti quae, neque libero voluptate maiores ullam unde voluptatem assumenda velit dolores impedit quis qui! Neque, cupiditate labore nulla? Atque, tenetur.",\n' +
        '          "Numquam nobis nam voluptas blanditiis eveniet in quasi possimus voluptatem temporibus doloremque delectus dolorum, voluptatum laborum aut dolorem? In rerum necessitatibus soluta incidunt nihil numquam fugit quas pariatur dolores nesciunt?",\n' +
        '          "Quibusdam placeat quisquam iure repellendus ad in, nihil numquam quaerat, facere alias illo. Tempora perferendis incidunt, ratione eveniet esse earum, corporis sit? Modi enim commodi odio placeat minus, error id?",\n' +
        '          "Corrupti voluptates asperiores ratione laudantium, eveniet molestiae possimus deleniti officia, incidunt quae et. Amet, ducimus eum ipsa reprehenderit ad, et nihil, veritatis ea doloremque ab placeat dolore impedit, quia eius."\n' +
        '        ],\n' +
        '        "author": "Nick Moreton",\n' +
        '        "comments": [\n' +
        '          {\n' +
        '            "body":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos possimus porro earum dolor sint fuga laborum velit laudantium distinctio quos sunt veritatis unde inventore, autem ad tenetur voluptatibus mollitia vel!",\n' +
        '            "author": "trollguy87"\n' +
        '          }\n' +
        '        ],\n' +
        '        "likes":0,\n' +
        '        "image":"http://placekitten.com/g/2000/600",\n' +
        '        "createdOn":1408547127216\n' +
        '  },\n' +
        '\n' +
        '{\n' +
        '        "title": "Blog Post Three",\n' +
        '        "body": [\n' +
        '          "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem deleniti quae, neque libero voluptate maiores ullam unde voluptatem assumenda velit dolores impedit quis qui! Neque, cupiditate labore nulla? Atque, tenetur.",\n' +
        '          "Numquam nobis nam voluptas blanditiis eveniet in quasi possimus voluptatem temporibus doloremque delectus dolorum, voluptatum laborum aut dolorem? In rerum necessitatibus soluta incidunt nihil numquam fugit quas pariatur dolores nesciunt?",\n' +
        '          "Quibusdam placeat quisquam iure repellendus ad in, nihil numquam quaerat, facere alias illo. Tempora perferendis incidunt, ratione eveniet esse earum, corporis sit? Modi enim commodi odio placeat minus, error id?",\n' +
        '          "Corrupti voluptates asperiores ratione laudantium, eveniet molestiae possimus deleniti officia, incidunt quae et. Amet, ducimus eum ipsa reprehenderit ad, et nihil, veritatis ea doloremque ab placeat dolore impedit, quia eius."\n' +
        '        ],\n' +
        '        "author": "Nick Moreton",\n' +
        '        "comments": [\n' +
        '          {\n' +
        '            "body":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos possimus porro earum dolor sint fuga laborum velit laudantium distinctio quos sunt veritatis unde inventore, autem ad tenetur voluptatibus mollitia vel!",\n' +
        '            "author": "trollguy87"\n' +
        '          }\n' +
        '        ],\n' +
        '        "likes":0,\n' +
        '        "image":"http://placekitten.com/g/2000/600",\n' +
        '        "createdOn":1408547127216\n' +
        '  },\n' +
        '\n' +
        '{\n' +
        '        "title": "Blog Post Four",\n' +
        '        "body": [\n' +
        '          "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem deleniti quae, neque libero voluptate maiores ullam unde voluptatem assumenda velit dolores impedit quis qui! Neque, cupiditate labore nulla? Atque, tenetur.",\n' +
        '          "Numquam nobis nam voluptas blanditiis eveniet in quasi possimus voluptatem temporibus doloremque delectus dolorum, voluptatum laborum aut dolorem? In rerum necessitatibus soluta incidunt nihil numquam fugit quas pariatur dolores nesciunt?",\n' +
        '          "Quibusdam placeat quisquam iure repellendus ad in, nihil numquam quaerat, facere alias illo. Tempora perferendis incidunt, ratione eveniet esse earum, corporis sit? Modi enim commodi odio placeat minus, error id?",\n' +
        '          "Corrupti voluptates asperiores ratione laudantium, eveniet molestiae possimus deleniti officia, incidunt quae et. Amet, ducimus eum ipsa reprehenderit ad, et nihil, veritatis ea doloremque ab placeat dolore impedit, quia eius."\n' +
        '        ],\n' +
        '        "author": "Nick Moreton",\n' +
        '        "comments": [\n' +
        '          {\n' +
        '            "body":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos possimus porro earum dolor sint fuga laborum velit laudantium distinctio quos sunt veritatis unde inventore, autem ad tenetur voluptatibus mollitia vel!",\n' +
        '            "author": "trollguy87"\n' +
        '          }\n' +
        '        ],\n' +
        '        "likes":0,\n' +
        '        "image":"http://placekitten.com/g/2000/600",\n' +
        '        "createdOn":1408547127216\n' +
        '  }\n' +
        '\n' +
        '\n' +
        ']'
}