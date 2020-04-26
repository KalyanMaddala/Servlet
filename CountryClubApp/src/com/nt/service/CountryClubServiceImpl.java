package com.nt.service;

import com.nt.bo.CountryClubBO;
import com.nt.dao.CountryClubDAO;
import com.nt.dao.CountryClubDAOImpl;
import com.nt.dto.CountryClubDTO;

public class CountryClubServiceImpl implements CountryClubService{
	
	public  String generateResult(CountryClubDTO dto) throws Exception {
		 
		 float PackageAmount=0.0f;
		 float DiscountAmount=0.0f;
		 float NetAmount =0.0f;
		 int count=0;
		 String result = null;
		
		//use business logic to calculate toal,avg,results
		PackageAmount=dto.getAmount();
		DiscountAmount=((PackageAmount)/10);
		NetAmount=PackageAmount-DiscountAmount;
		
		
		
		  if(PackageAmount==100000 ) 
			  result="Registration Success"; 
		  else if(PackageAmount==200000 ) 
			  result="Registration Success"; 
		  else if(PackageAmount==300000 )
		  result="Registration Success"; 
		  else if(PackageAmount==400000 ) 
		  result="Registration Success"; 
		  else
		  result="Registration Failed";
		 
		 //prepare BO class object having persistable data
		  
	 CountryClubBO bo=new CountryClubBO();
		bo.setName(dto.getName());
		bo.setAddress(dto.getAddress());
		bo.setPackage(dto.getPackage());
		bo.setPackageAmount(PackageAmount);
		bo.setDiscountAmount(DiscountAmount);
		bo.setNetAmount(NetAmount);
		bo.setResult(result);
		  
		//use DAO
		CountryClubDAO dao=new CountryClubDAOImpl();
		 count = dao.insert(bo);
		  
		if(count==0)
			return "Tour Package "+result;
		else
			return "Tour Package "+result;
		  
    }//generateResult
	
}//class
