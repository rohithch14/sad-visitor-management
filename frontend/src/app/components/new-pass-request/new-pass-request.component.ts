
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VisitorPassRequestService } from '../../services/visitor-pass-request.service';

@Component({
  selector: 'app-new-pass-request',
  templateUrl: './new-pass-request.component.html',
  styleUrls: ['./new-pass-request.component.css']
})
export class NewPassRequestComponent implements OnInit {
  passRequestForm: FormGroup;
  visitorTypes: any[] = []; 
  submissionMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private visitorPassRequestService: VisitorPassRequestService
  ) {
    this.passRequestForm = this.fb.group({
      raisedByEmployee: ['', Validators.required],
      visitorTypes: [null, Validators.required], 
      purposeOfVisit: ['', Validators.required],
      requestProccessedByEmployee: ['', Validators.required], 
      visitDate: ['', Validators.required],
      location: ['', Validators.required],
      visitorName: ['', Validators.required],
      visitorAge: ['', [Validators.required, Validators.min(1)]],
      comingFrom: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.visitorPassRequestService.getVisitorTypes().subscribe(data => {
      this.visitorTypes = data.map((type: any) => ({
        id: type.visitorTypeID,
        name: type.visitorType
      }));
    }, error => console.error('Error fetching visitor types:', error));
  }

  onSubmit(): void {
    this.submissionMessage='';
    if (this.passRequestForm.valid) {
      let formData = { ...this.passRequestForm.value };
      const selectedVisitorType = this.visitorTypes.find(type => type.id === parseInt(formData.visitorTypes));

     // Construct the visitorTypes object as expected by your backend
      formData.visitorTypes = {
        visitorTypeID: selectedVisitorType.id,
        visitorType: selectedVisitorType.name
      };

      // Set both requestRaisedOn and requestProcessedOn to the current date
      const currentDate = new Date().toISOString().split('T')[0]; // Format as YYYY-MM-DD
      formData.requestRaisedOn = currentDate;

      
  
      this.visitorPassRequestService.submitPassRequest(formData).subscribe({
        next: () => {this.submissionMessage = 'Pass request submitted successfully!';
        alert(this.submissionMessage);
        window.location.reload();
      },
     
          error:(error)=>{
          this.submissionMessage = `Error submitting pass request: ${error}`;
          alert(this.submissionMessage);
          }
      });
      
    }
  }
}
