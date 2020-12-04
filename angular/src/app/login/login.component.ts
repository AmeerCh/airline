import { Component, OnInit, Output, EventEmitter  } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private service: AirlineService, private router: Router) { }
message;
email;
password;
authentication: Authentication[];
role;
@Output() ToParent = new EventEmitter<string>();
  ngOnInit() {
  }

  login(form) {
    this.email = form.value.email;
    this.password = form.value.password;

    this.service.viewProfile(this.email, this.password).subscribe( response => {
      console.log(response);

      localStorage.setItem('viewProfile', JSON.stringify(response));
    });

    this.service.authentication(this.email, this.password).subscribe( data => {
    console.log(data);
    if (data.statusCode === 200) {
      this.role = data.authentication[0].role;
      localStorage.setItem('LoginDetails', JSON.stringify(data));
      this.ToParent.emit(this.role);
      this.router.navigate(['/home']);
    } else  {

      this.message = 'Invalid email and password, please try again';
      form.reset();
    }
    });


  }


}


