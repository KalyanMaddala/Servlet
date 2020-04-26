<%@page  import="java.sql.*"%>

<%!
Connection con=null;
PreparedStatement ps1=null,ps2=null;
ResultSet rs=null;
public void jspInit(){
	ServletConfig cg=null;
	String driver=null,url=null,dbuser=null,dbpwd=null;
	
	try{
 	 //get Access to Servletconfig object
	       cg=getServletConfig(); 
 	  //read jdbc porperties as init param values
 	  driver=cg.getInitParameter("driver");
 	  url=cg.getInitParameter("url");
 	 dbuser=cg.getInitParameter("dbuser");
 	  dbpwd=cg.getInitParameter("dbpwd");
 	  //load jdbc driver class
 	  Class.forName(driver);
 	  //establish the connection
 	    con=DriverManager.getConnection(url,dbuser,dbpwd);
 	  //create JDBC PreparedStatement objects
 	  ps1=con.prepareStatement("INSERT INTO STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?)");
 	  ps2=con.prepareStatement("SELECT SNO,SNAME,SADD,AVG FROM STUDENt");
 	  
       }
	catch(SQLException se){
		se.printStackTrace();
	}
	catch(Exception e){
		e.printStackTrace();
	}
}//jspInit()
%>

 <%
    String name=null,addrs=null;
      float avg=0.0f;
      int result=0;
      ResultSetMetaData rsmd=null;
      int colCount=0;
    //read additional req param value (s1) 
    String  s1=request.getParameter("s1");
    if(s1.equalsIgnoreCase("register")){
    	  //read form data
    	  name=request.getParameter("sname");
    	  addrs=request.getParameter("addrs");
    	  avg=Float.parseFloat(request.getParameter("avg"));
    	  //set form data as request param values(?)
    	  ps1.setString(1,name); ps1.setString(2,addrs); ps1.setFloat(3,avg);
    	  //execute the query
    	  result=ps1.executeUpdate();
    	  //process the Result
    	  if(result==0){  %>
    	       <h1 style='color:red;text-align:center'>Registration Failed</h1>
    	    <%  }
    	   else{  %>
    	        <h1 style='color:red;text-align:center'>Registration succeded</h1>
 <%      }
    }//if
    else{
    	//execute the Query
    	rs=ps2.executeQuery();
    	//get ResultSetMEtaData obj
    	 rsmd=rs.getMetaData();
    	//get ColumnCount
    	colCount=rsmd.getColumnCount();  %>
    	<table border="1" align="center">
    	   <tr>
    	   <%
    	     for(int i=1;i<=colCount;++i){ %>
    	    	 <th><%=rsmd.getColumnLabel(i) %> </th>
    	   <%  }//for
    	   %>
    	   </tr>
    	   
    	   <%
    	     while(rs.next()){ %>
    	    	 <tr>
    	    	   <%
    	    	     for(int i=1;i<=colCount;++i){ %>
    	    	    	 <td><%=rs.getString(i) %>  </td>
    	    	     <%}//for
    	    	   %>
    	    	   </tr>
    	   <%  }//while
    	   %>
    	</table>
  <% }//else
 %>
   <br><br>
    <a href="input.html">home</a>
 
 <%!  public void jspDestroy(){
         //close jdbc objs
	 try{
    	 if(rs!=null)
    		 rs.close();
     }
     catch(SQLException se){
    	 se.printStackTrace();
     }
         try{
        	 if(ps1!=null)
        		 ps1.close();
         }
         catch(SQLException se){
        	 se.printStackTrace();
         }
         try{
        	 if(ps2!=null)
        		 ps2.close();
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
	 
     }//jspDestroy()
	 %>



