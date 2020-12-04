import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-add-flight-schedule',
  templateUrl: './add-flight-schedule.component.html',
  styleUrls: ['./add-flight-schedule.component.css']
})
export class AddFlightScheduleComponent implements OnInit {

  addFlight = new FormGroup({});
  message: string;
  constructor(private fb: FormBuilder, private service: AirlineService) { }

  ngOnInit() {
    this.addFlight = this.fb.group({
      source: this.fb.control('', [Validators.required]),
      flightDay: this.fb.control('', [Validators.required]),
      takeOffTime: this.fb.control('', [Validators.required]),
      destination: this.fb.control('', [Validators.required]),
      priceOfFlight: this.fb.control('', [Validators.required]),
      arivalTime: this.fb.control('', [Validators.required])

    });
  }

  addFlightSchedule(addFlight) {
    this.service.addFlightSchedule(addFlight.value).subscribe(data => {
      console.log(data);
      this.message = 'Flight added successfully';
      this.addFlight.reset();
    });

  }

}
