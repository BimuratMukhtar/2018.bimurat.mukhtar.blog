import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';


import {MessageService} from './message.service';
import {Blog} from "../models/models";

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({providedIn: 'root'})
export class BlogService {

    private blogesUrl = 'api/bloges';  // URL to web api

    constructor(
        private http: HttpClient,
        private messageService: MessageService) {
    }

    /** GET bloges from the server */
    getBlogs(): Observable<Blog[] | {}> {
        return this.http.get<Blog[]>(this.blogesUrl)
            .pipe(
                tap(bloges => this.log(`fetched bloges`)),
                catchError(this.handleError('getBlogs', []))
            );
    }

    /** GET blog by id. Return `undefined` when id not found */
    getBlogsNo404<Data>(id: number): Observable<Blog | {}> {
        const url = `${this.blogesUrl}/?id=${id}`;
        return this.http.get<Blog[]>(url)
            .pipe(
                map(bloges => bloges[0]), // returns a {0|1} element array
                tap(h => {
                    const outcome = h ? `fetched` : `did not find`;
                    this.log(`${outcome} blog id=${id}`);
                }),
                catchError(this.handleError<Blog>(`getblog id=${id}`))
            );
    }

    /** GET blog by id. Will 404 if id not found */
    getBlog(id: number): Observable<Blog | {}> {
        const url = `${this.blogesUrl}/${id}`;
        return this.http.get<Blog>(url).pipe(
            tap(_ => this.log(`fetched blog id=${id}`)),
            catchError(this.handleError<Blog>(`getBlog id=${id}`))
        );
    }

    /* GET bloges whose name contains search term */
    searchBloges(term: string): Observable<Blog[] | {}> {
        if (!term.trim()) {
            // if not search term, return empty blog array.
            return of([]);
        }
        return this.http.get<Blog[]>(`${this.blogesUrl}/?name=${term}`).pipe(
            tap(_ => this.log(`found bloges matching "${term}"`)),
            catchError(_ => this.handleError<Blog[]>('searchbloges', []))
        );
    }

    //////// Save methods //////////

    /** POST: add a new blog to the server */
    addBlog(blog: Blog): Observable<any> {
        return this.http.post<Blog>(this.blogesUrl, blog, httpOptions).pipe(
            tap((blog: Blog) => this.log(`added blog w/ id=${blog.id}`)),
            catchError(this.handleError<Blog>('addblog'))
        );
    }

    /** DELETE: delete the blog from the server */
    deleteBlog(blog: Blog | number): Observable<Blog | {}> {
        const id = typeof blog === 'number' ? blog : blog.id;
        const url = `${this.blogesUrl}/${id}`;

        return this.http.delete<Blog>(url, httpOptions).pipe(
            tap(_ => this.log(`deleted blog id=${id}`)),
            catchError(this.handleError<Blog>('deleteblog'))
        );
    }

    /** PUT: update the blog on the server */
    updateBlog(blog: Blog): Observable<any> {
        return this.http.put(this.blogesUrl, blog, httpOptions).pipe(
            tap(_ => this.log(`updated blog id=${blog.id}`)),
            catchError(this.handleError<any>('updateblog'))
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

    /** Log a blogService message with the MessageService */
    private log(message: string) {
        this.messageService.add('blogService: ' + message);
    }
}
