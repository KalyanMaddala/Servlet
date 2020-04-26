package com.nt.bo;

public class EmployeeBO {
	private String Ename;
	private String Eadd;
	private  float Salary;
	private  float GrossSalary;
	private float NetSalary;
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getEadd() {
		return Eadd;
	}
	public void setEadd(String eadd) {
		Eadd = eadd;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	public float getGrossSalary() {
		return GrossSalary;
	}
	public void setGrossSalary(float grossSalary) {
		GrossSalary = grossSalary;
	}
	public float getNetSalary() {
		return NetSalary;
	}
	public void setNetSalary(float netSalary) {
		NetSalary = netSalary;
	}
	

}
