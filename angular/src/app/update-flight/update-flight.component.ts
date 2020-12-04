import { Component, OnInit } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent implements OnInit {
data;
fId;
fDay;
src;
dest;
price;
takeOff;
arival;
message;
  updateFlight = new FormGroup({});
  constructor(private fb: FormBuilder, private service: AirlineService, private router: ActivatedRoute) { }

  ngOnInit() {
    this.updateFlight = this.fb.group({
      flightId: this.fb.control('', [Validators.required]),
      source: this.fb.control('', [Validators.required]),
      takeOffTime: this.fb.control('', [Validators.required]),
      priceOfFlight: this.fb.control('', [Validators.required]),
      flightDay: this.fb.control('', [Validators.required]),
      destination: this.fb.control('', [Validators.required]),
      arivalTime: this.fb.control('', [Validators.required])

    });

    this.router.paramMap.subscribe(params => {
      this.data = params;
      this.fId = this.data.params.flightId;
      this.fDay = this.data.params.flightDay;
      this.src = this.data.params.source;
      this.dest = this.data.params.destination;
      this.takeOff = this.data.params.takeOffTime;
      this.arival = this.data.params.arivalTime;
      this.price = this.data.params.priceOfFlight;
    });
  }

  updateFlightDetails(updateFlight) {
    this.service.updateFlightApi(updateFlight.value).subscribe( data => {
      this.message = 'Flight details are updated successfully.';
      this.updateFlight.reset();
    });
  }

}
