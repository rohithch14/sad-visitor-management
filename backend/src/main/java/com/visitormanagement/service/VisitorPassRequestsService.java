package com.visitormanagement.service;

import com.visitormanagement.model.VisitorPassRequests;

import java.util.List;
import java.util.Optional;

public interface VisitorPassRequestsService {
	List<VisitorPassRequests> getAllVisitorPassRequests();
	Boolean newVisitorPassRequests(VisitorPassRequests visitorPassRequests);
	List<VisitorPassRequests> getPendingRequestBasedOnLoc(String location);
	List<VisitorPassRequests> getRequestsCreatedByUser(String raisedByEmploee);
	List<VisitorPassRequests> getVistorPassRequestID(int visitorPassRequestID);
}