import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PassRequestListComponent } from './components/pass-request-list/pass-request-list.component';
import { HttpClientModule } from '@angular/common/http'; 
import { RoleSelectionComponent } from './components/roleselection/roleselection.component'; 
import { RouterModule } from '@angular/router';
import { PassRequestsDetailsComponent } from './components/pass-requests-details/pass-requests-details.component';
import { ApproveRejectRequestComponent } from './components/approve-reject-request/approve-reject-request.component';
import { CommonModule } from '@angular/common';
import { NewPassRequestComponent } from './components/new-pass-request/new-pass-request.component';

@NgModule({
  declarations: [
    AppComponent,
    PassRequestListComponent,
    RoleSelectionComponent, // Added RoleSelectionComponent here
    PassRequestsDetailsComponent, ApproveRejectRequestComponent, NewPassRequestComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([])
  ],
  providers: [
    // Removed provideClientHydration() unless it's specifically needed
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
