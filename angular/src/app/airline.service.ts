import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  constructor(private http: HttpClient) { }


  // authentication services
  authentication(email, password): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/login/${email}/${password}`);
  }


  // customer services
  addCustomer(regForm) {
    return this.http.post(`http://localhost:8080/add-customer`, regForm);

  }
  getAllCustomers(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/customers`);
  }

  deleteCustomerApi(id) {
    return this.http.delete(`http://localhost:8080/customer/${id}`);
  }

  updateCustomerApi(update) {
    return this.http.put(`http://localhost:8080/customer`, update);
  }

  viewProfile(email, password) {
    return this.http.get(`http://localhost:8080/customer/${email}/${password}`);
  }

//  Flight services

  addFlightSchedule(addFlight) {
    return this.http.post(`http://localhost:8080/add-flight`, addFlight);
  }
  flightDetails(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/flights`);
  }

  searchFlightDetails(from, to, day): Observable<any> {
    return this.http.get(`http://localhost:8080/search-flight/${from}/${to}/${day}`);
  }

  deleteFlightApi(id) {
    return this.http.delete(`http://localhost:8080/delete-flight/${id}`);
  }

  updateFlightApi(flight) {
    return this.http.put(`http://localhost:8080/update-flight`, flight);
  }

  // ticket services
  getAllTickets(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/all-booked-tickets`);
  }

  bookTicketApi(bookTicket) {
    return this.http.post(`http://localhost:8080/ticket-booking`, bookTicket);
  }

  deleteTicket(id) {
    return this.http.delete(`http://localhost:8080/cancle-booked-ticket/${id}`);
  }
}
