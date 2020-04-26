package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {
	public String generateResult(StudentDTO dto) {
		int total=0;
		float avg=0.0f;
		String result=null;
		int cnt=0;
		//use business logic to calculate toal,avg,results
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<35)
			result="Fail";
		else
			result="PASS";
		
		//prepare BO class object having persistable data
		StudentBO bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		//use DAO
		StudentDAO dao=new StudentDAO();
		cnt=dao.insert(bo);
		if(cnt==0)
			return "Registration Failed";
		else
			return "Registration Succeded and Result"+result;

		
	}//generateResult

}//class
