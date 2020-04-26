package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class ThirdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		pw = res.getWriter();
		res.setContentType("text/html");
		//read form2/request2 data
		String city=req.getParameter("city");
		String sal=req.getParameter("sal");
		
		 //get access to session object
		HttpSession ses =req.getSession(false);
     
	//read form1/req1 and form2/req2 data in session attributes
		String name=(String) ses.getAttribute("name");
		String address=(String) ses.getAttribute("address");
		String age=(String) ses.getAttribute("age");
		String exp=(String) ses.getAttribute("exp");
		String skills=(String) ses.getAttribute("skills");
		
		//insert form1/req1,form2/re2 and form3/req3 values as record 
		try {
			//register JDBC driver and establish the connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");
			// create prepareStatement object pointing to SQL query
			PreparedStatement ps=con.prepareStatement("INSERT INTO INFO_TAB VALUES(?,?,?,?,?,?,?)");
			//set values to query params
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3,age);
			ps.setString(4,exp);
			ps.setString(5,skills);
			ps.setString(6,city);
			ps.setString(7,sal);
			
			int count=ps.executeUpdate();
			//invalidate the session 
			ses.invalidate();
			if(count==1) {
				pw.println("<body bgcolor=cyan>");
				pw.println("<center><h1><font color=red>Sucessfully inserted</font></h1></center>");
				pw.println("</table></body>");
				}
			else {
				pw.println("<body bgcolor=cyan>");
				pw.println("<center><h1><font color=red>try again</font></h1></center>");
				pw.println("<a href=personal.html>Home</a>");
			}
		}//try
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<body bgcolor=cyan>");
			pw.println("<center><h1><font color=red>Try Again</font></h1></center>");
			pw.println("<a href=personal.html>Home</a>");
		}
		
	}
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
