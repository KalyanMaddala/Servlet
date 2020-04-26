package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private String eadd;
	
	private String ename;
	private  String desg;
	private float salary;
	private float grossSalary;
	private float  netSalary;
	
	public EmployeeDTO() {
		System.out.println("EmployeeDTO::0-param constructor");
	}
	
	public String getEadd() {
		return eadd;
	}

	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}

}
