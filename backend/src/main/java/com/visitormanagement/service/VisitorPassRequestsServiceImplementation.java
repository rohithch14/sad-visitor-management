package com.visitormanagement.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visitormanagement.exceptions.InvalidResourceException;
import com.visitormanagement.exceptions.MaximumPassRequestLimitReachedException;
import com.visitormanagement.model.VisitorPassRequests;
import com.visitormanagement.repository.VisitorPassRequestsRepository;

@Service
public class VisitorPassRequestsServiceImplementation implements VisitorPassRequestsService{
	
	@Autowired
	VisitorPassRequestsRepository visitorPassRequestsRepository;
	   
	@Override
	public List<VisitorPassRequests> getAllVisitorPassRequests() {
		return visitorPassRequestsRepository.findAll();
	}
	
	public boolean approveRequest(Integer requestId) {
        return updateRequestStatus(requestId, "Approved");
    }

    public boolean rejectRequest(Integer requestId,String cancellationReason) {
    	Optional<VisitorPassRequests> requestOptional=visitorPassRequestsRepository.findById(requestId);
    	if(requestOptional.isPresent()) {
    		VisitorPassRequests request=requestOptional.get();
    		request.setRequestStatus("Rejected");
    		request.setCancellationReason(cancellationReason);
    		visitorPassRequestsRepository.save(request);
    		return true;
    	}
        return false;
    }

    private boolean updateRequestStatus(Integer requestId, String status) {
        Optional<VisitorPassRequests> requestOpt = visitorPassRequestsRepository.findById(requestId);
        if (requestOpt.isPresent()) {
            VisitorPassRequests request = requestOpt.get();
            request.setRequestStatus(status);
            visitorPassRequestsRepository.save(request);
            return true;
        }
        return false;
    }
    
    @Transactional
	public Boolean newVisitorPassRequests(VisitorPassRequests visitorPassRequests) throws InvalidResourceException,MaximumPassRequestLimitReachedException{
        LocalDate requestRaisedOn = visitorPassRequests.getRequestRaisedOn();
        LocalDate visitDate = visitorPassRequests.getVisitDate();
        int visitorTypeId = visitorPassRequests.getVisitorTypes().getVisitorTypeID();
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        boolean isWeekend = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        int month = visitDate.getMonthValue();
        int year = visitDate.getYear();
        String raisedByEmployee = visitorPassRequests.getRaisedByEmployee();
        long daysBetween = ChronoUnit.DAYS.between(requestRaisedOn, visitDate);       
        if (visitorTypeId >= 1 && visitorTypeId <= 4) { 
           
            long existingFamilyRequestsCount = visitorPassRequestsRepository.countByRaisedByEmployeeAndMonthAndYearAndVisitorType(raisedByEmployee, month, year);
            
            if (existingFamilyRequestsCount >= 2) {
                throw new MaximumPassRequestLimitReachedException("Each employee can raise only 2 visitor requests for their family members in a given calendar month.");
            }
            else if (daysBetween < 7) {
                throw new InvalidResourceException("A new visitor request must be raised at least 1 week in advance.");
            }
            else if (!isWeekend) {
                throw new InvalidResourceException("Visit requests for family members can only be raised for weekends.");
            }
        }
        if (visitorTypeId == 5) { 
        	if (daysBetween < 7) {
                throw new InvalidResourceException("A new visitor request must be raised at least 1 week in advance.");
        	}
        }
     
        visitorPassRequestsRepository.save(visitorPassRequests);
        return true;
    }
	
	@Override
	public List<VisitorPassRequests> getPendingRequestBasedOnLoc(String location) throws InvalidResourceException{
		List<VisitorPassRequests> passRequests= visitorPassRequestsRepository.getPendingRequestBasedOnLoc(location);
		if(passRequests.isEmpty()) {
			throw new InvalidResourceException("No such location: "+location);
		}
		return passRequests;
	}

	@Override
	public List<VisitorPassRequests> getRequestsCreatedByUser(String raisedByEmploee) {
		List<VisitorPassRequests> passRequests=visitorPassRequestsRepository.findByRaisedByEmployee(raisedByEmploee);
		if(passRequests.isEmpty()) {
			throw new InvalidResourceException("No such request for this employee: "+raisedByEmploee);
		}
		return passRequests;
	
	}

	@Override
	public List<VisitorPassRequests> getVistorPassRequestID(int visitorPassRequestID) {
		return visitorPassRequestsRepository.findById(visitorPassRequestID);
	}
}	