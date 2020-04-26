package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class VoterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
		PrintWriter pw =null;
		String name=null,tage=null;
		int age=0;
		//general settings
		pw = res.getWriter();
		res.setContentType("text/html");
		
		//get request parameter values (form data)
		name=req.getParameter("pname");
		tage=req.getParameter("page");
		age=Integer.parseInt(tage);
		pw.println("<img src='voter.png' width='200' height='200'>");
		//write request processing logic
		if(age>=18)
		
		  pw.println("<h1 style='color:green'>Mr/Mrs "+name+" you are Eligible for Vote</h1>");		  
		
		else
		
		  pw.println("<h1 style='color:red'>Mr/Mrs "+name+"  you are not Eligible for Vote</h1>");		
		
		//add hyperlink
		pw.println("<a href='input.html'><img src='home.png' width='50' height='50'></a>");	
		
		//close stream
		pw.close();
	}
}