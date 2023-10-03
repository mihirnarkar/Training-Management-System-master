// user.service.ts

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { User } from './user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  private loginurl = 'http://localhost:8080/login'; // Replace with your backend URL

  constructor(private http: HttpClient) { }

  // createUser(user: User) {
  //   return this.http.post(`${this.baseUrl}`, user);
  // }


  login(username:String,password:String) : Observable<String>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
  };

  const body = { username: username, password: password };

  return this.http.post<string>(this.loginurl, body, httpOptions);
  }

}