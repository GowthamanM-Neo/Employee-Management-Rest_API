package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeModel {

	@Id
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String dept;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "EmployeeModel [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", dept=" + dept + "]";
	}
	
	
}
