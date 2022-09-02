import { Component, OnInit } from '@angular/core';
import { GlobalConstants } from 'src/app/model/globa-constants';
import { Sisodetails } from 'src/app/model/sisodetails';

@Component({
  selector: 'app-signedout',
  templateUrl: './signedout.component.html',
  styleUrls: ['./signedout.component.css'],
})
export class SignedoutComponent implements OnInit {
  sotime: any;
  litime: any;
  accno: number;

  constructor() {
    this.sotime = Sisodetails.signouttime;
    this.litime = Sisodetails.logintime;
    this.accno = GlobalConstants.AccountNumber;
    GlobalConstants.AccountNumber = null;
  }

  ngOnInit(): void {}
}
