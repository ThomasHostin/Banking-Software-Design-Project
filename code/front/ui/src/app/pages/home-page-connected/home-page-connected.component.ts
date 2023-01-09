import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/models/user';
import { UserLogin } from 'src/app/models/UserLogin';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page-connected.component.html',
  styleUrls: ['./home-page-connected.component.css']
})
export class HomePageConnectedComponent implements OnInit {
  username : string = '';   

  constructor(
    private router: Router,
    private userService: UserService,
    private toastr: ToastrService,
    ) { }

  ngOnInit(): void {
    let currentUser = localStorage.getItem('currentUser');
    console.log("ngOnInit: localStorage.getItem = "+currentUser);
    if (currentUser !== null) {
      this.username = currentUser;
    }
  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }

  logout(username : string): void {
    console.log("logout")
    let user: User = this.userService.getUser(username);
    this.userService.logout(user) as any;
    localStorage.clear();
    this.router.navigate(["/login"])
  }

  goToProfile(username: string): void {
    let currentUser = localStorage.getItem('currentUser');
    if (currentUser !== null) {
      this.username = currentUser;
      this.router.navigate(['/profile', this.username]);
    } else {
      localStorage.clear()
      this.router.navigate(['/login'])
    }
    
  }

  goToHomePage() {
    let currentUser = localStorage.getItem('currentUser');
    if (currentUser !== null) {
      this.username = currentUser;
      this.router.navigate(["/home/connected"])
    } else {
      localStorage.clear()
      this.router.navigate(['/login'])
    }
  }

}
