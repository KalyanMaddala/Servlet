package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiscountServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		   //General Settings
		   PrintWriter pw=res.getWriter();
		   res.setContentType("text/html");
		   //read additional request params given by BillServlet component(Source prg)
		   float amt=Float.parseFloat(req.getParameter("bill"));
		   String name=req.getParameter("iname");
		   System.out.println("From DiscountServlet ::doGet(-,-) method");
		   
		  
		   //calc Discount Amt
              float discount=amt*0.3f;
              float finalamt=amt-discount;
            
              //Display Details
			   pw.println("<br>Item Name ::"+name);
			   pw.println("<br>Bill Amount ::"+amt);
			   pw.println("<br>Discount ::"+discount+"Final Amount:: "+finalamt);
			   pw.println("<br>From DiscountServlet Component");
			   
		   //close stream
		   pw.close();
	   }//doGet(-,-)
	   public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		   doGet(req,res);   
		}
}

