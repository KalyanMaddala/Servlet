package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet{
	Connection con;
	PreparedStatement ps;
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SALARY FROM EMP WHERE EMPNO=?";
	public void init() {
		String driver=null,url=null,dbuser=null,dbpwd=null;
		try {
			//Access ServletContext object
			ServletContext sc=getServletContext();
			driver=sc.getInitParameter("driver");
			url=sc.getInitParameter("url");
			dbuser=sc.getInitParameter("dbuser");
			dbpwd=sc.getInitParameter("dbpwd");
			//register JDBC driver
			Class.forName(driver);
			//establish the connection
			con=DriverManager.getConnection(url,dbuser,dbpwd);
			//create preparedStatement object
			ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
		 }//try
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}//init()
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=null;
		int no=0;
		ResultSet rs=null;
		RequestDispatcher rd=null,rd1=null,rd2=null;
		try {
			//include header content
			rd1=req.getRequestDispatcher("/headurl");
			rd1.include(req,res);
			//get PrintWriter object
			pw=res.getWriter();
			//set response content type
			res.setContentType("text/html");
			pw.println("<b>Before raising Exception</b>");
			//read form data (request data)
			no=Integer.parseInt(req.getParameter("teno"));
			//set value to preparedStatement SQL Query parameter
			ps.setInt(1, no);
			//execute the SQLQuery
			rs=ps.executeQuery();
			//process the resultset
			if(rs.next()) {
				pw.println("<br>Emp No::"+rs.getInt(1));
				pw.println("<br>Emp Name::"+rs.getString(2));
				pw.println("<br>Emp Job::"+rs.getString(3));
				pw.println("<br>Emp Salary::"+rs.getFloat(4));
				
			}//if
			else {
				pw.println("<b>Records not found</b>");
			}
			//add hyperlink
			pw.println("<br><br><a href='input.html'>Home</a>");
			//get access to ServletConfig object
			//include footer  content
			rd2=req.getRequestDispatcher("/footer.html");
			rd2.include(req, res);
			//close JDBC objects
			rs.close();
			//close stream
			pw.close();
		}
		catch(Exception e) {
			rd=req.getRequestDispatcher("/eurl");
			rd.forward(req, res);
		}
	}//doGet
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}
	public void destroy() {
		//close JDBC objects
		try {
			if(ps!=null) {
				ps.close();
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(con!=null) {
				con.close();
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}//destroy()

}//class
