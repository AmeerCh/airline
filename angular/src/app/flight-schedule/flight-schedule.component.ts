import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirlineService } from '../airline.service';


@Component({
  selector: 'app-flight-schedule',
  templateUrl: './flight-schedule.component.html',
  styleUrls: ['./flight-schedule.component.css']
})
export class FlightScheduleComponent implements OnInit {


  details;
  flight: Flight[];
  UserDetails = null;
  User = '';
  authentication: Authentication[];
  constructor(private service: AirlineService, private route: Router) {
   this.getAllFlights();

  }

  ngOnInit() {
    let role;
    role = JSON.parse(localStorage.getItem('LoginDetails'));
    this.UserDetails = role.authentication[0].role;
  }
  getAllFlights() {
    this.service.flightDetails().subscribe(data => {
      console.log(data);
      this.details = data;
      if ( data.statusCode === 200 ) {
        this.flight = data.flight;
      }

    });
  }

  deleteFlight(flightId) {
    this.service.deleteFlightApi(flightId).subscribe(data => {
      this.getAllFlights();
    });
  }

  bookTicket(flights) {
    this.route.navigate(['/flight-booking-form', flights]);
  }


  updateFlight(flights) {
    this.route.navigate(['/update-flight', flights]);
  }
}
