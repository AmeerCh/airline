import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightBookingFormComponent } from './flight-booking-form.component';

describe('FlightBookingFormComponent', () => {
  let component: FlightBookingFormComponent;
  let fixture: ComponentFixture<FlightBookingFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlightBookingFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightBookingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
