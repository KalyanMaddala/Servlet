package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
		//general settings
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //read context param values
	    ServletContext sc=getServletContext();
	    pw.println("dbuser context param value::"+sc.getInitParameter("dbuser"));
	    //read init param values
	    ServletConfig cg=getServletConfig();
	    pw.println("dbuser init param value::"+cg.getInitParameter("dbuser"));
	    
	    pw.println("<br> ServletContext obj class name::"+sc.getClass());
	    
	    pw.println("<br> Server info ::"+sc.getServerInfo());
	    pw.println("<br> Context Path ::"+sc.getContextPath());
	    pw.println("<br> Servlet api version ::"+sc.getMajorVersion()+"."+sc.getMinorVersion());
	    pw.println("<br> Path of web appcation ::"+sc.getRealPath("/"));
	    pw.println("<br> Path of input.html ::"+sc.getRealPath("/input.html"));
	    pw.println("<br> MIME type of  input.html"+sc.getMimeType("/input.html"));
	    //write log messages ....
	    sc.log("Todays Date and Time::"+new java.util.Date());
	    
	    

	    
	    //close stream
	    pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}
