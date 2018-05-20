import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';


import {MessageService} from './message.service';
import {Blog, User} from "../models/models";

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'})
};

@Injectable({providedIn: 'root'})
export class AuthService {

    private token = "";

    constructor(
        private http: HttpClient,
        private messageService: MessageService) {
    }

    private url(): string {
        return (<any>window).urlPrefix;
    }

    isSigned(): boolean{
        return this.token !== "";
    }

    assignToken(token: string){
        this.token = token
    }

    /** POST: add a new user to the server */
    registerUser(user: User): Observable<any> {
        return this.http.post<Blog>(this.url()+"register", user, httpOptions).pipe(
            tap((userMiddle: User) => this.log(`added blog w/ id=${userMiddle.id}`)),
            catchError(this.handleError<User>('addblog'))
        );
    }

    /** POST: add a new user to the server */
    loginUser(user: User): Observable<any> {
        return this.http.post<User>(this.url()+"login", user, httpOptions).pipe(
            tap((userMiddle: User) => this.log(`added blog w/ id=${userMiddle.id}`)),
            catchError(this.handleError<User>('addblog'))
        );
    }

    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {

            // TODO: send the error to remote logging infrastructure
            console.error(error); // log to console instead

            // TODO: better job of transforming error for user consumption
            this.log(`${operation} failed: ${error.message}`);

            // Let the app keep running by returning an empty result.
            return of(result as T);
        };
    }

    /** Log a userService message with the MessageService */
    private log(message: string) {
        this.messageService.add('blogService: ' + message);
    }
}
