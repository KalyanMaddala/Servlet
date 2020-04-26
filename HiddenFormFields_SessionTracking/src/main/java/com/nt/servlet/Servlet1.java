package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	
	//Get printwriter object
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	
	//read form1/request1 data
	String pname=req.getParameter("tname");
	String pfname=req.getParameter("tfname");
	String pms=req.getParameter("ms");
   
	//design and send dynamic form page to browser window
	//based on the martial status
	if(pms.equals("single")) {
		pw.println("<form action='s2url' method='post'>");
		pw.println("<b>when do u want to marry</b><input type='text' name='f2t1'><br>");
		pw.println("<b>why do you want to marry</b><input type='text' name='f2t2'><br>");
		//add form1/req1 data to dynamic form page as hidden box values
		
		pw.println("<input type='hidden' name='hname' value="+pname+">");
		pw.println("<input type='hidden' name='hname' value="+pfname+">");
		pw.println("<input type='hidden' name='hms'   value="+pms+">");
		
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		
	}
	else {
		pw.println("<form action='surl' method='post'>");
		pw.println("<b>Spouse Name</b><input type='text' name='f2t1'><br>");
	    pw.println("<b>No.of Children</b><input type='text' name='f2t2'><br>");
	    //add form1/req1 data to dynamic form page as hidden box values
	    
	    pw.println("<input type='hidden' name='hname' value="+pname+">");
	    pw.println("<input type='hidden' name='hfname' value="+pfname+">");
	    pw.println("<input type='hidden' name='hms' value="+pms+">");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
	}
	pw.close();
	
    }//doGet

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}//doPost(-,-)

}//class
