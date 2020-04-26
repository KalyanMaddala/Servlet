package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//read form1/request1 data
		String name=req.getParameter("hname");
		String fname=req.getParameter("hfname");
		String ms=req.getParameter("hms");
		
		//read form2/request2 data
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		//write form1/req1,form2/req2 values to DB table as record
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");
			PreparedStatement ps=con.prepareStatement("INSERT INTO HIDDEN_TAB VALUES(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, fname);
			ps.setString(3, ms);
			ps.setString(4, f2val1);
			ps.setString(5, f2val2);
			
			int result=ps.executeUpdate();
			if(result==1)
				pw.println("<br>Record Inserted<br>");
			else
				pw.println("<br>Record Not Inserted<br>");
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		//display request1/form1,request2/form2 data on the browser window
		
		pw.println("<br>form1 data is "+name+" "+fname+" "+ms);
		pw.println("<br>form2 data is "+f2val1+" "+f2val2);
		//close stream object
		pw.close();
	}
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
