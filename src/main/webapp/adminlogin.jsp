<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <style type="text/css">
    
          #main{
	      border: 1px solid black;
	      position: absolute;
	      left: 38%;
	      top: 30%;
	      padding: 50px;
	      border-radius: 10px;
	      background-color: beige;
	      box-shadow: 5px 6px 8px 2px;
	   }
		.button{
			border: 1px solid rgb(0, 0, 0);
			border-radius: 5px;
			
		}
		.button:hover{
			color: rgb(0, 128, 192);
			border: 1px solid blue;
			border-radius: 5px;
			
		}
    </style>
</head>
<body>
      
      <div id="main">
         <form action="alogin" method="post">
           Mail: <br>	  <input type="text" name="adminmail" > <br>
           Password: <br> <input type="password" name="adminpass" > <br> <br>
                   	      <input type="submit" class="button">
        </form>
      
      </div>
     
     <% String msg=(String) request.getAttribute("message"); %>
	<% if(msg !=null) {%>
	<%= msg %>
	<% } %>
</body>
</html>