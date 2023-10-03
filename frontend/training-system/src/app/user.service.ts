// user.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8086/api/users'; // Replace with your backend URL

  constructor(private http: HttpClient) { }

  createUser(user: User) {
    return this.http.post(`${this.baseUrl}`, user);
  }
}