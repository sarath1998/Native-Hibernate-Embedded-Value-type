package com.sarathchandraProjects.embeddedValueType.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student 
{
	@Column(name = "student_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "student_name", length = 50, nullable = false)
	private String name;
	
	@Column(name="student_age", length = 3, nullable = false)
	private int age;
	
	@Column(name = "student_mobile", length = 10, nullable = true)
	private Long mobileNo;
	
	@Embedded
	private Address address;
	
	/**
	 * Default constructor.
	 */
	public Student() 
	{
	}

	/**
	 * @param name
	 * @param age
	 * @param mobileNo
	 * @param address1 
	 */
	public Student(String name, int age, Long mobileNo, Address address1) 
	{
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.address = address1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", mobileNo=" + mobileNo + ", address="
				+ address + "]";
	}
	
	
	
}
