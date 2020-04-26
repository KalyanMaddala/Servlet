package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private EmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl() {
		dao=new  EmployeeDAOImpl();
	}
	

	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
	  int count=0;
	  float gSalary=0.0f,netSalary=0.0f;
	  EmployeeBO bo=null;
	  //calc  gross salary and net salary  (b.logic)
	  
	  gSalary=dto.getSalary()+(dto.getSalary()*0.4f);
	  netSalary=gSalary-(gSalary*0.2f);
	  
	  //prepare BO class obj having persistable data
	  bo=new EmployeeBO();
	  bo.setEname(dto.getEname());
	  bo.setSalary(dto.getSalary());
	  bo.setEadd(dto.getEadd());
	  bo.setGrossSalary(gSalary);
	  bo.setNetSalary(netSalary);
		//use dAO
	  count=dao.insert(bo);
	  //process the Result
	  if(count==0)
		  return "Employee registration failed";
	  else
		  return "Employee Registration Succeded";
	}

}
