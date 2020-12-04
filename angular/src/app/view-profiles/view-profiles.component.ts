import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-view-profiles',
  templateUrl: './view-profiles.component.html',
  styleUrls: ['./view-profiles.component.css']
})
export class ViewProfilesComponent implements OnInit {
customer;
customerDetails;

  constructor(private service: AirlineService, private route: Router) {


   }

  ngOnInit() {
    this.customerDetails = JSON.parse(localStorage.getItem('viewProfile'));
    this.customer = this.customerDetails.customer[0];
    console.log(this.customer);
  }



  deleteProfile(customerId) {
    this.service.deleteCustomerApi(customerId).subscribe(data => {

    });
  }


  updateCustomer() {
    // localStorage.setItem('updateCustomer', JSON.stringify(customers));
    this.route.navigate(['/update-customer', this.customer]);
  }
}
