import { AddNewBeneficiaryComponent } from './components/add-new-beneficiary/add-new-beneficiary.component';
import { OpenAccountComponent } from './components/open-account/open-account.component';

import { HomeComponent } from './components/home/home.component';
import { UserloginComponent } from './components/userlogin/userlogin.component';
import { ValidateTransactionComponent } from './components/validate-transaction/validate-transaction.component';

import { AccountDetailsComponent } from './components/account-details/account-details.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { RtgsPaymentComponent } from './components/rtgs-payment/rtgs-payment.component';
import { ImpsPaymentComponent } from './components/imps-payment/imps-payment.component';
import { NeftPaymentComponent } from './components/neft-payment/neft-payment.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AccountStatementComponent } from './components/account-statement/account-statement.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountSummaryComponent } from './components/account-summary/account-summary.component';
import { AdminapprovalComponent } from './components/adminapproval/adminapproval.component';
import { ForgotUserComponent } from './components/forgot-user/forgot-user.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { ChangeidpasswordComponent } from './components/changeidpassword/changeidpassword.component';
import { SetNewPasswordComponent } from './components/set-new-password/set-new-password.component';
import { SignedoutComponent } from './components/signedout/signedout.component';
import { BankingService } from './service/banking.service';
import { AdminComponent } from './components/admin/admin.component';

const routes: Routes = [
  { path: 'accountStatement', component: AccountStatementComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'neftTransfer', component: NeftPaymentComponent },
  { path: 'impsTransfer', component: ImpsPaymentComponent },
  { path: 'rtgsTransfer', component: RtgsPaymentComponent },
  { path: 'userProfile', component: UserProfileComponent },
  { path: 'accountDetails', component: AccountDetailsComponent },
  { path: 'accountSummary', component: AccountSummaryComponent },
  { path: 'validateTransaction', component: ValidateTransactionComponent },
  { path: 'login', component: UserloginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'openAccount', component: OpenAccountComponent },
  { path: 'addNewBeneficiary', component: AddNewBeneficiaryComponent },
  { path: 'adminapproval', component: AdminapprovalComponent },
  { path: 'forgotuserid', component: ForgotUserComponent },
  { path: 'forgotpassword', component: ForgotPasswordComponent },
  { path: 'changeidpassword', component: ChangeidpasswordComponent },
  { path: 'setnewpassword', component: SetNewPasswordComponent },
  { path: 'changeidpassword', component: ChangeidpasswordComponent },
  { path: 'signedout', component: SignedoutComponent },
  { path: 'home', component: HomeComponent, canActivate: [BankingService] },
  { path: 'admin', component: AdminComponent },
  {
    path: 'logout',
    component: DashboardComponent,
    canActivate: [BankingService],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
