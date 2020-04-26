package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class FirstServlet extends HttpServlet {
	String name=null;
	String address=null;
	String age=null;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = res.getWriter();
		res.setContentType("text/html");
		//read form1/request1 data
		
		name=req.getParameter(name);
		address=req.getParameter(address);
		age=req.getParameter(age);
		
   //create session for browser window
		HttpSession ses =req.getSession();
     
	//keep form1/req1 data in session attributes
		ses.setAttribute("name", name);
		ses.setAttribute("address",address);
		ses.setAttribute("age", age);
		
	//generate form2 dynamically
		pw.println("<body bgcolor=cyan>");
		pw.println("<center><h1><font color=red>Provide Your Experience and Skills</font></h1></center>");
		pw.println("<form action='surl' method='POST'");
		pw.println("<table align=center>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h2><font color=blue>Enter Number of years Exp ::");
		pw.println("<input type=text name=exp size=6");
		pw.println("</td></tr>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h2><font color=blue><b>Select Skills ::</b>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.println("<select name=skills>");
		pw.println("<option value=Java>Java/J2EE</option>");
		pw.println("<option value=.NET>.NET</option>");
		pw.println("<option value=Oracle>Oracle10g</option>");
		pw.println("<option value=XML>XML&Web Services</option>");
		pw.println("</select>");
		pw.println("</td></tr>");
		pw.println("<tr><td>");
		pw.println("<input type=submit value=continue>");
		pw.println("</td></tr></table></body>");
		//close stream
		pw.close();
	}//doGet

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
}
