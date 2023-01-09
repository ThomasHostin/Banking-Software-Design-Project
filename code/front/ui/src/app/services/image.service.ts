import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Image } from '../models/image';
import { backendUrl } from '../constants';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  constructor(private http: HttpClient) { }

  getLatestImage(howMany : number) {
    let params = new HttpParams();
    params = params.append('how-many', howMany);
    return this.http.get<Image[]>(backendUrl.imgService.findLatestImage, { params: params });
  }

  getLatestImageByUser(imageUserName : string, untilWhat : number, fromWhich : number){
    let params = new HttpParams();
    params = params.append('imageUserName', imageUserName);
    params = params.append('untilWhat', untilWhat);
    params = params.append('fromWhich', fromWhich);
    return this.http.get<Image[]>(backendUrl.imgService.findLatestImageByUser, { params: params });
  }

  getAllByUser(imageUserName: string){
    let params = new HttpParams();
    params = params.append("image-username", imageUserName);
    return this.http.get<Image[]>(backendUrl.imgService.findAllByUserName, { params: params })
  }
}
