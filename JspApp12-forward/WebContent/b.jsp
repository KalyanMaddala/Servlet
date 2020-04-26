<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <b> from b.jsp</b> <br>
    <%=new java.util.Date() %>
    <br> request param values are <%=request.getParameter("bookName") %>,
                                                              <%=request.getParameter("bookPrice") %>
