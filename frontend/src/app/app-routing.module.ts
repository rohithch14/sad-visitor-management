// src/app/app-routing.module.ts

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PassRequestListComponent } from './components/pass-request-list/pass-request-list.component';
import { RoleSelectionComponent } from './components/roleselection/roleselection.component';
import {  PassRequestsDetailsComponent } from './components/pass-requests-details/pass-requests-details.component';
import { NewPassRequestComponent } from './components/new-pass-request/new-pass-request.component';

const routes: Routes = [
   { path:'',redirectTo: '/roleselection',pathMatch:'full'},
   { path: 'roleselection', component: RoleSelectionComponent },
  {path: 'pass-requests',component:PassRequestListComponent},
  {path: 'pass-requests-details/:id',component:PassRequestsDetailsComponent},
 // {path: 'pass-requests',component:PassRequestListComponent},
  { path: 'new-pass-request', component: NewPassRequestComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
