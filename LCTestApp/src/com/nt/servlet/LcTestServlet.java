package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet::static block");
	}
	
	public LcTestServlet() {
		System.out.println("LcTestServlet :: 0-param constructor");
	}
	
	@Override
	public void init(ServletConfig cg) throws ServletException {
	  System.out.println("LcTestServlet:: init(-)");
	  System.out.println("dbuser init param value::"+cg.getInitParameter("dbuser"));
	  System.out.println("dbpwd init param value:: "+cg.getInitParameter("dbpwd"));
	}
	
	@Override
	public void init() throws ServletException {
	  System.out.println("LcTestServlet:: init()");
	  ServletConfig cg=getServletConfig();
	  System.out.println("db user init param value::"+cg.getInitParameter("dbuser"));
	  System.out.println("db pwd init param vlaue::"+cg.getInitParameter("dbpwd"));
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServlet::doPost(-,-)");
		
		 PrintWriter pw=null;
		//get PrintWriter
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //write response
		 pw.println("<h1> Date and time :: "+new java.util.Date()+"</h1>");
		 //close stream
		 pw.close();
	}//service(-,-)
	
	@Override
	public void destroy() {
	   System.out.println("LcTestServlet.destroy()");
	}

}
