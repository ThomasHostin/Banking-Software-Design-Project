import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  signup(user: any) {
    return this.http.post('/api/signup', user);
  }

  login(user: any) {
    return this.http.post('/api/login', user);
  }

  logout() {
    return this.http.post('/api/logout', {});
  }

  getCurrentUser() {
    return this.http.get('/api/current-user');
  }
}
