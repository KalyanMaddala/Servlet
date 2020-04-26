package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			                          
		PrintWriter pw=null;
		String name=null,gen=null;
		int age=0;
		
		//get PrintWriter
		pw=res.getWriter();
		// set response content type
		res.setContentType("text/html");
		//read form data...
		name=req.getParameter("pname");
		gen=req.getParameter("gender");
		age=Integer.parseInt(req.getParameter("page"));
		//write b.logic or req processing logic
		if(gen.equalsIgnoreCase("M")) {
			if(age<21)
				 pw.println("<h1 style='color:red'>Mr. "+name+" You  are not Eligible for Marriage .. Be Happy </h1>");
			else
				 pw.println("<h1 style='color:green'>Mr. "+name+" You are Eligible for Marriage .. But think Thrice becoz it is 60 years project </h1>");
		}
		else {
			if(age<18)
				 pw.println("<h1 style='color:red'>Miss. "+name+" You  are not Eligible for Marriage .. Be Happy </h1>");
			else
				 pw.println("<h1 style='color:green'>Miss. "+name+"You  are Eligible for Marriage .. But think twice .  </h1>");
		}
		
		//add hyperlink
		pw.println("<br><br> <a href='form.html'>home</a>");
		
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doGet(req,res);
	}//doPost(-,-)
}//class
