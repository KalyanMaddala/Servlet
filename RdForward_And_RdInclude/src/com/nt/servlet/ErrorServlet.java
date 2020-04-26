package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("ErrorServlet::doGet(-,-)");
		//general settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		//display Error page
		pw.println("<h1><center>Internal Problem</center></h1>");
		pw.println("<a href='input.html'>Try Again</a>");
		//close Strem
		pw.close();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}

}//class
