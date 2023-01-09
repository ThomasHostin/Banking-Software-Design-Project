import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Image } from 'src/app/models/image';
import { ImageService } from 'src/app/services/image.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  returnUrl : string = '';
  images : Image[] = [];

  constructor(
        private router: Router,
        private route: ActivatedRoute,
        private imageService: ImageService
        ) { }

  ngOnInit(): void {
    // let howMany = 10;
    // this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';
    // this.images = this.imageService.getLatestImage(howMany);
  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }

  goToRegister(): void {
    this.router.navigate(['/register']);
  }
}
