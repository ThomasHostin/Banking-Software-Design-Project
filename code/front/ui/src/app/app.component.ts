import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  cpt : number = 0;
  currentUserImageList : any;
  imageList : any;

  getCpt(){
    let appC = localStorage.getItem('app-cpt');
    if (appC !== null){
      this.cpt = parseInt(appC);
    } else {
      this.cpt = 0;
    }
  }

  cptUp(){
    this.getCpt();
    this.cpt = this.cpt + 1;
    this.saveCpt();
  }

  cptDown() {
    this.getCpt();
    if (this.cpt <= 0){
      this.cpt = 0;
    } else {
      this.cpt = this.cpt -1;
    }
    this.saveCpt();
  }

  cptReset() {
    this.getCpt()
    this.cpt = 0;
    this.saveCpt();
  }
  saveCpt(){
    localStorage.setItem('app-cpt', `${this.cpt}`);
  }

  addUserImage(userImage:any){
    this.currentUserImageList = this.currentUserImageList.push(userImage);
  }

  addImage(image : any){
    this.imageList = this.imageList.push(image);
  }

}
