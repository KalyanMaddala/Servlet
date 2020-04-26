package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



public class ConnPoolServlet extends HttpServlet{
	
	@Resource(name="DsJndi")
	private DataSource ds;

@Override
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
   Connection con=null;
   Statement st=null;
   ResultSet rs=null;
   PrintWriter pw=null;
   String tabName=null;
   ResultSetMetaData rsmd=null;
   int colCnt=0;
   
   //General settings
   pw=res.getWriter();
   
   //set response content type
   res.setContentType("text/html");
   
   //read form data 
   tabName=req.getParameter("table");
   
   //write JDBC code for remaining work
   try {
	   //get con object from JDBC con pool
	   con=makeConnection();
	   
	   //create statement object
	   st=con.createStatement();
	   
	   //send and execute SQL Query in DB software
	   rs=st.executeQuery("select * from "+tabName);
	   
	   //get ResultSetMetaData
	   rsmd=rs.getMetaData();
	   
	   //print col names
	   colCnt=rsmd.getColumnCount();
	   
	   pw.println("<table border='1' bgcolor='red'>");
	   pw.println("<tr bgcolor='cyan'>");
	   for(int i=1;i<=colCnt;++i) {
		   pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
		    }
	   pw.println("</tr>");
	   //process the result
	   while(rs.next()) {
		   pw.println("<tr>");
		   for(int i=1;i<=colCnt;++i) {
			   pw.println("<td>"+rs.getString(i)+"</td>");
		   }
		   pw.println("</tr>");
	   }
	   pw.println("</table>");
	   pw.println("<br><a href='index.html'>Try Again</a>");
	   //close JDBC objects
	   rs.close();
	   st.close();
	   con.close();
   }//try
   catch(Exception e) {
	   pw.println("<b><center>Internal Problem</center></b>");
	   pw.println("<br><a href='index.html'>Try Again</a>");
   }
   //close streams
   pw.close();
   }//doGet
@Override
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
}
private Connection makeConnection() {
	Connection con=null;
	InitialContext ic=null;
	DataSource ds=null;
	

	try {
		//locate jndi registry
		ic=new InitialContext();
		//get Datasource object from jndi registry
		ds=(DataSource)ic.lookup("DsJndi");
		//get JDBC con object from JDBC con pool
		con=ds.getConnection();
		}//try
	catch(Exception e) {
		e.printStackTrace();
	}
	return con;
  }//make connection
}//class