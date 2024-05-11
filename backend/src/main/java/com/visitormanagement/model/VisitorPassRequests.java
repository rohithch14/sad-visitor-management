package com.visitormanagement.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity

public class VisitorPassRequests {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int visitorPassRequestID;
	private String raisedByEmployee;
	private LocalDate requestRaisedOn;
	 
	@ManyToOne
	@JoinColumn(name="visitorTypes", referencedColumnName="visitorTypeID")
	private VisitorTypes visitorTypes;
	private String purposeOfVisit;
	private String requestStatus="Pending";
	private String requestProccessedByEmployee;

	private LocalDate requestProccessedOn;
	private LocalDate visitDate;
	private String cancellationReason="Null";
	private String location;
	private String visitorName;
	private int visitorAge;
	private String comingFrom;
	
	@PrePersist
	public void prePersist() {
		this.requestProccessedOn=LocalDate.now();
	}
	
	public int getVisitorPassRequestID() {
		return visitorPassRequestID;
	}
	public void setVisitorPassRequestID(int visitorPassRequestID) {
		this.visitorPassRequestID = visitorPassRequestID;
	}
	public String getRaisedByEmployee() {
		return raisedByEmployee;
	}
	public void setRaisedByEmployee(String raisedByEmployee) {
		this.raisedByEmployee = raisedByEmployee;
	}
	public VisitorTypes getVisitorTypes() {
		return visitorTypes;
	}
	public void setVisitorTypes(VisitorTypes visitorTypes) {
		this.visitorTypes = visitorTypes;
	}
	public String getPurposeOfVisit() {
		return purposeOfVisit;
	}
	public void setPurposeOfVisit(String purposeOfVisit) {
		this.purposeOfVisit = purposeOfVisit;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getRequestProccessedByEmployee() {
		return requestProccessedByEmployee;
	}
	public void setRequestProccessedByEmployee(String requestProccessedByEmployee) {
		this.requestProccessedByEmployee = requestProccessedByEmployee;
	}
	public String getCancellationReason() {
		return cancellationReason;
	}
	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}
	
	public String getComingFrom() {
		return comingFrom;
	}
	public void setComingFrom(String comingFrom) {
		this.comingFrom = comingFrom;
	}
	public LocalDate getRequestProccessedOn() {
		return requestProccessedOn;
	}
	public void setRequestProccessedOn(LocalDate requestProccessedOn) {
		this.requestProccessedOn = requestProccessedOn;
	}
	public LocalDate getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
	public String getVisitorName() {
		return visitorName;
	}
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}
	public int getVisitorAge() {
		return visitorAge;
	}
	public void setVisitorAge(int visitorAge) {
		this.visitorAge = visitorAge;
	}
	public void setRequestRaisedOn(LocalDate requestRaisedOn) {
		this.requestRaisedOn = requestRaisedOn;
	}
	public LocalDate getRequestRaisedOn() {
		return requestRaisedOn;
	}
	public VisitorPassRequests() {
		super();
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}	
}