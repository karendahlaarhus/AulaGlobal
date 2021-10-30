<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Enrollment</title>
<style>
.module {
	display: none;
	position: fixed;
  	z-index: 1;
  	background-color: white;
  	padding: 50px;
  	margin-left: 25%;
  	margin-right: 25%;
    box-shadow: 0 4px 8px 0 lightgrey;
}

.module span{
	float: right;
	
}
</style>
</head>
<body>
<%@page import="java.util.*, beans.*, dao.*"%>  

<h1>Course Enrollment</h1>

<% List<Course> courses = CourseDao.getCourses();
request.setAttribute("courses", courses);%>

<input name="searchInput" placeholder="Search..." type="text" id="searchInput"/>

<table>
	<tr>
		<th> ID </th>
		<th> Name </th>
		<th> School </th>
		<th> Study </th>
		<th> </th>
		<th> </th>
	</tr>
	<c:forEach items="${courses}" var="course">
	<div id="description${course.getId()}" class="module">
		<span onclick="hideModule('description${course.getId()}')">&times</span>
		<h3>${course.getId()} - ${course.getName()}</h3>
		<p> ${course.getDescription()} </p>
	</div>
	<div class="module">
	
	</div>
	<tr>
		<th class="courseId"> ${course.getId()} </th>
		<th> ${course.getName()} </th>
		<th> ${course.getSchool()} </th>
		<th> ${course.getAcademicCourse()} </th>
		<th> <button onclick="showModule('description${course.getId()}')">Read Description</button> </th>
		<th> <button>Manage Enrolled Students</button> </th>
	</tr>
	</c:forEach>
</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function showModule(id){
		$("#"+id).show()
}

function hideModule(id){
		$("#"+id).hide()
}
</script>

</body>
</html>