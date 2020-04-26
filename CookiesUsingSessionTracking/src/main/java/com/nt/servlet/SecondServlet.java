package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get printwriter object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		//get values submitted by the form2
		String income=req.getParameter("income");
		String tax=req.getParameter("tax");
		
		//read foem1/req1 data from cookies
		Cookie ck[] = req.getCookies();
		String name=null,fname=null;
		if(ck!=null) {
			name=ck[0].getValue();
			fname=ck[1].getValue();
		}//if
	//use JDBC code to store form1/req1 and form2/req2 values in DB table
		try {
			//register JDBC driver and establish the connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");
			// create prepareStatement object pointing to SQL query
			PreparedStatement ps=con.prepareStatement("INSERT INTO TAX_TAB VALUES(?,?,?,?)");
			//set values to query params
			ps.setString(1, name);
			ps.setString(2, fname);
			ps.setString(3, income);
			ps.setString(4,tax);
			//execute the query
			int result=ps.executeUpdate();
			if(result==1)
				pw.println("<br>Record has been Inserted");
			else
				pw.println("<br>Record is not Inserted");
			}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		//display both form1,foorm2 data
		pw.println("Form2 data "+income+" "+tax+"<br>");
		pw.println("Form1 data "+name+" "+fname+"<br>");
		//close streams
		pw.close();
	}
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
