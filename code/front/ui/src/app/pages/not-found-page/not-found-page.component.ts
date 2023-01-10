import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-not-found-page',
  templateUrl: './not-found-page.component.html',
  styleUrls: ['./not-found-page.component.css']
})
export class NotFoundPageComponent implements OnInit {
  public username: string = '';

  constructor(
    private router: Router,
    private userService: UserService,
  ) { }

  ngOnInit(): void {
    let currentUser = localStorage.getItem('currentUser');
    if (currentUser !== null) {
      this.username = currentUser;
    }
  }

  goToHomePage() {
    let currentUser = localStorage.getItem('currentUser');
    if (currentUser!==null){
      this.router.navigate(['/home/connected']);
    } else {
      this.router.navigate(['/home']);
    }
    
  }

}