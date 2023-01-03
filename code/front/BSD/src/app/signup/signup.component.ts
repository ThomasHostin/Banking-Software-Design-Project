import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  email = '';
  password = '';

  constructor(private router: Router, private userService: UserService) {}

  signup(form: NgForm) {
    this.userService.signup({email : this.email, password:  this.password}).subscribe(
      res => {
        this.router.navigateByUrl('/login');
      },
      err => {
        console.log(err);
      }
    );
  }
}
