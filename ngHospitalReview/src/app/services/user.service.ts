import { Observable, throwError } from 'rxjs';
import { User } from './../models/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // need to get my baseUrl and URL to hit my REST API
  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl + 'api/user'

  // need to inject an HTTPClient to interact with my RESTful API
  constructor(private http : HttpClient) {

  }
  // Sending data
  // if needed, headers can be added to HTTP Request by using HttpHeaders object
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
      // 'Authorization': 'my-auth-token'
    })
  };

  // Geting data
  getAllUsers() : Observable<any> {
    return this.http.get<any[]>(this.url + "s").pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error getting User list');
      })
    );
  }

  GetUserById(id: number) : Observable<any> {
    return this.http.get<any>(this.url + "/" + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error getting user');
      })
    );
  }

  searchUsersByKeyword(keyword: String) : Observable<any> {
    return this.http.get<any[]>(this.url + '/search/' + keyword).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error in retreive a list of Users matching: ' + keyword);
      })
    );
  }

  // Creating Users
  create(user : User) : Observable<any> {
    return this.http.post<any>(this.url, user, this.httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error creating user. In User Service method CREATE!!!!!!');
      })
    );
  }

   // Updating Users
   update(id: number, user : User) : Observable<any>{
    return this.http.post<any>(this.url, user, this.httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error updating user');
      })
    )
  }

   // Deleting User
   delete(id: number) : Observable<any> {
    return this.http.post<any>(this.url + "/" + id, this.httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error deleting user');
      })
    )
  }


}
