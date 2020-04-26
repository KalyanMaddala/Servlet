package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pval=null;
		Locale locales[]=null;
		
		//get PrintWriter
		pw=res.getWriter();
		
		//set response content type
		res.setContentType("text/html");
		
		//read additional req param value (p1) 
		pval=req.getParameter("p1");
		       //get available locales of this world
		   locales=Locale.getAvailableLocales();
		 
		   //differentiate logics based  on the hyperlinks that are clicked
		   if(pval.equalsIgnoreCase("link1")) {
			   pw.println("<h2> All countries are.... </h2>");
			   for(Locale lc:locales) {
				   pw.println("<b>"+lc.getDisplayCountry()+"</b><br>");
			   }
		   }//if
		   else if(pval.equalsIgnoreCase("link2")) {
			   pw.println("<h1> All Languages are </h1>");
			   for(Locale lc:locales) {
				   pw.println("<b>"+lc.getDisplayLanguage()+"</b><br>");
			   }
		   }
		   else {
			   pw.println("<h1> system date and time :: </h1>");
			   pw.println("Date and tme::"+new java.util.Date());
		   }
		   //add hyperlink
		   pw.println("<br> <a href='links.html'><img src='home1.png' width='100',height='90'></a>");
	}
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           doGet(req,res);
	}

}
