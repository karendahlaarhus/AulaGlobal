<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aula Master</title>
</head>
<body>

<h1> Aula Master </h1>
<a href="students.jsp">Student Administration</a>  
<a href="courseEnrollment.jsp">Manage Course Enrollment</a> 

<c:if test="${sessionScope.username != null }"> 
<form id="logoutForm" action="userLogout" method="post">
<input type="submit" value="logout">
</form>
</c:if>
<c:if test="${sessionScope.username == null }"> 
<c:redirect url="/noAccess.jsp"/>>	
</c:if>

<script>

</script>
</body>
</html>
