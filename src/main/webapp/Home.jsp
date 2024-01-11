<%@page import="com.dao.AdminDao"%>
<%@page import="java.util.Base64"%>
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
		.button{
			border: 1px solid rgb(0, 0, 0);
			border-radius: 5px;
			
			
		}
		.button:hover{
			color: rgb(0, 128, 192);
			border: 1px solid blue;
			border-radius: 5px;
		}
		#anchr{
	     	text-decoration: none;
		}
		
 </style>

</head>
<body>

	 <h1>Movies</h1>     
      <% %>

      <table border= "2px" style="border-collapse: collapse; width: 500px; height: 100px; text-align: center; height: 50vh; width: 150vh;">
        <tr> 
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Ratings</th>
            <th>Language</th>
            <th>Image</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
         
		<%AdminDao dao=new AdminDao();
		 List<Movie> movie=dao.getAllMovies();
		if(movie!=null){
		for(Movie m:movie){ %>
		
		<tr style="border-collapse: collapse;">
			<td> <%= m.getId() %> </td>
			<td> <%= m.getName() %> </td>
			<td> <%= m.getPrice() %> </td>
			<td> <%= m.getRate() %> </td>
			<td> <%= m.getLanguage() %> </td>
			
			<% String base64image = new String(Base64.getEncoder().encode(m.getImage())); %>
			<td> <img alt="image loading" src="data:image/jpeg;base64,<%= base64image %>" height="150px" width="150px"> </td>	
			
		<td>  <a href="deletemovie?mid=<%=m.getId() %>">Delete</a></td>	
		<td> <a href="editmovie?mid=<%=m.getId() %>">Edit</a> </td>
		</tr>
	
		<%} }%>
    
      </table>
      <br>
     <button class="button">  
      <a href="AddMovies.jsp" style="color: black;" id="anchr">Add Movies</a></button>
</body>
</html>