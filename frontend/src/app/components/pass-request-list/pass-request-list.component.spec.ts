import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassRequestListComponent } from './pass-request-list.component';

describe('PassRequestListComponent', () => {
  let component: PassRequestListComponent;
  let fixture: ComponentFixture<PassRequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PassRequestListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PassRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
