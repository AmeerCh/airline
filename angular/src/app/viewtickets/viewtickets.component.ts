import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-viewtickets',
  templateUrl: './viewtickets.component.html',
  styleUrls: ['./viewtickets.component.css']
})
export class ViewticketsComponent implements OnInit {

  customerDetails;
  customer;
  bookedTicketDetails;
  bookedTicket;
  constructor(private service: AirlineService, private route: Router) {
   }

  ngOnInit() {
    this.customerDetails = JSON.parse(localStorage.getItem('viewProfile'));
    this.customer = this.customerDetails.customer[0];
    console.log(this.customer);
    this.TicketsData();
  }
  TicketsData() {
    this.service.getAllTickets().subscribe( data => {
      console.log(data);
      if (data.statusCode === 200) {
        this.bookedTicketDetails = data.bookedTicket;
        this.bookedTicket = this.bookedTicketDetails.filter(r => r.customerId === this.customer.customerId);

      }
    });
  }

  deleteTicket(ticketId) {
    this.service.deleteTicket(ticketId).subscribe( data => {
      this.TicketsData();
    });
  }
}
