import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveRejectRequestComponent } from './approve-reject-request.component';

describe('ApproveRejectRequestComponent', () => {
  let component: ApproveRejectRequestComponent;
  let fixture: ComponentFixture<ApproveRejectRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ApproveRejectRequestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ApproveRejectRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
