<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    
      <b> from a.jsp </b> <br>
    <!-- create 4 scope of attributes using pageContext -->
    
    <%
      pageContext.setAttribute("attr1","val1");
      request.setAttribute("attr2","val2");
      pageContext.setAttribute("attr3","val3",pageContext.SESSION_SCOPE );
      pageContext.setAttribute("attr4","val4",pageContext.APPLICATION_SCOPE);
    %>
    
    <!-- Forward request -->
    <jsp:forward  page="b.jsp"/>
