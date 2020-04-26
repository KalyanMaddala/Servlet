package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String engine=null;
		String url=null;
		String ss=null;
		//get printwriter
		pw=res.getWriter();
		res.setContentType("text/html");
		ss=req.getParameter("ss");
		engine=req.getParameter("engine");
		//prepareurl with query String for send redirection
		
		if(engine.equals("google")) {
			url="https://www.google.co.in/search?q="+ss;
		}
		else if(engine.equals("bing")) {
			url="https://www.bing.com/search?q="+ss;
		}
		else if(engine.equals("yahoo")) {
			url="https://in.search.yahoo.com/search?q="+ss;
		}
		System.out.println("Before SearchServlet :: SendRedirect");
		res.sendRedirect(url);
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req,res);
		System.out.println("After SearchServlet :: SendRedirect");
		
	}//doGet

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
