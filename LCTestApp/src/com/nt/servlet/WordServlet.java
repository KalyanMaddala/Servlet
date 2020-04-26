//WordServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import   java.io.*;
import java.util.*;

public class WordServlet extends  HttpServlet
{
	static {
		System.out.println("WordServlet::static block");
	}
	
	public WordServlet() {
		System.out.println("WordServlet :: 0-param constructor");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	  System.out.println("WordServlet:: init(-)");
	}
	
	//2nd service (-,-) method
	public void   service(HttpServletRequest req,  HttpServletResponse res)throws ServletException,IOException{
		System.out.println("WordServlet.service(-,-)");  
		PrintWriter pw=null;
         //get PrintWriter 
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("application/msword");
		 //write b.logic 
		 pw.println("<table border='1'  style='color:red'>");
		 pw.println("<tr> <th>Cricketer name  </th> <th> Role </th> <th> JersyNo </th> <th> NickName  </th> </tr>");
         pw.println("<tr> <td> Kohli </td> <td> captain </td> <td> 18</td> <td>Run Machine </td> </tr>");
		 pw.println("<tr> <td> Dhoni </td> <td> Ass.Captain </td> <td> 7</td> <td>Mr.Cool </td> </tr>");
		 pw.println("<tr> <td> Rohit </td> <td> Vice.Captain </td> <td> 45</td> <td> Hit Man </td> </tr>");
		 pw.println("<tr> <td> Panth </td> <td> Ameture Batsman </td> <td> 17</td> <td> WrostFellow </td> </tr>");
		 pw.println("</table>");
		 //close stream
		 pw.close();
	}//service(-,-)
}//class
