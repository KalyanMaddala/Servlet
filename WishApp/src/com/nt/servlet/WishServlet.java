package com.nt.servlet;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class WishServlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	
	PrintWriter pw =null;
	Calendar calendar = null;
	int hour=0;
	
	//general settings
	pw = res.getWriter();
	//set content type
	res.setContentType("text/html");
	//get system Date
	calendar = Calendar.getInstance();
	hour = calendar.get(Calendar.HOUR_OF_DAY);
	//generate the wishmsg
	if(hour<=12)
		pw.println("<h1 style='color:red text-align:center'>Good Morning</h1>");
	else if(hour<=17)
		pw.println("<h1 style='color:red text-align:center'>Good AfterNoon</h1>");
	else if(hour<=20)
		pw.println("<h1 style='color:red text-align:center'>Good Evening</h1>");
	else
		pw.println("<h1 style='color:red text-align:center'>Good Night</h1>");
	
	//generate the hyperlink
	pw.println("<h2><a href='http://localhost:3030/WishApp/page.html' style='text-decoration:none';>Home</a></h2>");
	//close the stream
	pw.close();
	}
}	