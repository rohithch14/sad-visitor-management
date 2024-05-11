import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPassRequestComponent } from './new-pass-request.component';

describe('NewPassRequestComponent', () => {
  let component: NewPassRequestComponent;
  let fixture: ComponentFixture<NewPassRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewPassRequestComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NewPassRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
