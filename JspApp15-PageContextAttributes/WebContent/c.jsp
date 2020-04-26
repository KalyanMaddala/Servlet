<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <b> from c.jsp</b>
    <!-- Read and display 4 scopes of attributes -->
     attr1 (pageScope)  value :: <%=pageContext.findAttribute("attr1") %> <br>
     attr2 (requestScope)  value :: <%=pageContext.findAttribute("attr2") %> <br>
     attr3 (SessionScope)  value :: <%=pageContext.findAttribute("attr3") %> <br>
    attr4 (applicationScope)  value :: <%=pageContext.findAttribute("attr4") %> <br>

   
