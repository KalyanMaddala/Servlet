package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		RequestDispatcher rd=null;
		PrintWriter pw=null;
		HttpSession ses=null;
		ServletContext sc=null;
		
		//General Settings
		pw=res.getWriter();
		
		//set Content Type
		res.setContentType("text/html");
		
		//read and display request attribute value
		pw.println("<br>Servlet2::attr1 attribute value "+req.getAttribute("attr1"));
	
		
		//read and display session attribute value
		ses=req.getSession();
		pw.println("<br>Servlet2::attr2 attribute value "+ses.getAttribute("attr2"));
		
		//read and display servlet context attribute value
		sc=getServletContext();
		pw.println("<br>Servlet2::attr3 attribute value "+sc.getAttribute("attr3"));
		
		//Forward the request to Servlet2 component
		rd=req.getRequestDispatcher("/s3url");
		rd.forward(req, res);
	
	}//doGet
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		doGet(req,res);
	}
}
