import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { FlightScheduleComponent } from './flight-schedule/flight-schedule.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { FlightBookingFormComponent } from './flight-booking-form/flight-booking-form.component';
import { ViewProfilesComponent } from './view-profiles/view-profiles.component';
import { ViewticketsComponent } from './viewtickets/viewtickets.component';
import { AddFlightScheduleComponent } from './add-flight-schedule/add-flight-schedule.component';
import { HeaderComponent } from './header/header.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';


const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'header', component: HeaderComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'aboutus', component: AboutusComponent},
  {path: 'contactus', component: ContactusComponent},
  {path: 'flight-schedule', component: FlightScheduleComponent},
  {path: 'adminlogin', component: AdminloginComponent},
  {path: 'flight-booking-form', component: FlightBookingFormComponent},
  {path: 'view-profiles', component: ViewProfilesComponent},
  {path: 'viewtickets', component: ViewticketsComponent},
  {path: 'add-flight-schedule', component: AddFlightScheduleComponent},
  {path: 'update-customer', component: UpdateCustomerComponent},
  {path: 'search-flight', component: SearchFlightComponent},
  {path: 'update-flight', component: UpdateFlightComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  FormsModule,
  ReactiveFormsModule,
  HttpClientModule,
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
