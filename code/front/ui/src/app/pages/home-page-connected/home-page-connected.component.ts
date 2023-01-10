import { Component, ElementRef, inject, OnInit, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AppComponent } from 'src/app/app.component';
import { ImageModel } from 'src/app/models/image-model';
import { User } from 'src/app/models/user';
import { UserLogin } from 'src/app/models/UserLogin';
import { ImageService } from 'src/app/services/image.service';
import { UserService } from 'src/app/services/user.service';
import { ProfilePageComponent } from '../profile-page/profile-page.component';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page-connected.component.html',
  styleUrls: ['./home-page-connected.component.css']
})
export class HomePageConnectedComponent implements OnInit {
  username : any;  
  image : string = '';
  file:any;
  imageBase64 : string = '';
  HtmlCode : string = '';  
  @ViewChild('injection', {static: false}) elementInjection: any;

  constructor(
    private router: Router,
    private userService: UserService,
    private toastr: ToastrService,
    private imageService: ImageService,
    private app : AppComponent,
    private user : ProfilePageComponent
    ) { }

  ngOnInit(): void {
    let i = 0;
    let localName = localStorage.getItem('currentUser');
    if (localName !== null){
      this.username = localName;
    }
    // this.app.currentUserImageList = localStorage.getItem(`image-${this.username}`);
    // this.app.imageList = localStorage.getItem('imageList');

    console.log(this.app.cpt);
    console.log("ngOnInit: localStorage.getItem = "+this.username);

    this.app.getCpt();
    if (this.app.cpt > 0){
      for (i=0; i<this.app.cpt; i = i+1){
        let data = localStorage.getItem(`image-${i}`);
        if(data !== null){
          this.inject(data);
        }
        
      }
    }
    

  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }

  logout(username : string): void {
    let user: User = this.userService.getUser(username);
    this.userService.logout(user) as any;
    this.router.navigate(["/login"])
  }

  goToProfile(username: string): void {
    let currentUser = localStorage.getItem('currentUser');
    if (currentUser !== null) {
      this.username = currentUser;
      this.router.navigate(['/profile', this.username]);
    } else {
      this.router.navigate(['/login'])
    }
    
  }

  goToHomePage() {
    let currentUser = localStorage.getItem('currentUser');
    if (currentUser !== null) {
      this.username = currentUser;
      this.router.navigate(["/home/connected"])
    } else {
      this.router.navigate(['/login'])
    }
  }

  getImage(event : any){
    let currentUser = localStorage.getItem('currentUser');
    if (currentUser !== null){
      this.username = currentUser;
    }
    this.file = event.target.files[0];
    
    const reader = new FileReader();

    // Lire les données en base64
    reader.readAsDataURL(this.file);

    // Définir une fonction pour gérer la fin de la lecture
    reader.onload = () => {
        // affecter la chaîne de l'image en base64 à la propriété imageBase64
        this.imageBase64 = reader.result as string;
        this.app.cptUp();
        this.user.cptUp();

        // if (this.app.currentUserImageList !== null){
        //   this.app.currentUserImageList = this.app.currentUserImageList.push(this.imageBase64);
        //   this.app.imageList = this.app.imageList.push(this.imageBase64);
        // } else {
        //   this.app.currentUserImageList = [this.imageBase64];
        //   this.app.imageList = [this.imageBase64];
        // }
               
        localStorage.setItem(`image-${currentUser}-${this.user.cpt}`, this.imageBase64);
        localStorage.setItem(`image-${this.app.cpt}`, this.imageBase64);

    };
    }

    inject(data : any ){
      this.HtmlCode = `
      <li id="injection"></li>
      <li id="li-image-${this.app.cpt}">
        <div class="latest-image" id="image-1">
          <img [src]="data" *ngIf="data"/>
        </div>
      </li>`;
      this.elementInjection.nativeElement.innerHTML = this.HtmlCode;
    }
}

