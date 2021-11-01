<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>

<h1>Welcome!</h1>
<p> You are a new user! Please add your name: </p>
 <% Object username = request.getAttribute("username"); %>

<p> ${username} </p>


<form id="updateUserForm" action="updateUser" method="post">
	<input type="hidden" name="username" value="${username}">  
	Firstname: <input type="text" name="name" required="required"/><br/><br/>  
	Surname: <input type="text" name="surname" required="required"/><br/><br/>
	<input type="submit" value="Add Student"/> 
</form>

</body>
</html>