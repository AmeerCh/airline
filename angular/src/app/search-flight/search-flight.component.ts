import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {
  flight;

  constructor() {
    this.flight = JSON.parse (localStorage.getItem('searchFlight'));
    // console.log(this.flight);

  }

  ngOnInit() {
  }

}
