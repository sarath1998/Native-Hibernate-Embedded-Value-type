package com.sarathchandraProjects.embeddedValueType.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Column(name = "employee_companyName")
	private String companyName;
	
	@Column(name = "employee_shiftType")
	private String shiftType;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(column = @Column(name = "emp_city"), name = "city"), 
								  @AttributeOverride(column = @Column(name = "emp_state"), name = "state"),
								  @AttributeOverride(column = @Column(name = "emp_pincode"), name = "pincode"),
								  @AttributeOverride(column = @Column(name = "emp_addrLine1"), name = "addrLine1"),
								  @AttributeOverride(column = @Column(name = "emp_addrLine2"), name = "addrLine2")})
	private Address address;
	
	
	
	public Employee() {
		
	}
	
	
	
	public Employee( String companyName, String shiftType, Address address) {
		this.companyName = companyName;
		this.shiftType = shiftType;
		this.address = address;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getShiftType() {
		return shiftType;
	}
	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
