package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.nt.bo.TrainTicketBO;

public class TrainTicketDAOImpl implements TrainTicketDAO{
	private static final String TRAINTICKET_INSERT_QUERY="INSERT INTO TRAIN_TICKET VALUES(?,?,?,?,?,?)";
    public int insert(TrainTicketBO bo) {
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
			 ps=con.prepareStatement(TRAINTICKET_INSERT_QUERY);
			 //set values to query params
			 ps.setString(1,bo.getPassengerName());
			 ps.setString(2,bo.getSource());
			 ps.setString(3,bo.getDestination());
			 ps.setFloat(4,bo.getDistance());
			 ps.setFloat(5, bo.getFare());
			 ps.setString(6, bo.getResult());
			 //execute query
			 if(ps!=null)
			 result=ps.executeUpdate();
			 
			if(result==0) 
				  System.out.println("Records insertion failed"); 
			  else
			  System.out.println("Records insertion succeded");
			 
		 }	 
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