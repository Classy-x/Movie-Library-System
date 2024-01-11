<%@page import="java.util.Base64"%>
<%@page import="com.dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

   <style type="text/css">
       #head{
         position: absolute;
         left: 35%;
         top: 4%;
       }
       #main{
	      border: 1px solid black;
	      position: absolute;
	      left: 35%;
	      top: 12%;
	      padding: 40px;
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
         <h3 id="head">Update Movie Here</h3>
      <% Movie m=(Movie)request.getAttribute("movies"); %>
      <div id="main">
          <form action="updatemovie" method="post" enctype="multipart/form-data">
         Movie Id: <br> <input type="number" name="mid" value="<%=m.getId() %>" readonly="readonly"> <br>
         Movie Name: <br> <input type="text" name="mname" value="<%=m.getName() %>"><br>
         Movie Price: <br> <input type="text" name="mprice" value="<%=m.getPrice() %>"><br>
         Movie Rating: <br> <input type="text" name="mrating" value="<%=m.getRate() %>"><br>
         Movie Language:<br> <input type="text" name="mlan" value="<%=m.getLanguage() %>"><br>
       	
         Movie Image: <br> <input type="file" name="mimg"><br> 
 	    <br>
 	     <% String base64image = new String(Base64.getEncoder().encode(m.getImage())); %>
        <img alt="image loading" src="data:image/jpeg;base64,<%= base64image %>" height="150px" width="150px"> 	
		
 	    <input type="submit" class="button">
         
      </form>
          
      
     </div>
</body>
</html>