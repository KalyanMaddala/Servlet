package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/marriageurl",loadOnStartup = 1,name="marriage")
  @WebServlet(value="/marriageurl",initParams = {@WebInitParam(name="p1",value="k1"),
		                                                                                         @WebInitParam(name="p2",value="k2")
                                                                                                }
                               )
public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, 
			                          HttpServletResponse res) throws ServletException, IOException {
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
				 pw.println("<h1 style='color:red'>Mr. "+name+" u  r not elgible for Marriage .. Be Happy </h1>");
			else
				 pw.println("<h1 style='color:green'>Mr. "+name+" u  r elgible for Marriage .. But think Thrice becoz it is 60 years project </h1>");
		}
		else {
			if(age<18)
				 pw.println("<h1 style='color:red'>Miss. "+name+" u  r not elgible for Marriage .. Be Happy </h1>");
			else
				 pw.println("<h1 style='color:green'>Miss. "+name+" u  r  elgible for Marriage .. But think twice .  </h1>");
		}
		
		//add hyperlink
		pw.println("<br><br> <a href='form.html'>home</a>");
		
		pw.println("<br> req obj class name::"+req.getClass());
		pw.println("<br> res obj class name::"+res.getClass());
		
		//get Access to ServletConfig object
		ServletConfig cg=getServletConfig();
		pw.println("p1 init param value ::"+cg.getInitParameter("p1"));
		pw.println("<br>p2 init param value ::"+cg.getInitParameter("p2"));
		
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            doGet(req,res);
	}//doPost(-,-)
}//class
