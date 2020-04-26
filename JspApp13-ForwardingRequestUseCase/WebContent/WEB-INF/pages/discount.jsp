<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%
    //read additonal req param value to get bill Amount
    float billAmt=Float.parseFloat(request.getParameter("bAmt"));
    //calc discount
    float discount=billAmt*0.2f;
    //generate final Bill amount
    float finalAmount=billAmt-discount;
 %>    
   <h1 style="color:red;text-align:center"> The D-Mart  </h1> <br>
    <b> The bill details are::
      item name :: <%=request.getParameter("iname") %> <br> 
      item price :: <%=request.getParameter("iprice") %> <br>
      item qty :: <%=request.getParameter("iqty") %> <br>
      Bill amount :: <%=billAmt %> <br>
      Discount amount ::<%=discount %> <br>
      Fill billAmount :: <%=finalAmount %> <br>
      </b> <br><br>
  <a href="input.html">home</a>     
 
    