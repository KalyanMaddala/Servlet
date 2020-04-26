package com.nt.dto;

import java.io.Serializable;
public class EmployeeDTO implements Serializable {
	
	private String Ename;
	private String Eadd;
	private float Salary;
	private int Deptno;
	
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
	public int getDeptno() {
		return Deptno;
	}
	public void setDeptno(int deptno) {
		Deptno = deptno;
	}
	
	
}
