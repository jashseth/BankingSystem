import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Approval } from 'src/app/model/approval.model';
import { GlobalConstants } from 'src/app/model/globa-constants';
import { BankingService } from 'src/app/service/banking.service';

@Component({
  selector: 'app-adminapproval',
  templateUrl: './adminapproval.component.html',
  styleUrls: ['./adminapproval.component.css']
})
export class AdminapprovalComponent implements OnInit {

  clist!: Approval[];

  constructor(private bankingService: BankingService, public global: GlobalConstants, private router: Router) {
    this.bankingService.getApprovalList().subscribe(data => this.clist = data);
  }

  ngOnInit(): void {
    
  }

  approveCust(e: Approval) {
    e.status = 1;
    console.log(e);
    this.bankingService.approveCust(e).subscribe(data => {
      this.clist = this.clist.filter(u => u !== e);
    });
    alert("Customer Id: " + e.customerId + "sent to " + e.firstName + " " + e.lastName + "(" + e.mobileNumber + ")");
    this.router.navigate(['adminapproval']);
  }

  deleteCust(e: Approval) {
    let result = confirm('Do you want to delete the user?')
    if (result) {
      this.bankingService.deleteCust(e)
        .subscribe(data => {
          this.clist = this.clist.filter(u => u !== e);
        });
    }

  }
}