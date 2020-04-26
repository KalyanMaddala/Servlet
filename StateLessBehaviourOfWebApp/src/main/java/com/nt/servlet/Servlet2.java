package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//read 1st form,second form data
		pw.println("<br>First Form data is ");
		pw.println("<br><br>Name is "+req.getParameter("pname"));
		pw.println("<br>Age is "+req.getParameter("page"));
		pw.println("<br>Martial Status is "+req.getParameter("ms"));
		pw.println("<br><br>Second Form Data is <br><br>Spouse Name :: "+req.getParameter("st1")+"<br>No of Kids :: "+req.getParameter("st2"));
		pw.close();
	}
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
