import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Sisodetails } from 'src/app/model/sisodetails';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  login=true;

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  Signout() {
    Sisodetails.signouttime=new Date();
    this.router.navigate(['/signedout']);
  }
}
