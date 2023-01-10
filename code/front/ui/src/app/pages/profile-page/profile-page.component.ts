import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AppComponent } from 'src/app/app.component';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {
  username : any;
  imageBase64 : string = '';
  HtmlCode : string = '';
  file : any;
  cpt : number = 0;

  constructor(
    private router: Router,
    private userService: UserService,
    private toastr: ToastrService,
    private app : AppComponent
    ) { }

  ngOnInit(): void {
    this.username = localStorage.getItem('currentUser');
  }

  goToHomePage() {
    let localName = localStorage.getItem('currentUser');
    
    if (localName !== null) {
      this.username = localName;
      this.router.navigate(["/home/connected"])
    } else {
      this.router.navigate(['/login'])
    }
  }

    logout(username : string): void {
    console.log("logout")
    let user: User = this.userService.getUser(username);
    this.userService.logout(user) as any;
    this.router.navigate(["/login"])
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
        // let link = document.createElement("a");
        // // set the href and download properties of the "a" element
        // link.href = this.imageBase64;
        // link.download = this.file.name;
        // // simulate a click event on the "a" element
        // link.click();
    };
  }

    cptUp(){
    this.cpt = this.cpt + 1;
  }

  cptDown() {
    if (this.cpt <= 0){
      this.cpt = 0;
    } else {
      this.cpt = this.cpt -1;
    }
  }

  cptReset() {
    this.cpt = 0;
  }

  


}
