package com.visitormanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.visitormanagement.model.VisitorPassRequests;

@Repository
public interface VisitorPassRequestsRepository extends JpaRepository<VisitorPassRequests, Integer>{
	@Query("select r from VisitorPassRequests r where r.requestStatus='Pending' and r.location=:location")
	List<VisitorPassRequests>getPendingRequestBasedOnLoc(@Param("location") String location);

	List<VisitorPassRequests> findByRaisedByEmployee(String raisedByEmploee);
	 @Query("SELECT COUNT(v) FROM VisitorPassRequests v WHERE v.raisedByEmployee = :raisedByEmployee AND FUNCTION('MONTH', v.requestRaisedOn) = :month AND FUNCTION('YEAR', v.requestRaisedOn) = :year AND v.visitorTypes.visitorTypeID BETWEEN 1 AND 4")
	    long countByRaisedByEmployeeAndMonthAndYearAndVisitorType(@Param("raisedByEmployee") String raisedByEmployee, @Param("month") int month, @Param("year") int year);

	List<VisitorPassRequests> findById(int visitorPassRequestID);
}