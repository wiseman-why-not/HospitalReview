import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Procedure } from './../models/procedure';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MedicalProcedureService {

  private procedures: Procedure[] = [];

  private baseUrl = "http://localhost:8087/";
  private url = this.baseUrl + 'api/procedure';

  constructor(private http: HttpClient) { }

  // getting medical procedure data
  index(): Observable<any>  {
    // returns a defnesive copy of the private array
    return this.http.get<any[]>(this.url + 's').pipe(
      catchError(this.handleError)
    );
  }

  procedureNames() : Observable<any> {
    return this.http.get<any[]>(this.url + 'Names').pipe(
      catchError(this.handleError)
    );
  }

  // sending data
  // if you need to, headers can be added to an HTTP Request by using HttpHeaders Object.
  httpOptions = {
    headers : new HttpHeaders({
      'Content-Type': 'application/json' // ,
      // 'Authorization' : 'my-auth-token'
    })
  };

  handleError(error: any) {
    console.error('Something Broke');
    return throwError(error.json().error || 'Server Error');
  }
}
