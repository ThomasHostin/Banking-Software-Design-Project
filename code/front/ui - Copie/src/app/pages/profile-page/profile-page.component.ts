import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  username : string = "";

  constructor(
    private router: Router,
    private userService: UserService,
    private toastr: ToastrService,
    ) { }

  ngOnInit(): void {
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

    logout(username : string): void {
    console.log("logout")
    let user: User = this.userService.getUser(username);
    this.userService.logout(user) as any;
    localStorage.clear();
    this.router.navigate(["/login"])
  }

}
