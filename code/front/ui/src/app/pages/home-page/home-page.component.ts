import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { ImageService } from 'src/app/services/image.service';
import { ProfilePageComponent } from '../profile-page/profile-page.component';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  returnUrl : string = '';
  innerHtml : string = '';

  constructor(
        private router: Router,
        private route: ActivatedRoute,
        private imageService: ImageService,
        private app : AppComponent,
        private user : ProfilePageComponent
        ) { }

  ngOnInit(): void {
    // localStorage.removeItem('currentUser');
    let howMany = 1;
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';
    // this.imageService.getLatestImage(howMany)
    // .pipe(first())
    // .subscribe(
    //   (data => {
    //     this.image = data.toString();
    //   }),
    //   (error => {
    //     console.log(error);
    //   }));
      
    
  }


  goToLogin(): void {
    this.router.navigate(['/login']);
  }

  goToRegister(): void {
    this.router.navigate(['/register']);
  }
}
