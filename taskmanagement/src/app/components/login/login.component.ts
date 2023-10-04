import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string='';
  password: string='';

  constructor(private userService: UserService, private router: Router) { }

  login() {
    this.userService.getUserByUsername(this.username).subscribe(
      (user) => {
        if (user && user.password === this.password) {
          console.log('Login successful');
          // Redirect the user to the desired page after successful login
          this.router.navigate(['/dashboard']);
        } else {
          console.log('Login failed');
          
        }
      },
      (error) => {
        console.log('Error retrieving user:', error);
      
      }
    );
  }
}
