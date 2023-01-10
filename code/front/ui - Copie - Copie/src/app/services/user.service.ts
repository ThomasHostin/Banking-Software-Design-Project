import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

import { User } from '../models/user';
import { backendUrl } from '../constants';
import { UserRequestVo } from '../models/userRequestVo';
import { map } from 'rxjs/operators';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) { }

  register(user: User) {
    console.log(user)
    return this.http.post(backendUrl.authService.register, user) as any;
  }

  login(UserRequestVo: UserRequestVo) {
    return this.http.post(backendUrl.authService.login, UserRequestVo) as any;
  }

  authenticate(userRequestVo: UserRequestVo) {
    return this.http.post(backendUrl.authService.authenticate, userRequestVo) as any;
  }

  isConnected(userRequestVo: UserRequestVo){
    let params = new HttpParams();
    params = params.append('username', userRequestVo.username);
    params = params.append('password', userRequestVo.password);
    params = params.append('email', '')
    return this.http.get(backendUrl.authService.isConnected, { params: params }) as any;
  }

  logout(user: User){
    if (user.id !== null){
      const params = new HttpParams().set('userId', user.id);
      return this.http.delete(backendUrl.authService.logout, { params }) as any;
     }
    }

  getUser(username: string){
    const params = new HttpParams().set('username', username);
    return this.http.get<User>(backendUrl.authService.getUser, {params}) as any;
  }

  getUserLogin(username : string) {
    let user = this.getUser(username);
    return this.http.get(backendUrl.authService.getUserLogin, user.username) as any;
  }


  
}