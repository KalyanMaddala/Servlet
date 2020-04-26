<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <!-- create or Locate StudentBean class object -->
    <jsp:useBean id="st"  class="com.nt.beans.StudentBean" scope="session"/>
    <b> Bean class object is created/Locaed</b>
    <!--set values to bean properties  -->
    <%-- <jsp:setProperty name="st"  property="sno"  value="1001"/>
    <jsp:setProperty property="sname" name="st" value="karan"/>
    <jsp:setProperty property="sadd" name="st" value="hyd"/>
    <jsp:setProperty property="avg" name="st" value="90.55f"/> --%>
    
  <%--    <jsp:setProperty name="st"  property="sno"  param="stno"/>
    <jsp:setProperty property="sname" name="st" param="stname"/>
    <jsp:setProperty property="sadd" name="st"  param="stadd"/>
    <jsp:setProperty property="avg" name="st"  param="stavg"/>  --%>
    
    <jsp:setProperty property="*" name="st"/>
    
    
    <br>
      <b>Values are set to Bean proeprties </b>
    
    
