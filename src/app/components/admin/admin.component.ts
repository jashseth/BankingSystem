import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit {
  adminid = '';
  adminpassword = '';
  constructor(private router: Router) {}

  ngOnInit(): void {}

  verifyUser() {
    if (this.adminid == 'Ram' && this.adminpassword == 'Ram') {
      alert('successfully logedin');
      this.router.navigate(['/adminapproval']);
    } else {
      alert('Username or Password Incorrect');
    }
  }
}
