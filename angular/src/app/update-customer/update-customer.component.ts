import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  update = new FormGroup({});
  message: string;
  cId;
  name;
  dob;
  add;
  coun;
  nation;
  phone;
  mail;
  pass;
  data;
  constructor(private fb: FormBuilder, private service: AirlineService, private router: ActivatedRoute) { }

  ngOnInit() {
    this.update = this.fb.group({
      customerId: this.fb.control('', [Validators.required]),
      customerName: this.fb.control('', [Validators.required]),
      customerDOB: this.fb.control('', [Validators.required]),
      phoneNumber: this.fb.control('', [Validators.required]),
      country: this.fb.control('', [Validators.required]),
      email: this.fb.control('', [Validators.required]),
      address: this.fb.control('', [Validators.required]),
      nationality: this.fb.control('', [Validators.required]),
      password: this.fb.control('', [Validators.required])
    });

    this.router.paramMap.subscribe(params => {
      this.data = params;
      this.cId = this.data.params.customerId;
      this.name = this.data.params.customerName;
      this.dob = this.data.params.customerDOB;
      this.add = this.data.params.address;
      this.coun = this.data.params.country;
      this.nation = this.data.params.nationality;
      this.phone = this.data.params.phoneNumber;
      this.mail = this.data.params.email;
      this.pass = this.data.params.password;
    });

  }

  updateCustomer(update) {
     this.service.updateCustomerApi(update.value).subscribe( data => {
     console.log(data);
     this.message = 'customer updated successfully';
     this.update.reset();
     });

  }
}
