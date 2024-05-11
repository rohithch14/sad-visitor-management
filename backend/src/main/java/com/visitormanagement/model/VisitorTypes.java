package com.visitormanagement.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VisitorTypes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int visitorTypeID;
	private String visitorType;
	
	public int getVisitorTypeID() {
		return visitorTypeID;
	}
	public void setVisitorTypeID(int visitorTypeID) {
		this.visitorTypeID = visitorTypeID;
	}
	public String getVisitorType() {
		return visitorType;
	}
	public void setVisitorType(String visitorType) {
		this.visitorType = visitorType;
	}
}