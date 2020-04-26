package com.nt.servlet;
import javax.servlet.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class DateServlet extends GenericServlet{

      public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException {
		//set response content type
		res.setContentType("text/html");
		//get PrinterWriter object
		PrintWriter pw=res.getWriter();
		//write responser
		Date d= new Date();
  try{
       Thread.sleep(30000);
      }
  catch(Exception e){
                                                
                 }
 pw.println("<body bgcolor=Banana Yellow text=white > <center><h1>Dynamic  Web Application</h1><h3>Date and Time is ::"+d+"</h3></center><p style=font-size:16pt>A dynamic web page is a web page that displays different content each time it's viewed</p></body>");
 pw.println("<img src='Date.png' style='align:center; width=300 ;height=350;'>");
 pw.println("<br>our servlet class(Date Servlet) object hashcode()");
 pw.println("<br>request object hashcode"+req.hashCode());
 pw.println("<br>response object hashcode"+res.hashCode());
 pw.println("<br>current thread hashcode"+Thread.currentThread().hashCode());
   //close stream
 pw.close();
    }//service(-,-)

}//class
