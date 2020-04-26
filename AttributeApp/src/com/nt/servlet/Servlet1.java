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

public class Servlet1 extends HttpServlet{
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
		
		//create request attribute
		req.setAttribute("attr1", "val1");
		
		//create session attribute
		ses=req.getSession();
		ses.setAttribute("attr2", "val2");
		
		//create servlet context attribute
		sc=getServletContext();
		sc.setAttribute("attr3","val3");
		
		//Forward the request to Servlet2 component
		rd=req.getRequestDispatcher("/s2url");
		rd.forward(req, res);
		//close stream
		pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		doGet(req,res);
	}
}
