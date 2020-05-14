import { Hospital } from './../models/hospital';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  private hospitals: Hospital[] = [
    new Hospital(10, "Saint Evee", "321 88th St", "denver", "CO", 80218),
    new Hospital(11, "Mercy Hercy", "822 4th blvd", "OKC", "OK", 80218),
    new Hospital(12, "red cross", "4th Circle", "Dallas", "TX", 80218)
  ];

  private url = 'api/hospital'

  constructor(private http: HttpClient) { }

  // getting hopsital data
  index() : Observable<any> {
    // returns a defensive copy of the private array
    return this.http.get<any[]>(this.url).pipe(
      catchError(this.handleError)
    );
  }

  show(id: number) : Observable<any> {
    return this.http.get<any>(this.url + '/' + id).pipe(
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

  // creating
  create(hospital: Hospital) : Observable<any> {
    return this.http.post<any>(this.url, hospital, this.httpOptions).pipe(
      catchError(this.handleError)
    );
   // this.hospitals.push(hospital);
  };

  // updating
  update(id: number, hospital: Hospital) : Observable<any> {
    return this.http.put<any>(this.url + '/' + id, hospital, this.httpOptions).pipe(
      catchError(this.handleError)
    );
  }

  // removing data
  destroyHospital(hospitalId : number) : Observable<any> {
    return this.http.delete<any>(this.url + '/' + hospitalId, this.httpOptions).pipe(
      catchError(this.handleError)
    );
    // for (let i = 0; i < this.hospitals.length; i++) {
    //   const hopsital = this.hospitals[i];
    //   if (hopsital.id == hospitalId){
    //     this.hospitals.splice(i, 1);
    //     return true;
    //   }

    // }
    // // didnt find the hospital id
    // return false;
  }

  handleError(error: any) {
    console.error('Something Broke');
    return throwError(error.json().error || 'Server Error');
  }

}
