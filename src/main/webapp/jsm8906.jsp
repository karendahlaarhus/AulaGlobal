<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSM8906</title>
</head>
<body>
<%@page import="java.util.*, beans.*, dao.*"%> 

<h1>Access Registration</h1> 


<% List<UserSession> userSessions = UserSessionDao.getUserSessions();
request.setAttribute("userSessions", userSessions);%>

<table>
	<tr>
		<th> Username </th>
		<th> Login Time </th>
		<th> Logout Time </th>
	</tr>
	<c:forEach items="${userSessions}" var="userSession">
	<tr>
		<td> ${userSession.getIdUser()} </td>
		<td> ${userSession.getStartDateTime() } </td>
		<td> ${userSession.getEndDateTime() } </td>
	</tr>
	</c:forEach>
</table>


</body>
</html>