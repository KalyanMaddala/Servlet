//EmpSearchServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
//jdbc api
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

public  class EmpSearchServlet extends  HttpServlet
{ 
	private static final String  GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SALARY,DNO FROM EMP WHERE EMPNO=?";

	public void doGet(HttpServletRequest req,
		                                  HttpServletResponse res)throws ServletException,IOException{
		 PrintWriter pw=null;
		 int eno=0;
		 Connection con=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 ServletConfig cg=null;
		 String driver=null,url=null,user=null,pwd=null;
		 Enumeration e=null;
		 try{
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		eno=Integer.parseInt(req.getParameter("empno"));
		//get Access to ServletConfig obj
		cg=getServletConfig();
		// read jdbc properties as init param values
		driver=cg.getInitParameter("driver");
		url=cg.getInitParameter("url");
		user=cg.getInitParameter("dbuser");
		pwd=cg.getInitParameter("dbpwd");
		//Load jdbc driver class
		Class.forName(driver);
		//establish the connection
		con=DriverManager.getConnection(url,user,pwd);
		//create Jdbc PreparedStatement object
		ps=con.prepareStatement(GET_EMP_DETAILS);
		//set query param value
		ps.setInt(1,eno);
		//send and execute Query
          rs=ps.executeQuery();
		  //process the ResultSet
		  if(rs.next()){
			    pw.println("<h3 style='color:red;text-align:center'>Emp Details are   :: </h3>");
				pw.println("<br><b> Emp number ::"+rs.getInt(1)+"</b>");
				pw.println("<br><b> Emp name ::"+rs.getString(2)+"</b>");
				pw.println("<br><b> Emp Desg ::"+rs.getString(3)+"</b>");
				pw.println("<br><b> Emp Salary ::"+rs.getFloat(4)+"</b>");
				pw.println("<br><b> Emp Dept no ::"+rs.getInt(5)+"</b>");
		  }
		  else{
			    pw.println("<h2 style='color:red;text-align:center'> Record not found </h2>");
		  }
		  //add hyperlink
		   pw.println("<br> <a href='input.html'>home </a>");
		   //display all init param names and values
		   e=cg.getInitParameterNames();
		   while(e.hasMoreElements()) {
			   String name=(String)e.nextElement();
			   String value=cg.getInitParameter(name);
			   pw.println("<br>"+name+"   "+value+"<br>");
		   }
		   pw.println("<br>Servlet Config obj class name:::"+cg.getClass());
		   pw.println("<br> servlet class logical name::"+cg.getServletName());
		   //close stream
		   pw.close();
		 }//try
		 catch(SQLException se){
            se.printStackTrace();
			pw.println("<br> <h3 style='color:red;text-align:center'>Internal DB Problem  </h3>");
		  //add hyperlink
		   pw.println("<br> <a href='input.html'>home </a>");
		 }//catch
		 catch(Exception ex){
            ex.printStackTrace();
			pw.println("<br> <h3 style='color:red;text-align:center'>Un known Internal  Problem  </h3>");
		   pw.println("<br> <a href='input.html'>home </a>");
		 }//catch
		 finally{
			 //close jdbc objs
			 try{
				 if(rs!=null)
					   rs.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }

			 try{
				 if(ps!=null)
					   ps.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }

			 try{
				 if(con!=null)
					   con.close();
			 }
			 catch(SQLException se){
				 se.printStackTrace();
			 }
		 }//finally
      }//doGet(-,-)

	  public void doPost(HttpServletRequest req,
		                                     HttpServletResponse res)throws ServletException,IOException{
		  doGet(req,res);
	  }//doPost(-,-)

}//class