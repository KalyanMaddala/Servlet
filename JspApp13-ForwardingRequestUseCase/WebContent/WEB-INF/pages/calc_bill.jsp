<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  //read form data
    String name=request.getParameter("iname");
    float price=Float.parseFloat(request.getParameter("iprice"));
    float qty=Float.parseFloat(request.getParameter("iqty"));
    //calc bill Amount
    float billAmt=price*qty;
    if(billAmt>=50000){ %>
    	 <jsp:forward page="discounturl" >
    	        <jsp:param value="<%=billAmt%>" name="bAmt"/>
    	 </jsp:forward>
    <%}
    else { %>
           <h1 style="color:red;text-align:center"> The D-Mart  </h1>
           <b><center> Billing Details</center></b>
           <b>Item name :: <%=name %> </b> <br>
           <b>Item price :: <%=price %> </b> <br>
           <b>Item qty :: <%=qty %> </b> <br>
           <b> Bill amount :: <%=billAmt %> </b> <br><br>
           <a href="input.html">home</a>
    <%} %>           
    


    