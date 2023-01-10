import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { ImageModel } from '../models/image-model';
import { backendUrl } from '../constants';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  constructor(private http: HttpClient) { }

  getLatestImage(howMany : number) {
    let params = new HttpParams();
    params = params.append('how-many', howMany);
    return this.http.get(backendUrl.imgService.findLatestImage, { params: params });
  }

  getLatestImageByUser(imageUserName : string, untilWhat : number, fromWhich : number){
    let params = new HttpParams();
    params = params.append('imageUserName', imageUserName);
    params = params.append('untilWhat', untilWhat);
    params = params.append('fromWhich', fromWhich);
    return this.http.get<any>(backendUrl.imgService.findLatestImageByUser, { params: params });
  }

  getAllByUser(imageUserName: string){
    let params = new HttpParams();
    params = params.append("image-username", imageUserName);
    return this.http.get<ImageModel[]>(backendUrl.imgService.findAllByUserName, { params: params })
  }

  uploadImage(file : string, imageName : string, imageDescription : string, userName : string){
    let params = new HttpParams();
    params = params.append('image',  file);
    params = params.append('image_name', imageName);
    params = params.append('description', imageDescription);
    params = params.append('image-username', userName);
    return this.http.post<ImageModel>(backendUrl.imgService.upload, { params: params })
  }
}
