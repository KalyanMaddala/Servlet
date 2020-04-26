package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
    
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		String name=null,gender=null,ms=null,addrs=null,qlfy=null,crs[]=null,hb[]=null;
		int age=0;
		PrintWriter pw=null;
		//get PrintWriter object
		pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read from data
		name=req.getParameter("tname");
		age=Integer.parseInt("tage");
		gender=req.getParameter("gen");
		ms=req.getParameter("ms");
		addrs=req.getParameter("taddress");
		qlfy=req.getParameter("qlfy");
		crs=req.getParameterValues("crs");
		hb=req.getParameterValues("hb");
		//write request processing logic
		if(gender.equalsIgnoreCase("M"))
		{
			if(age<=5)
				pw.println(name+"Your are Baby Boy");
			else if(age<=12)
				pw.println(name+"Your are Small Boy");
			else if(age<=19)
				pw.println(name+"Your are Teenage Boy");
			else if(age<=35)
				pw.println(name+"Your are Young Man");
			else if(age<=50)
				pw.println(name+"Your are MiddleAged Man");
			else
				pw.println(name+"Your are Budda");
		}//if
		else if(gender.equalsIgnoreCase("F"))
		{
			if(age<=5)
				pw.println(name+"Your are Baby Girl");
			else if(age<=12)
				pw.println(name+"Your are Small Girl");
			else if(age<=19)
				pw.println(name+"Your are Teenage Girl");
			else if(age<=35)
				pw.println(name+"Your are Young Girl");
			else if(age<=50)
				pw.println(name+"Your are MiddleAged Girl");
			else
				pw.println(name+"Your are old Woman");
			
		}
		pw.println("<br>name="+name);
		pw.println("<br>age="+age);
		pw.println("<br>gender="+gender);
		pw.println("<br>Martial Status="+ms);
		pw.println("<br>Address="+addrs);
		pw.println("<br>Qualification="+qlfy);
		pw.println("<br>Courses="+Arrays.toString(crs));
		pw.println("<br>Hobbies="+Arrays.toString(hb));
	}//doGet(-,-)
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}

}
