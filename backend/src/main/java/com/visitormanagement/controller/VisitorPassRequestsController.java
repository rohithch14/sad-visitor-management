package com.visitormanagement.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visitormanagement.model.VisitorPassRequests;
import com.visitormanagement.service.VisitorPassRequestsServiceImplementation;

@RestController
@RequestMapping("/visitorpassrequest")
@CrossOrigin(origins = "http://localhost:4200")
public class VisitorPassRequestsController {
	@Autowired
	VisitorPassRequestsServiceImplementation visitorPassRequestsServiceImplementation;
	
	@GetMapping("/getAllVisitorPassRequests")
	public ResponseEntity<List<VisitorPassRequests>> getAllVisitorPassRequests() {
		List<VisitorPassRequests> visitorspass = visitorPassRequestsServiceImplementation.getAllVisitorPassRequests();
		if (!visitorspass.isEmpty()) {
			return new ResponseEntity<>(visitorspass, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
		}
	}
	
	@PostMapping("/createVisitorPassRequests")
	public ResponseEntity<String> newVisitorPassRequests(@RequestBody VisitorPassRequests visitorPassRequests) {
		visitorPassRequestsServiceImplementation.newVisitorPassRequests(visitorPassRequests);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

	@GetMapping("/location/{location}")
	public ResponseEntity<List<VisitorPassRequests>> getPendingRequestBasedOnLoc(@PathVariable String location) {
	    List<VisitorPassRequests> pendingRequests = visitorPassRequestsServiceImplementation.getPendingRequestBasedOnLoc(location);
	        return ResponseEntity.ok(pendingRequests);	
	}

	@GetMapping("/requestsByUser/{raisedByEmployee}")
	public ResponseEntity<List<VisitorPassRequests>> getRequestsCreatedByUser(@PathVariable("raisedByEmployee") String raisedByEmployee) {
	    List<VisitorPassRequests> requests = visitorPassRequestsServiceImplementation.getRequestsCreatedByUser(raisedByEmployee);
	    if (requests.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(requests, HttpStatus.OK);
	}
	
	@GetMapping("/{visitorPassRequestID}")
	public ResponseEntity<List<VisitorPassRequests>> getVistorPassRequestID(@PathVariable int visitorPassRequestID) {
	    List<VisitorPassRequests> requests = visitorPassRequestsServiceImplementation.getVistorPassRequestID(visitorPassRequestID);
	        return new ResponseEntity<>(requests,HttpStatus.OK);
	    
	}
	
	@PutMapping("/approve/{requestId}")
    public ResponseEntity<Void> approveRequest(@PathVariable Integer requestId) {
        if (visitorPassRequestsServiceImplementation.approveRequest(requestId)) {
//            return ResponseEntity.ok().body("Visitor pass request approved successfully.");
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/reject/{requestId}")
    public ResponseEntity<Void> rejectRequest(@PathVariable Integer requestId,@RequestParam("reason") String cancellationReason) {
        if (visitorPassRequestsServiceImplementation.rejectRequest(requestId, cancellationReason)) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}