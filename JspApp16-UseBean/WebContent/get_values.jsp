<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!-- create or Locate Java bean class object -->
<jsp:useBean id="st"  class="com.nt.beans.StudentBean"  scope="session"/>

<!-- read and display bean property values -->
sno==>  <jsp:getProperty name="st"  property="sno"/> <br>
sname==>  <jsp:getProperty name="st"  property="sname"/> <br>
sadd==>  <jsp:getProperty name="st"  property="sadd"/> <br>
avg==>  <jsp:getProperty name="st"  property="avg"/> <br>

<b> Bean proeprty values are read and displayed</b>

    
