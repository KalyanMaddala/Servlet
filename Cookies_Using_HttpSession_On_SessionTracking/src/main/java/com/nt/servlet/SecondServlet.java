package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class SecondServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = res.getWriter();
		res.setContentType("text/html");
		//read form2/request2 data
	     String exp=req.getParameter("exp");
		 String skills=req.getParameter("skills");
		
		 //get access to session object
		HttpSession ses =req.getSession(false);
     
	//keep form2/req2 data in session attributes
		ses.setAttribute("exp",exp );
		ses.setAttribute("skills",skills);
	//generate form3 dynamically
		pw.println("<body bgcolor=red>");
		pw.println("<center><h1><font color=red>Provide City & Salary</font></h1></center>");
		pw.println("<form action='turl' method='post'>");
		pw.println("<table align=center>");
		
		
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h2><font color=blue>Enter prefered City ::");
		pw.println("<input type=text name=city size=10>");
		pw.println("</td></tr>");
		
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h2><font color=blue>Enter Expected Salary ::");
		pw.println("<input type=text name=sal size=16>");
		pw.println("</td></tr>");
		
		pw.println("<tr><td>");
		pw.println("<input type=submit value=submit>");
		pw.println("</td></tr>");
		pw.println("<table></form></body>");
		//close stream
		pw.close();
	}
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
