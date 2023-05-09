package com.example.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Stud {
	@Id
	private Integer rollNo;
	private String name;
	private Integer std;
	private String section;
	private Integer mobilleNo;
	private String address;
	private String date;
	
	
//	@Transient
//	 private boolean setStatus=false;
//	
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getRollNo() {
		return rollNo;
	}
	
	
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStd() {
		return std;
	}
	public void setStd(Integer std) {
		this.std = std;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Integer getMobilleNo() {
		return mobilleNo;
	}
	public void setMobilleNo(Integer mobilleNo) {
		this.mobilleNo = mobilleNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", std=" + std + ", section=" + section + ", mobilleNo="
				+ mobilleNo + ", address=" + address + "]";
	}
	
	
}
