package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PassportServlet extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		

	PrintWriter pw =null;
	String fname=null,lname=null,tage=null;
	int age=0;
	//general settings
	pw = res.getWriter();
	res.setContentType("text/html");
	
	//get request parameter values (form data)
	fname=req.getParameter("pfname");
	lname=req.getParameter("plname");
	tage=req.getParameter("page");
	age=Integer.parseInt(tage);
	pw.println("<img src='voter.png' width='200' height='200'>");
	//write request processing logic
	if(age>=18)
	
	  pw.println("<h1 style='color:green'>Mr/Mrs "+fname+ " you are Eligible for Vote</h1>");		  
	
	else
	
	  pw.println("<h1 style='color:red'>Mr/Mrs "+fname+" "+lname+"  you are not Eligible for Vote</h1>");		
	
	//add hyperlink
	pw.println("<a href='input.html'><img src='home.png' width='50' height='50'></a>");	
	
	//close stream
	pw.close();
}
}