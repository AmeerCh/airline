import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  role = '';
  authentication: Authentication[];
  NavigateTO = '';
  constructor(private router: Router) {

  }

  ngOnInit() {
  }
  FromChild(event) {
    this.role = event;
    this.NavigateTO = '';
  }
  OnNavigate() {
    this.NavigateTO = 'LoginForm';
  }
  LogOut() {
    this.role = '';
    localStorage.clear();
    this.router.navigate(['/home']);
  }

  enableRoute() {
    this.NavigateTO = '';
  }
}
