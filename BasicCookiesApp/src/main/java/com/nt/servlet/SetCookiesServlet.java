package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SetCookiesServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie cookie1,cookie2,cookie3,cookie4;
		//defauult maxage is -1,indicating cookie
		//2 in-memory cookies applies only to current browsing session
		cookie1=new Cookie("Ap","Amaravathi");
		cookie2=new Cookie("Ts","Hyderabad");
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		
		//cookie is valid for an hour,regardless of whether
		//user quits browser,reboots computer of whatever
		//2 persistant cookies
		cookie3=new Cookie("Kr","Bangalore");
		cookie4=new Cookie("Mh","Mumbai");
		
		cookie3.setMaxAge(120);
		cookie4.setMaxAge(120);
		
		res.addCookie(cookie3);
		res.addCookie(cookie4);
		//get PrintWriter object
		PrintWriter pw=res.getWriter();
		//set Content Type
		res.setContentType("text/html");
		pw.println("Successful in Setting cookies");
		System.out.println("Successful in Setting cookies");
	}
		
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
