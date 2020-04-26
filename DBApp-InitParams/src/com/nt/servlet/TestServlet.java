package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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
	    //read init param values
	    ServletConfig cg=getServletConfig();
	    pw.println("dbuser init param value::"+cg.getInitParameter("dbuser"));
	    pw.println("<br>p1 init param value"+cg.getInitParameter("p1"));
	    
	    //close stream
	    pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}
