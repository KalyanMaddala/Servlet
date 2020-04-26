package com.nt.service;

import com.nt.dto.EmployeeDTO;

public class PayRollServiceImpl implements PayRollService {

	@Override
	public void generatePaySlip(EmployeeDTO dto) {
	   float netSalary=0.0f, grossSalary=0.0f;
		//calc gross,net salaries
	   grossSalary=dto.getSalary()+ (dto.getSalary()*0.3f);
	   netSalary=grossSalary-(grossSalary*0.1f);
	   //set gross,netSalaries to dto
	   dto.setGrossSalary(grossSalary);
	   dto.setNetSalary(netSalary);
	}

}
