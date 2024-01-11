<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
	<style type="text/css">
		h2{ 
		  position:absolute;
		  left: 43%;
		  top: 30%;
		  text-shadow: 5px 3px 6px ;
		  color: green;
		}
	
	    #main{
	       border: 1px solid black;
	       position: absolute;
	       left: 40%;
	       top: 45%;
	       width: 200px;
	       text-align: center;
	       line-height: 30px;
	       border-radius: 15px;
	       text-decoration: none;
	      
	    }
	    
	    
	
	</style>
</head>
<body>
		<h2 > GreenFilms</h2>
        <div id="main">
	    <a href="MainAdmin.jsp" id="admin" class="content">Admin</a>
	    <br>
	    <a href="MainUser.jsp" id="user" class="content">User</a>
        </div>
</body>
</html>