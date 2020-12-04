import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { from } from 'rxjs';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  regForm = new FormGroup({});
  message: string;
  constructor(private fb: FormBuilder, private service: AirlineService) { }

  ngOnInit() {
      this.regForm = this.fb.group({
      customerName: this.fb.control('', [Validators.required]),
      customerDOB: this.fb.control('', [Validators.required]),
      phoneNumber: this.fb.control('', [Validators.required]),
      country: this.fb.control('', [Validators.required]),
      email: this.fb.control('', [Validators.required, Validators.email]),
      address: this.fb.control('', [Validators.required]),
      nationality: this.fb.control('', [Validators.required]),
      password: this.fb.control('', [Validators.required])
    });
  }

  addCustomer(regForm) {
    this.service.addCustomer(regForm.value).subscribe(data => {
      console.log(data);

      this.message = 'Thanks for Registration';
      this.regForm.reset();
    });
  }

}
