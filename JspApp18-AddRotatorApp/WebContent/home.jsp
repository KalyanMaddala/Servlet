<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <!-- create/Locate service class object -->
    <jsp:useBean id="service"  class="com.nt.service.AddRotatorService" scope="session"/>
    
    <%
         service.nextAdvertisement();
         response.setHeader("refresh","2");
    %>
    
    <a href='<jsp:getProperty property="link" name="service"/>'>
        <img  src='<jsp:getProperty property="image" name="service"/>'/>
    </a>
    <br><br><br>
    
    <h1 style="color:red;text-align:center">DailyHunt.com</h1>
    
    
