import { Component, EventEmitter, Input, Output } from "@angular/core";
import { VisitorPassRequestService } from "../../services/visitor-pass-request.service";



@Component({
  selector: 'app-approve-reject-request',
  templateUrl: './approve-reject-request.component.html',
  styleUrls: ['./approve-reject-request.component.css']
})
export class ApproveRejectRequestComponent {
  @Input() requestId!: number;
  @Output() requestUpdated = new EventEmitter<string>();
  showRejectionReason = false;
  rejectionReason = '';

  
 
  constructor(private visitorPassRequestService: VisitorPassRequestService,
    ) {}

    get isAuthorized(): boolean {
      // Retrieve the "global" variable from localStorage
      const accessLevel = parseInt(localStorage.getItem('accessLevel') || '0', 10);
      return accessLevel === 1;
    }
  toggleRejectionReason() {
    this.showRejectionReason = !this.showRejectionReason;
  }

  approveRequest() {
    if(this.isAuthorized){
    this.visitorPassRequestService.approveRequest(this.requestId).subscribe({
      next: () => {
        this.requestUpdated.emit('approved');
      },
      error: (err: any) => console.error('Error approving request:', err)
    });
    alert('Approved.');
    window.location.reload();
  }
  else{
    alert('Unauthorized action');
    window.location.reload();
  }
  
  }
  rejectRequest() {
    if(this.isAuthorized){
    if (this.rejectionReason.trim()) {
      this.visitorPassRequestService.rejectRequest(this.requestId, this.rejectionReason).subscribe({
        next: () => {      
        this.requestUpdated.emit('rejected');
      },
      
        error: (err: any) => console.error('Error rejecting request:', err)
        
      });
      alert('Rejected');
      window.location.reload();


    } else {
      alert('Please provide a reason for rejection.');
    }}
    else{
    alert('Unauthorized action');
    window.location.reload();
      
    }
  }
}
