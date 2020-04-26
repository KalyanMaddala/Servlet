package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		  //general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int val=Integer.parseInt(req.getParameter("t1"));
		//calc SQUARE value
		int square=val*val;
		pw.println("<br>FirstServlet::Square:"+square);
		//include the response of secondServlet component
		//get ServletContext object of current web application
		ServletContext sc1=getServletContext();
		//get ServletContext object of WATwo web Application
		ServletContext sc2=sc1.getContext("/WaTwoApp_CrossContextCommunication");
		//get RequestDispatcher object pointing to SecondServlet
		RequestDispatcher rd=sc2.getRequestDispatcher("/s2url");
		rd.include(req, res);
		
		//close stream
	    pw.close();
	}//doGet
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}
}
