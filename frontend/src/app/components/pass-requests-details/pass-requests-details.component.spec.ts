import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassRequestsDetailsComponent } from './pass-requests-details.component';

describe('PassRequestsDetailsComponent', () => {
  let component: PassRequestsDetailsComponent;
  let fixture: ComponentFixture<PassRequestsDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PassRequestsDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PassRequestsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
