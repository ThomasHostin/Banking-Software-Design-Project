import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { first, Observable } from 'rxjs';
import { Image } from 'src/app/models/image';
import { ImageService } from 'src/app/services/image.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  returnUrl : string = '';
  innerHtml : string = '';
  image :string = '';

  constructor(
        private router: Router,
        private route: ActivatedRoute,
        private imageService: ImageService,
        ) { }

  ngOnInit(): void {
    let howMany = 1;
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';
    this.imageService.getLatestImage(howMany)
    .pipe(first())
    .subscribe(
      (data: any) => {
        this.image = data.imageData;
      }
    );
    console.log(this.image);
  }


  goToLogin(): void {
    this.router.navigate(['/login']);
  }

  goToRegister(): void {
    this.router.navigate(['/register']);
  }
}
