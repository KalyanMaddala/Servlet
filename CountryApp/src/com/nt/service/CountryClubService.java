package com.nt.service;

import com.nt.bo.CountryClubBO;
import com.nt.dao.CountryClubDAO;
import com.nt.dto.CountryClubDTO;

public class CountryClubService {
	public  String generateResult(CountryClubDTO dto) {
		
		
		 
		 float PackageAmount=0.0f;
		 float DiscountAmount=0.0f;
		 float NetAmount =0.0f;
		 int cnt=0;
		 String result = null;
		//use business logic to calculate toal,avg,results
		PackageAmount=dto.getAmount();
		DiscountAmount=((PackageAmount)/10);
		NetAmount=PackageAmount-DiscountAmount;
		
		
		if(PackageAmount<=99999 || PackageAmount >=100001 )
			result="No Package For This Budget";
		
		else if(PackageAmount<=199999 || PackageAmount >=200001 )
			result="No Package For This Budget";
		
		else if(PackageAmount<=299999 || PackageAmount >=300001 )
			result="No Package For This Budget";
		
		else if(PackageAmount<=399999 || PackageAmount >=400001 )
			result="No Package For This Budget";
		else
			result="Tour Package is Selected ";
		
		
		//prepare BO class object having persistable data
		CountryClubBO bo=new CountryClubBO();
		bo.setName(dto.getName());
		bo.setAddress(dto.getAddress());
		bo.setPackageAmount(PackageAmount);
		bo.setDiscountAmount(DiscountAmount);
		bo.setNetAmount(NetAmount);
		
		//use DAO
		CountryClubDAO dao=new CountryClubDAO();
		cnt=dao.insert(bo);
		if(cnt==0)
			return "Registration Failed";
		else
			return "Registration Succeded and Result"+result;
		
	}//generateResult
	
	}//class
