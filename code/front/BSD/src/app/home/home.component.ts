import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  bannerImageUrl = '/assets/images/banner.jpg';
  artworks = [
    {
      imageUrl: '/assets/images/artwork1.jpg',
      title: 'Artwork 1'
    },
    {
      imageUrl: '/assets/images/artwork2.jpg',
      title: 'Artwork 2'
    },
    {
      imageUrl: '/assets/images/artwork3.jpg',
      title: 'Artwork 3'
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
