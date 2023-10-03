import { Component } from '@angular/core';
import { User } from './user.model';
import { UserService } from './user.service';
import { trigger, state, style, animate, transition } from '@angular/animations';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  animations: [
    trigger('fadeInOut', [
      state('void', style({
        opacity: 0
      })),
      transition('void <=> *', animate(500)),
    ]),
    trigger('hovered', [
      state('true', style({
        transform: 'scale(1.1)',
      })),
      state('false', style({
        transform: 'scale(1)',
      })),
      transition('true <=> false', animate('200ms ease-in-out')),
    ])
  ]
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  loginType: string;
  errorMessage: string = '';
  successMessage: string = '';

  hoverState = {
    loginType: false,
    username: false,
    password: false,
    login: false,
  };
  title: any;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  setHovered(field: string, value: boolean) {
    this.hoverState[field] = value;
  }

  isHovered(field: string) {
    return this.hoverState[field];
  }

  onSubmit() : void {

    this.userService.login(this.username,this.password).subscribe(
      (response : string) => {
        if(response){
          console.log('Login success', response);
          this.successMessage = 'Login successfully';
          this.router.navigate(['login']);
          this.errorMessage = null;
        }else{
          console.error('Cannot login');
          this.errorMessage = 'Error creating user. Please try again.';
          this.successMessage = null;
        }
      },
      (error) => {
        console.error('Error creating user:', error);
        this.errorMessage = 'Error creating user. Please try again.';
        this.successMessage = null;
      }
    );
    
  }

}
