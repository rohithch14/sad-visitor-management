// src/app/components/role-selection/role-selection.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-roleselection',
  templateUrl: './roleselection.component.html',
  styleUrls: ['./roleselection.component.css']
})
export class RoleSelectionComponent {
  userRole: string = '';
  userPIN: string = '';
  constructor(private router: Router) { }

  submitForm() {

      this.router.navigate(['/pass-requests'], { queryParams: { role: this.userRole, pin: this.userPIN } });
    
}
}