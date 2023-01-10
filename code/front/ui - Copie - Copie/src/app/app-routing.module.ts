import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { NotFoundPageComponent } from './pages/not-found-page/not-found-page.component';
import { AuthGuard } from 'src/app/guards/auth.guard';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { HomePageConnectedComponent } from './pages/home-page-connected/home-page-connected.component';
import { ProfilePageComponent } from './pages/profile-page/profile-page.component';
import { User } from './models/user';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'login', component: LoginPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: 'home', component: HomePageComponent},
  { path: 'home/connected', component: HomePageConnectedComponent},
  { path: `profile/:username`, component: ProfilePageComponent},
  { path: '**', component: NotFoundPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
