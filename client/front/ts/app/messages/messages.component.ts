import { Component, OnInit } from '@angular/core';
import { MessageService } from '../../provider/message.service';

@Component({
    selector: 'app-messages',
    template: require('./messages.component.html'),
    styles: [require("./messages.component.css")]
})
export class MessagesComponent implements OnInit {

    constructor(public messageService: MessageService ) { }

    ngOnInit() {
    }

}
