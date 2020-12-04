import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  from;
  to;
  day;
  flight: Flight[];
  message;
  constructor(private service: AirlineService, private route: Router) { }

  ngOnInit() {
  }

  searchFlight(search) {
    this.from = search.value.flyingFrom;
    this.to = search.value.movingTo;
    this.day = search.value.flightDay;
    this.service.searchFlightDetails(this.from, this.to, this.day).subscribe(data => {
      console.log(data);
      if ( data.statusCode === 200 ) {
        this.flight = data.flight;
        localStorage.setItem('searchFlight', JSON.stringify(this.flight));
        this.route.navigateByUrl('search-flight');
      } else {
        this.message = 'Sorry! There is no lights available on that day.';

      }
    });
  }
}
