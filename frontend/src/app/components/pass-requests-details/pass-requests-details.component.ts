import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VisitorPassRequests } from '../../models/visitor-pass-requests';
import { VisitorPassRequestService } from '../../services/visitor-pass-request.service';

@Component({
  selector: 'app-pass-requests-details',
  templateUrl: './pass-requests-details.component.html',
  styleUrls: ['./pass-requests-details.component.css']
})
export class PassRequestsDetailsComponent implements OnInit {
  visitorPassRequest !:VisitorPassRequests;
  userRole!: string;
  
  constructor(
    private route: ActivatedRoute,
    private visitorPassRequestService: VisitorPassRequestService
  ) {}

  ngOnInit(): void {
    this.getPassRequestDetails();
    this.getRequestsBasedOnUserRole();
    }
  getRequestsBasedOnUserRole():void {
   this.route.queryParams.subscribe(params=>{
    const role=params['role'];
  const pin=params['pin'];
   })
  }

  getPassRequestDetails(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    if (!isNaN(id)) {
      this.visitorPassRequestService.getVisitorPassRequestById(id).subscribe({
        next: (data) => {
          // Assuming the service method now correctly reflects the expected response type
          // Adjust this logic if your backend is adjusted to return a single object
          if (data && Array.isArray(data) && data.length > 0) {
            this.visitorPassRequest = data[0]; // Taking the first item from the array
          } else {
            console.error('Received data is not in expected format or is empty');
          }
        },
        error: (error) => {
          console.error('Error fetching visitor pass request details:', error);
        }
      });
    }
  }

}
