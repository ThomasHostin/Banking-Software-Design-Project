import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string;
  password: string;

  constructor(private router: Router) {
    this.email = '';
    this.password = '';
  }

  login() {
    // Valider les données de connexion et rediriger vers la page d'accueil si la connexion est réussie
  }
}
