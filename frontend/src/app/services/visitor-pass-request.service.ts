

import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { VisitorPassRequests } from '../models/visitor-pass-requests';


@Injectable({
  providedIn: 'root'
})
export class VisitorPassRequestService {
  private baseUrl = "http://localhost:8081";

  constructor(private httpClient: HttpClient) { }

  getAllVisitorPassRequests(): Observable<VisitorPassRequests[]> {
    return this.httpClient.get<VisitorPassRequests[]>(`${this.baseUrl}/visitorpassrequest/getAllVisitorPassRequests`);
  }

  getRequestsByUser(raisedByEmployee: string): Observable<VisitorPassRequests[]> {
    return this.httpClient.get<VisitorPassRequests[]>(`${this.baseUrl}/visitorpassrequest/requestsByUser/${raisedByEmployee}`).pipe(
      catchError(this.handleError));
  }

  getRequestsForLocation(location: string): Observable<VisitorPassRequests[]> {
    return this.httpClient.get<VisitorPassRequests[]>(`${this.baseUrl}/visitorpassrequest/location/${location}`).pipe(
      catchError(this.handleError));
  }

  getVisitorPassRequestById(id: number): Observable<VisitorPassRequests> {
  return this.httpClient.get<VisitorPassRequests>(`${this.baseUrl}/visitorpassrequest/${id}`);
}
approveRequest(requestId: number): Observable<any> {
  return this.httpClient.put(`${this.baseUrl}/visitorpassrequest/approve/${requestId}`, {});
}

rejectRequest(requestId: number, rejectionReason: string): Observable<string> {
  const httpOptions = {
    params: new HttpParams().set('reason', rejectionReason),
  };
  return this.httpClient.put<string>(`${this.baseUrl}/visitorpassrequest/reject/${requestId}`, {}, httpOptions);
}
newVisitorPassRequests(requestData: any): Observable<any> {
  return this.httpClient.post(`${this.baseUrl}/visitorpassrequest/createVisitorPassRequests`, requestData);
}

submitPassRequest(passRequestData: any): Observable<any> {
  return this.httpClient.post(`${this.baseUrl}/visitorpassrequest/createVisitorPassRequests`, passRequestData,{responseType:'text'}).pipe(
    catchError(this.handleError));
}

getVisitorTypes():Observable<any>{
  return this.httpClient.get(`${this.baseUrl}/visitortypes/fetch`);
}
private handleError (error:HttpErrorResponse){
  let errorMessage = 'An unexpected error occurred.';
  if (error instanceof HttpErrorResponse) {
    if (error.error && typeof error.error === 'object') {
      errorMessage = error.error.message || JSON.stringify(error.error);
    } else if (typeof error.error === 'string') {
      errorMessage = error.error;
    }
  }
  return throwError(()=>new Error(errorMessage));
}
}
