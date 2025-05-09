import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user/user.component';
import { RegisterBankComponent } from './RBI/register-bank/register-bank.component';
import { UpdateBankComponent } from './RBI/update-bank/update-bank.component';
import { UserLoginComponent } from './user/user-login/user-login.component';
import { UserRegisterComponent } from './user/user-register/user-register.component';
import { HttpClientModule } from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import { DashboardComponent } from './RBI/dashboard/dashboard.component';
import { AllBankComponent } from './RBI/all-bank/all-bank.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    RegisterBankComponent,
    UpdateBankComponent,
    UserLoginComponent,
    UserRegisterComponent,
    DashboardComponent,
    AllBankComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
