package com.sarathchandraProjects.embeddedValueType.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
public class Address {

	@Transient // Tell hibernate, to stop this field from becoming a column during the table creation.
	           // In case if needed this column as well, then remove @Transient annotation
	private String city;
	

	private String state;
	

	private int pincode;
	

	private String addrLine1;
	

	private String addrLine2;
	
	public Address() {
		
	}
	
	public Address(String city, String state, int pincode, String addrLine1, String addrLine2) {
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getAddrLine1() {
		return addrLine1;
	}
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}
	public String getAddrLine2() {
		return addrLine2;
	}
	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}
	
	

}
