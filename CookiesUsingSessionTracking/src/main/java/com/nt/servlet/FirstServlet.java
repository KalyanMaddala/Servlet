package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	
	//Get printwriter object
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	
	//read form1/request1 data
	String s1=req.getParameter("name");
	String s2=req.getParameter("fname");
	
	//create cookies to store the form1 data
	Cookie ck1 = new Cookie("name",s1);
	Cookie ck2 = new Cookie("fname",s2);
	
	res.addCookie(ck1);
	res.addCookie(ck2);
	
	//now we need to generate the second form dynamically from here
	pw.println("<form action='surl' method='POST'>");
	pw.println("Income for this year <input type='text' name=income><br>");
	pw.println("Tax<input type='text' name=tax>");
	pw.println("<br><br><br><input type='submit' value=submit>");
	pw.println("</form>");
	//close streams
	pw.close();
	
    }//doGet

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}

}
