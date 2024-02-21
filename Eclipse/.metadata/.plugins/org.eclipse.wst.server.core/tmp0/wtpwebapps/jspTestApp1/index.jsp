<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%!
      static int x = 10;
      static int y = 20;
      static int z;
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
    <h1>Welcome to JSP Programming</h1>
    
    <!-- bellow code is to perform the addition of two numbers -->
    <%
     float p = 10.0f;
    z = x + y;
    %>
    <%= "Addition is:"+z %>  <!--expression tag -->
</body>
</html>