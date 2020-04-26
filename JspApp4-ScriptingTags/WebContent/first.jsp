
 <%!  public  String findBig(int a,int b){
 	    //      int a=10;  
             if(a<b)
                  return b+" is big";
              else if(b<a)
                     return a+" is big";
              else
            	   return "both are equal";
            	 } %>  
  
   <%--<h1 style="text-align:center"> Welcome to jsp </h1> --%> 
  
  Big Value  ::  <%=findBig(10,20) %>  <br>
  
  System date :: <%-- <%=new java.util.Date() %> --%>
              	 