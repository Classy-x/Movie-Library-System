<%@page import="com.dto.Movie"%>
<%@page import="java.util.List"%>
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
         left: 35.3%;
         top: 10%;
       }
       #main{
	      border: 1px solid black;
	      position: absolute;
	      left: 35%;
	      top: 18%;
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
		#img{
		   background-image: url("");
		   
		}
   </style>
</head>
<body>
         <h3 id="head">ADD MOVIE HERE</h3>
      
      <div id="main">
          <form action="Addmovie" method="post" enctype="multipart/form-data">
         Movie Id: <br> <input type="number" name="mid"> <br>
         Movie Name: <br> <input type="text" name="mname"><br>
         Movie Price: <br> <input type="text" name="mprice"><br>
         Movie Rating: <br> <input type="text" name="mrating"><br>
         Movie Language:<br> <input type="text" name="mlan"><br>
         Movie Image: <br> <input type="file" name="mimg"><br>
 	    <br>
 	    <input type="submit" class="button">
         
      </form>
          
      
     </div>
</body>
</html>