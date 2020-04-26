<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    
    <b> from a.jsp (start)</b>
     <%
        float price=1000.0f;
     %>
      <jsp:forward page="b.jsp">
          <jsp:param value="<%=price %>" name="bookPrice"/>
          <jsp:param value="CRJ" name="bookName"/>
      </jsp:forward>
       <br>
    <b> end of a.jsp</b>
          
    
    
    

    
    
