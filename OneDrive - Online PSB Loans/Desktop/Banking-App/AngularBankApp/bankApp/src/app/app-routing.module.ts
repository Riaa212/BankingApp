import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserLoginComponent } from './user/user-login/user-login.component';
import { UserRegisterComponent } from './user/user-register/user-register.component';
import { BankService } from './services/bank.service';
import { RegisterBankComponent } from './RBI/register-bank/register-bank.component';
import { UpdateBankComponent } from './RBI/update-bank/update-bank.component';
import { DashboardComponent } from './RBI/dashboard/dashboard.component';
import { UserComponent } from './user/user/user.component';
import { AllBankComponent } from './RBI/all-bank/all-bank.component';

const routes: Routes = [
  {path:'Userlogin',component:UserLoginComponent},
  {path:'userRegister',component:UserRegisterComponent},
  {path:'Registerbank',component:RegisterBankComponent},
  {path:'updateBank',component:UpdateBankComponent},
  {path:'user',component:UserComponent},
  {path:'allBank',component:AllBankComponent},
  {path:'',component:DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
