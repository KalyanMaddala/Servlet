package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		  //general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		int val=Integer.parseInt(req.getParameter("t1"));
		//calc SQUARE value
		int cube=val*val*val;
		pw.println("<br>FirstServlet::Square:"+cube);
		
		// don not close stream
	    //pw.close();
	}//doGet
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}
}
