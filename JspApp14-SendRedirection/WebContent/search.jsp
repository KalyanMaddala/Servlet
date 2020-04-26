<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%
      //read Search String
      String ss=request.getParameter("ss");
      //perform sendRedirection with google
      response.sendRedirect("https://google.com/search?q="+ss);
      response.sendRedirect("https://bing.com");
    %>
    
    
