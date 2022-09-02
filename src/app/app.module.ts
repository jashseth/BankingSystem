import { GlobalConstants } from 'src/app/model/globa-constants';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OpenAccountComponent } from './components/open-account/open-account.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AccountStatementComponent } from './components/account-statement/account-statement.component';
import { SetNewPasswordComponent } from './components/set-new-password/set-new-password.component';
import { AddNewBeneficiaryComponent } from './components/add-new-beneficiary/add-new-beneficiary.component';
import { RtgsPaymentComponent } from './components/rtgs-payment/rtgs-payment.component';
import { NeftPaymentComponent } from './components/neft-payment/neft-payment.component';
import { ImpsPaymentComponent } from './components/imps-payment/imps-payment.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { AccountDetailsComponent } from './components/account-details/account-details.component';
import { AccountSummaryComponent } from './components/account-summary/account-summary.component';
import { ValidateTransactionComponent } from './components/validate-transaction/validate-transaction.component';
import { UserloginComponent } from './components/userlogin/userlogin.component';
import { HomeComponent } from './components/home/home.component';
import { AdminapprovalComponent } from './components/adminapproval/adminapproval.component';
import { NavBarHomeComponent } from './components/nav-bar-home/nav-bar-home.component';
import { ChangeidpasswordComponent } from './components/changeidpassword/changeidpassword.component';
import { ForgotUserComponent } from './components/forgot-user/forgot-user.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { SignedoutComponent } from './components/signedout/signedout.component';
import { BackButtonDisableModule } from 'angular-disable-browser-back-button';
import { AdminComponent } from './components/admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    OpenAccountComponent,
    DashboardComponent,
    AccountStatementComponent,
    SetNewPasswordComponent,
    AddNewBeneficiaryComponent,
    RtgsPaymentComponent,
    NeftPaymentComponent,
    ImpsPaymentComponent,
    NavBarComponent,
    UserProfileComponent,
    AccountDetailsComponent,
    AccountSummaryComponent,
    ValidateTransactionComponent,
    UserloginComponent,
    HomeComponent,
    AdminapprovalComponent,
    NavBarHomeComponent,
    ChangeidpasswordComponent,
    ForgotUserComponent,
    ForgotPasswordComponent,
    SignedoutComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BackButtonDisableModule.forRoot({
      preserveScrollPosition: true,
    }),
  ],
  providers: [
    GlobalConstants,
    { provide: HomeComponent, useClass: HomeComponent },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
