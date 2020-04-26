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
		//read form1/request1 data
	String name=req.getParameter("pname");
	String age=req.getParameter("page");
	String ms=req.getParameter("ms");
   
	ms=(ms==null)?"single":ms;
	
	//Get printwriter object
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	
	//Generate second form dynamically form here
	if(ms.equals("married")) {
		pw.println("<form action='s2url' method='post'>");
		pw.println("<b>Spouse Name</b><input type='text' name='st1'><br>");
	    pw.println("<b>No.of Children</b><input type='text' name='st2'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		
	}
	else {
		pw.println("<form action='s2url' method='post'>");
		pw.println("<b>when do u want to marry</b><input type='text' name='st1'><br>");
		pw.println("<b>why do you want to marry</b><input type='text' name='st2'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
	}
	pw.close();
	
    }//doGet

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}

}
