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
  	margin-left: 20%;
  	margin-right: 20%;
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

<form id="searchForm" onSubmit="searchAndFilter()">
<input name="searchInput" placeholder="Search..." type="text" id="searchInput"/><br>
<b>School:</b> <label><input type = "checkbox" value= "Leganés">Leganés</label>
<label></label><input type = "checkbox" value="Getafe">Getafe</label> <br>
<b>Study:</b> <label><input type = "checkbox" value = "Computer Science and Engineering">Computer Science and Engineering</label>
<label><input type = "checkbox" value = "Buisness Administration">Buisness Administration</label><br>
<input type="submit" value="Search">
</form>

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
	<% 	Course current_course = (Course) pageContext.getAttribute("course");
			int id = current_course.getId();
			List<Student> students = EnrolledStudentsDao.getStudentsInCourse(id);
			request.setAttribute("students", students);%>
	
	<td>
	<div id="description${course.getId()}" class="module">
		<span onclick="hideModule('description${course.getId()}')">&times</span>
		<h3>${course.getId()} - ${course.getName()}</h3>
		<p> ${course.getDescription()} </p>
	</div>
	</td>
	
	<td>
	<div id="students${course.getId()}" class="module students">
		<span onclick="hideModule('students${course.getId()}')">&times</span>
		<h3>Students enrolled in ${course.getName()}</h3>
		
		<form id="addStudentToClassForm" action="enrollStudent" method="post">
			<input type="hidden" value="${course.getId()}" name="course">
			NIE of student you want to add: <input type="text" name="nie" required="required"/>
			<input type="submit" value="Add Student"/>
		</form>
	
		<table>
		<tr>
		<th> Student NIE </th>
		<th> Name </th>
		<th> Surname </th>
		</tr>
		<c:forEach items="${students}" var="student">
		<tr>
			<td class="studentNie"> ${student.getNie()} </td>
			<td> ${student.getName()} </td>
			<td> ${student.getSurname()} </td>
			<td> 
				<form id="removeStudentToClassForm" action="removeStudent" method="post">
					<input type="hidden" value="${course.getId()}" name="course">
					<input type="hidden" value="${student.getNie()}" name="nie" required="required"/>
					<input type="submit" value="Remove Student"/>
				</form>
			</td>
		</tr>
		</c:forEach>
		</table>
	</div>
	</td>
	
	<tr class=coursesTable>
		<td class="courseId"> ${course.getId()} </td>
		<td> ${course.getName()} </td>
		<td class="school">${course.getSchool()}</td>
		<td class="study">${course.getAcademicCourse()}</td>
		<td> <button onclick="showModule('description${course.getId()}')">Read Description</button> </td>
		<td> <button onclick="showModule('students${course.getId()}')">Manage Enrolled Students</button> </td>
	</tr>
	</c:forEach>
</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

$("#searchForm").submit(function(e) {
    e.preventDefault();
});

function searchAndFilter(){
	
	var checked = $("input:checkbox:checked").map(function () {
        return $(this).val()
    }).get()
	
    if (checked.length != 0){
	    $(".coursesTable").hide();
	    var schools = $(".school").filter(function () {
	        var school = $(this).text(),
	            index = $.inArray(school, checked);
	        return index >= 0
	    }).parent().show();
	    var study = $(".study").filter(function () {
	        var study = $(this).text(),
	            index = $.inArray(study, checked);
	        return index >= 0
	    }).parent().show();
    }
    
    if ($("#searchInput").val().length != 0){
    	var searchText = $("#searchInput").val().toLowerCase();
    	
        $(".courseId:visible").filter(function(){
            $(this).parent().toggle($(this).text().toLowerCase().indexOf(searchText) > -1)
        })
    }
}


function showModule(id){
		$("#"+id).show()
}

function hideModule(id){
		$("#"+id).hide()
}


</script>

</body>
</html>