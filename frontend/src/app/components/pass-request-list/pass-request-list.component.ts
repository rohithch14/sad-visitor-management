
import { Component, OnInit } from '@angular/core';
import { VisitorPassRequestService } from '../../services/visitor-pass-request.service';
import { VisitorPassRequests } from '../../models/visitor-pass-requests';
import { Router,ActivatedRoute } from '@angular/router';
 
@Component({
  selector: 'app-pass-request-list',
  templateUrl: './pass-request-list.component.html',
  styleUrls: ['./pass-request-list.component.css']
})
export class PassRequestListComponent implements OnInit {
  visitorPassRequests!: VisitorPassRequests[];
  userRole!: string;
  userPIN!: string; // Use PIN for simplicity; adjust as necessary
  submissionMessage: string | undefined;
  
  constructor(
    private visitorPassRequestService: VisitorPassRequestService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getRequestsBasedOnUserRole();
    this.setUserRole();
  }
  setUserRole(): void {
    // Assuming the role is passed via queryParams or stored in localStorage
    this.route.queryParams.subscribe(params => {
      this.userRole = params['role'] || localStorage.getItem('userRole');
    });
  }
  
  getRequestsBasedOnUserRole(): void {
    this.submissionMessage='';
    this.route.queryParams.subscribe(params => {
      const role = params['role'];
      const pin = params['pin']; // Or name for employees
      const accessLevel = role === 'SecurityHead' ? 1 : 0;
      localStorage.setItem('accessLevel', accessLevel.toString());

      if (role === 'Employee' && pin) {
        this.visitorPassRequestService.getRequestsByUser(pin).subscribe({
          next:(data) => {
          this.visitorPassRequests = data;
        },
        error:error=>{
          this.submissionMessage=error;
          alert(error);
          this.router.navigate(['/']);
        }});
      } 
      else if (role === 'SecurityHead' && pin) {
        // Assuming 'pin' here represents the location for simplicity
        this.visitorPassRequestService.getRequestsForLocation(pin).subscribe({
          next:(data) => {
          this.visitorPassRequests = data;
        },
        error:error=>{
          this.submissionMessage=error;
          alert(error);
          this.router.navigate(['/']);
        }});
      }
      else{
        alert("Enter valid details");
        this.router.navigate(['/']);
      }
    });
    
  }
}
