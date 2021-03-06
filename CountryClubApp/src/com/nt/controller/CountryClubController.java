package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.CountryClubDTO;
import com.nt.service.CountryClubService;
import com.nt.service.CountryClubServiceImpl;
import com.nt.vo.CountryClubVO;



public class CountryClubController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		CountryClubVO vo=null;
		CountryClubDTO dto=null;
		CountryClubService service=null;
		String result=null;
		PrintWriter pw=null;
		
		String Name=null,Address=null,Season=null,Package=null,Amount=null,Country=null;
	//	ServletOutputStream sos=null;
		
		//read form data
		
		Name=req.getParameter("pname");
		Address=req.getParameter("paddress");
		Season=req.getParameter("pseason");
		Package=req.getParameter("ppackage");
		Amount=req.getParameter("pamount");
		Country=req.getParameter("pcountry");
		
	
		//create VO class object having form data
		vo=new CountryClubVO();
		
		vo.setName(Name);
		vo.setAddress(Address);
		vo.setSeason(Season);
		vo.setPackage(Package);
		vo.setAmount(Amount);
		vo.setCountry(Country);
		//convert VO class object to DTO class object
		dto=new CountryClubDTO();
		
		
		dto.setName(vo.getName());
		dto.setAddress(vo.getAddress());
		dto.setSeason(vo.getSeason());
		dto.setPackage(vo.getPackage());
		dto.setAmount(Integer.parseInt(vo.getAmount()));
		dto.setCountry(vo.getCountry());
		
		//use service class
		service=new CountryClubServiceImpl();
		
		try {
			result=service.generateResult(dto);
		    } 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//display results
		//sos=res.getOutputStream();
		pw=res.getWriter();
		res.setContentType("text/html");
		
		
		pw.println("<h1>Name    :: "+Name+"</h1>");
		pw.println("<h1>Address :: "+Address+"</h1>");
		pw.println("<h1>Season  :: "+Season+"</h1>");
		pw.println("<h1>Amount  :: "+Amount+"</h1>");
		
		if(Package.equalsIgnoreCase("silver")){
			
			 pw.println("<h1 style='color:green'>Silver Package Tour  is Selected</h1>");
	       }
	    if(Package.equalsIgnoreCase("gold")){
		
		 pw.println("<h1 style='color:green'>gold Package Tour  is Selected</h1>");
          }
	    if(Package.equalsIgnoreCase("platinum")){
		
		 pw.println("<h1 style='color:green'>platinum Package Tour  is Selected</h1>");
          }
	    if(Package.equalsIgnoreCase("diamond")){
		
		 pw.println("<h1 style='color:green'>Diamond Package Tour  is Selected</h1>");
          }
		
	    
	    pw.println("<h1>"+result+"</h1>");
		
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
