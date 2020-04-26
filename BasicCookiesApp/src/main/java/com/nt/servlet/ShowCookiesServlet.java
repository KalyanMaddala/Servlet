package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowCookiesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String title = "Active Cookies";
		
		pw.println("<html><head><title>"+title);
		pw.println("<title></head><body>");
		pw.println("<table border=1 align='center'>");
		pw.println("<tr><td>Cookie Name</td>");
		pw.println("<td>Cookie Value</td></tr>");
		
		Cookie[] cks=req.getCookies();
		if(cks!=null) {
			for(Cookie ck:cks) {
				pw.println("<tr><td>"+ck.getName()+"</td>"+"</td>"+ck.getValue()+"</td></tr>");
			}//for
			pw.println("</table></body></html>");
		}//if
		else {
			System.out.println("No Cookies Present");
			pw.println("<br><b>no cookies present");
		}//elsse
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}//doGet
}//class
