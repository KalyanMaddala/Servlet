package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//general settings
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		//add header content
		pw.println("<marquee><h1>H C L Technologies</h1></marquee>");
		//do not close stream
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		  doGet(req,res);
	}
}//class
