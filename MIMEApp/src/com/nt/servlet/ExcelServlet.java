//ExcelServlet.java
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class ExcelServlet extends HttpServlet{
 public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
  
  //getPrintWriter
  PrintWriter pw=res.getWriter();
  //set response content type
  res.setContentType("application/vnd.ms-excel");
  //write logic to generate output(webpage)
   pw.println("<table border='1'>");
   pw.println("<tr><th>Cricketer name</th><th>Roll in Team</th><th>Jersey Number</th></tr>");
   pw.println("<tr><td>Kohli</td><td>Captain</td><td>18</td></tr>");
   pw.println("<tr><td>Dhoni</td><td>wicket keeper</td><td>7</td></tr>");
   pw.println("<tr><td>Sachin</td><td>All rounder</td><td>10</td></tr>");
   pw.println("<tr><td>Rohit</td><td>Vice Captain</td><td>45</td></tr>");
   pw.println("</table>");
   //close stream
   pw.close();
   }//service
}//class