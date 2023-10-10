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
	@AttributeOverrides({@AttributeOverride(column = @Column(name = "employee_city"), name = "city"), 
								  @AttributeOverride(column = @Column(name = "employee_state"), name = "state"),
								  @AttributeOverride(column = @Column(name = "employee_pincode"), name = "pincode"),
								  @AttributeOverride(column = @Column(name = "employee_addrLine1"), name = "addrLine1"),
								  @AttributeOverride(column = @Column(name = "employee_addrLine2"), name = "addrLine2")})
	private Address workLocationAddress;
	
	/*
	 * Another instance of the Address component.. allowing hibernate to use the default names for the columns
	 * Here the default names will be the same as the field names.
	 * 
	 * Note: Now the single table alone will contain all the columns(workLocationAdress columns + homeAdress columns + the curent class specifc columns)
	 * 
	 * This will be the sql stament genetated 
	 * 
	 *     create table employees (
        employee_pincode integer,
        employee_id integer not null auto_increment,
        employee_addrLine1 varchar(255),
        employee_addrLine2 varchar(255),
        employee_state varchar(255),
        employee_companyName varchar(255),
        employee_shiftType varchar(255),
        pincode integer not null,
        addrLine1 varchar(255),
        addrLine2 varchar(255),
        state varchar(255),
        primary key (employee_id)
    ) engine=InnoDB
	 * 
	 */
	private Address homeAddress;
	
	
	public Employee() {
		
	}
	
	
	
	
	
	public Employee(String companyName, String shiftType, Address workLocationAddress, Address homeAddress) {
		this.companyName = companyName;
		this.shiftType = shiftType;
		this.workLocationAddress = workLocationAddress;
		this.homeAddress = homeAddress;
	}

	public Employee(String companyName, String shiftType, Address homeAddress) {
		this.companyName = companyName;
		this.shiftType = shiftType;
		this.homeAddress = homeAddress;
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

	public Address getWorkLocationAddress() {
		return workLocationAddress;
	}



	public void setWorkLocationAddress(Address workLocationAddress) {
		this.workLocationAddress = workLocationAddress;
	}



	public Address getHomeAddress() {
		return homeAddress;
	}



	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	
}
