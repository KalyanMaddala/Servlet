package com.nt.service;
import com.nt.bo.TrainTicketBO;
import com.nt.dao.TrainTicketDAO;
import com.nt.dao.TrainTicketDAOImpl;
import com.nt.dto.TrainTicketDTO;

public class TrainTicketServiceImpl implements TrainTicketService{
	
	public  String generateResult(TrainTicketDTO dto) throws Exception {
	
		 int count=0;
		 float distance = 0.0f;
		 float fare = 0.0f;
		 String result =null;
		//use business logic to calculate toal,avg,results
		 distance=dto.getDistance();
		 fare=(distance*4);
        
		 //prepare BO class object having persistable data
		 
		 if(distance >= 0)
				result="Transaction is Successful";
			else
				result="Transaction is Failed";
		  
		  TrainTicketBO bo=new TrainTicketBO();
		bo.setPassengerName(dto.getPassengerName());
		bo.setSource(dto.getSource());
		bo.setDestination(dto.getDestination());
		bo.setDistance(distance);
		bo.setFare(fare);
		bo.setResult(result);
		
		
		  
		//use DAO
		TrainTicketDAO dao=new TrainTicketDAOImpl();
		 count = dao.insert(bo);
		  
		if(count==0)
			return "Your "+result;
		else
			return "Your "+result;
		  
    }//generateResult
	
}//class
