import { TestBed } from '@angular/core/testing';

import { VisitorPassRequestService } from './visitor-pass-request.service';

describe('VisitorPassRequestService', () => {
  let service: VisitorPassRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VisitorPassRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
