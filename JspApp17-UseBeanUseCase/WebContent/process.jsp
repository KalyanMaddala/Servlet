<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <!-- create DTO class object -->
    <jsp:useBean id="dto" class="com.nt.dto.EmployeeDTO" scope="request"/>
    
    <!-- Write form data to  DTO class object -->
    <jsp:setProperty property="*" name="dto"/>
    
    <!-- Create /Locate Service class object  -->
     <jsp:useBean id="service"  class="com.nt.service.PayRollServiceImpl"  scope="application"/>
     <%
       //invoke method
       service.generatePaySlip(dto);
     %>
     
     <!-- Display payslip details on to the browser as response -->
      <h1 style="color:red;text-align:center">Payslip details  </h1>
      employee name ::: <jsp:getProperty property="ename" name="dto"/> <br>
      employee desg ::: <jsp:getProperty property="desg" name="dto"/> <br>
      employee basicSalary ::: <jsp:getProperty property="salary" name="dto"/> <br>
      employee grossSalary ::: <jsp:getProperty property="grossSalary" name="dto"/> <br>
       employee netSalary ::: <jsp:getProperty property="netSalary" name="dto"/> <br>
       
       <br>
       <a href="form.html">home</a>
       
     
     
    
    
    
