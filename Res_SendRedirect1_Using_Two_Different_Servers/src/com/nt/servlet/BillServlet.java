package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillServlet extends HttpServlet{
   public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	   //General Settings
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   //read form data
	   String name=req.getParameter("t1");
	   float price=Float.parseFloat(req.getParameter("t2"));
	   float qty=Float.parseFloat(req.getParameter("t3"));
	   
	   //calc Bill Amt
	   float bamt=price*qty;
	   
	   if(bamt>=50000) {
		   System.out.println("before res.sendRD(-) in BillServlet");
		   res.sendRedirect("http://localhost:7001/Res_SendRedirect2_Using_Two_Different_Servers/discounturl?bill="+bamt+"&iname="+name);
	       System.out.println("After res.SendRD(-) in Bill Servlet");
	   }//if
	   else {
		   pw.println("<br>From BillServlet component<br>");
		   pw.println("<br>Item Name ::"+name+"Price ::"+price+"Quantity ::"+qty+"Bill Amount ::"+bamt);
	   }//else
	   //close stream
	   pw.close();
   }//doGet(-,-)
   public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	   doGet(req,res);   
	}
}
