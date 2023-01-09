import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';
import { UserRequestVo } from 'src/app/models/userRequestVo';
import { UserLogin } from 'src/app/models/UserLogin';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  loginForm: FormGroup = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  });
  loading = false;
  submitted = false;
  returnUrl: string = '';
  userLogin: UserLogin = new UserLogin;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService,
    private userService: UserService,
  ) { }

  ngOnInit() {
    localStorage.clear();
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';

  }

  // Convenience getter for easy access to form fields
  get f() {
    return this.loginForm.controls;
  }

  onSubmit() {
    this.submitted = true;

    // Exit function if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.userService.login(this.loginForm.value)
      .pipe(first())
      .subscribe(
        (data: any) => {
          localStorage.setItem('currentUser', this.f['username'].value) 
          let user : User = this.userService.getUser(this.f['username'].value);
          console.log(user.username);         
          this.loading = false;
          //localStorage.setItem()
          this.router.navigate(['home/connected']);
        },
        (error: string) => {
          console.log(error)
          this.toastr.error("Incorrect credentials");
          this.loading = false;
        }
      )
  }

  goToHomePage() {
    if (this.userLogin.user.username !== null){
      localStorage.setItem('currentUser', this.f['username'].value)
      this.router.navigate(['/home/connected']);   
    } else {
      let user = this.userService.getUser(this.userLogin.user.username);
      this.userService.logout(user);
      localStorage.clear();
      this.router.navigate(['/home']);
    }
  }

}