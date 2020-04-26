package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.CountryClubBO;



public class CountryClubDAO {
	private static final String COUNTRYCLUB_INSERT_QUERY="INSERT INTO COUNTRY_CLUB VALUES(?,?,?,?,?,?)";
 
	 public int insert(CountryClubBO bo) {
		 InitialContext ic=null;
		 DataSource ds=null;
		 Connection con=null;
		 PreparedStatement ps=null;
		 int result=0;
		 try {
			 //create InitialContext
			 ic=new InitialContext();
			 //get DataSource oobject through lookup operation
			 ds=(DataSource)ic.lookup("java:/comp/env/mypool");
			 //get Connection form JDBC con pool
			 con=ds.getConnection();
			 //create preparedStatement object
			 ps=con.prepareStatement(COUNTRYCLUB_INSERT_QUERY);
			 //set values to query params
			 ps.setString(1,bo.getName());
			 ps.setString(2,bo.getAddress());
			 ps.setString(3,bo.getPackage());
			 ps.setFloat(4, bo.getPackageAmount());
			 ps.setFloat(4, bo.getDiscountAmount());
			 ps.setFloat(5, bo.getNetAmount());
			 //execute query
			 result=ps.executeUpdate();
		 }//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		 catch(Exception e) {
				e.printStackTrace();
			}
		 finally {
			 try {
				 if(ps!=null)
					 ps.close();
			 }
			 catch(SQLException se) {
					se.printStackTrace();
				}
			 try {
				 if(con!=null)
					 con.close();
			 }
			 catch(SQLException se) {
					se.printStackTrace();
				}
		 }//finally
		 return result;
	 }//method
}//class
