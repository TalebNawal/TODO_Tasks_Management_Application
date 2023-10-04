import { Component } from '@angular/core';
import { User } from 'src/app/interface/user.interface';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  username: string='';
  password: string='';
  confirmPassword: string='';

  constructor(private userService: UserService) { }

  register() {
    if (this.password !== this.confirmPassword) {
      console.log('Passwords do not match');
      // Display an error message to the user
      return;
    }

    const user: User = {
      username: this.username,
      password: this.password,
      id: ''
    };

    this.userService.createUser(user).subscribe(
      (createdUser: User) => {
        console.log('Registration successful');
        // Redirect the user to the desired page after successful registration
      },
      (error: any) => {
        console.log('Registration failed:', error);
        // Display an error message to the user
      }
    );
  }
}
