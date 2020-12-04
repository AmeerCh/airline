import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-flight-booking-form',
  templateUrl: './flight-booking-form.component.html',
  styleUrls: ['./flight-booking-form.component.css']
})
export class FlightBookingFormComponent implements OnInit {
  bookTicket = new FormGroup({});
  message: string;
  data;
  src;
  dest;
  arival;
  takeOff;
  fId;
  response;
  constructor(private fb: FormBuilder, private service: AirlineService, private router: ActivatedRoute) { }

  ngOnInit() {
    this.bookTicket = this.fb.group({
      source: this.fb.control('', [Validators.required]),
      flightId: this.fb.control('', [Validators.required]),
      takeOffTime: this.fb.control('', [Validators.required]),
      destination: this.fb.control('', [Validators.required]),
      customerId: this.fb.control('', [Validators.required]),
      arivalTime: this.fb.control('', [Validators.required]),
      dateOfBooking: this.fb.control('', [Validators.required])

    });

    this.router.paramMap.subscribe(params => {
      this.data = params;
      this.src = this.data.params.source;
      this.dest = this.data.params.destination;
      this.takeOff = this.data.params.takeOffTime;
      this.arival = this.data.params.arivalTime;
      this.fId = this.data.params.flightId;
    });

  }

  bookTicketForm(bookTicket) {
    this.service.bookTicketApi(bookTicket.value).subscribe(data => {
      console.log(data);
      this.response = data;
      this.message = 'ticket booked successfully.';
      this.bookTicket.reset();
    });
  }

}
