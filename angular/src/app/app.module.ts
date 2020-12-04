import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { FlightScheduleComponent } from './flight-schedule/flight-schedule.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { FlightBookingFormComponent } from './flight-booking-form/flight-booking-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { ViewProfilesComponent } from './view-profiles/view-profiles.component';
import { ViewticketsComponent } from './viewtickets/viewtickets.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { AddFlightScheduleComponent } from './add-flight-schedule/add-flight-schedule.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    AboutusComponent,
    ContactusComponent,
    FlightScheduleComponent,
    AdminloginComponent,
    FlightBookingFormComponent,
    SearchFlightComponent,
    ViewProfilesComponent,
    ViewticketsComponent,
    UpdateCustomerComponent,
    AddFlightScheduleComponent,
    UpdateFlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
