package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.TrainTicketDTO;
import com.nt.service.TrainTicketService;
import com.nt.service.TrainTicketServiceImpl;
import com.nt.vo.TrainTicketVO;





public class TrainTicketController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		TrainTicketVO vo=null;
		TrainTicketDTO dto=null;
		TrainTicketService service=null;
		String result=null;
		PrintWriter pw=null;
		
		String PassengerName=null,PassengeAddress=null,Source=null,Destination=null,Distance=null;
	//	ServletOutputStream sos=null;
		
		//read form data
		PassengerName=req.getParameter("ppassengername");
		PassengeAddress=req.getParameter("ppassengeraddress");
		Source=req.getParameter("psource");
		Destination=req.getParameter("pdestination");
		Distance=req.getParameter("pdistance");
		
		
	
		//create VO class object having form data
		vo=new TrainTicketVO();
		vo.setPassengerName(PassengerName);
		vo.setPassengeAddress(PassengeAddress);
		vo.setSource(Source);
		vo.setDestination(Destination);
		vo.setDistance(Distance);
		
		//convert VO class object to DTO class object
		dto=new TrainTicketDTO();
		
		
		dto.setPassengerName(vo.getPassengerName());
		dto.setPassengeAddress(vo.getPassengeAddress());
		dto.setSource(vo.getSource());
		dto.setDestination(vo.getDestination());
		dto.setDistance(Float.parseFloat(vo.getDistance()));
		
		//use service class
		service=new TrainTicketServiceImpl();
		
		try {
			result=service.generateResult(dto);
		    } 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		  String result1=null;
		  
		  int Distance1 = (int) dto.getDistance();
		if(Distance1  < 100) 
			  
			  result1="Your Destination is Less Than 100kms"; 
		  
		  else if(Distance1 > 100 && Distance1 < 200)
			  
		  result1="Your Destination is Between 100 to 200kms"; 
		  
		  else if(Distance1 > 200 && Distance1 < 300) 
			  
			  result1="Your Destination is Between 200 to 300kms";
		
		  else if(Distance1 > 300 && Distance1 < 400)
			  
		  result1="Your Destination is Between 300 to 400kms"; 
		
		  else
		  result1="Your Destination is More Than 400kms";
		 
		
		//display results
		//sos=res.getOutputStream();
		pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<h1 style='color:purple'>PassengerName :: "+PassengerName+"</h1>");
		pw.println("<h1>PassengeAddress:: "+PassengeAddress+"</h1>");
		pw.println("<h1>Source :: "+Source+"</h1>");
		pw.println("<h1>Destination  :: "+Destination+"</h1>");
		pw.println("<h1>Distance  :: "+Distance+"</h1>");
		
		 pw.println("<h1 style='color:green'>"+result+"</h1>");
		 pw.println("<h1 style='color:red'>"+result1+"</h1>");
		
		//add hyperlink
		 pw.println("<a href='index.html'>Home</a>"); 
		//close streams
		pw.close();
	}//doGet
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
		
	}//doPost

}//class
