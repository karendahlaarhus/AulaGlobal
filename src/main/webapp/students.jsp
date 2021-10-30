<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>AulaMaster</title>
<style>
.updateForm {
	display: none;
	position: fixed;
  	z-index: 1;
  	background-color: white;
  	padding: 50px;
  	margin-left: 25%;
    box-shadow: 0 4px 8px 0 lightgrey;
}

.updateForm span{
	float: right;
	
}
</style>

</head>
<body>
<%@page import="java.util.*, beans.*, dao.*"%>   
<h1>Student Administration</h1> 

<h3>ADD STUDENT</h3>
<form id="addStudentForm" action="createStudent" method="post">  
	NIE:<input type="text" name="nie" required="required"/><br/><br/>  
	Firstname: <input type="text" name="firstname" required="required"/><br/><br/>  
	Surname: <input type="text" name="surname" required="required"/><br/><br/>
	Date of birth: <input type="date" name="birthdate" required="required"/><br/><br/> 	
	<input type="submit" value="Add Student"/> 
</form>

<h3>DELETE STUDENT</h3>
<form id="deleteStudentForm" action="deleteStudent" method="post">
	Type the NIE of the student you would like to delete:  <br />
	<input type="text" name="nie" required="required"/>
	<input type="submit" value="Delete Student"/>
</form>

<h3>List of Students</h3>

<% List<Student> students = StudentDao.getStudents();
request.setAttribute("students", students);%>

<input name="searchInput" placeholder="Search..." type="text" id="searchInput"/>

<table>
	<tr>
		<th> NIE </th>
		<th> Name </th>
		<th> Surname </th>
		<th> Date of birth</th>
	</tr>
	<c:forEach items="${students}" var="student">
	<div class="updateForm" id="updateStudentForm${student.getNie()}">
		<span id="closeUpdateStudentForm" onclick="hideUpdateStudentForm('updateStudentForm${student.getNie()}')">&times</span>
		<h2>Update Student ${student.getNie()}</h2>  
		<form action="updateStudent" method="post"><br/>  
			<input type="hidden" name="nie" value="${student.getNie()}" readonly/> <br/> 
			Firstname: <input type="text" name="firstname" value="${student.getName()}"/><br/>  
			Surname: <input type="text" name="surname" value="${student.getSurname()}"/><br/>
			Date of birth: <input type="date" name="birthdate" value="${student.getBirthdate()}"/><br/>
			<input type="submit" value="Update Student">
		</form>
	</div>
	<tr>
		<th class="studentNie"> ${student.getNie()} </th>
		<th> ${student.getName()} </th>
		<th> ${student.getSurname()} </th>
		<th> ${student.getBirthdate()} </th>
		<th>
			<button onclick="showUpdateStudentForm('updateStudentForm${student.getNie()}')" value="Update Student">Update Student</button><br/>
		</th>
	</tr>
	</c:forEach>
</table>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(
	    $("#searchInput").on("keyup", function(){
	        var searchText = $(this).val().toLowerCase();

	        $(".studentNie").filter(function(){
	            $(this).toggle($(this).text().toLowerCase().indexOf(searchText) > -1)
	        })
	    })
	)


function showUpdateStudentForm(id){
		$("#"+id).show()
}

function hideUpdateStudentForm(id){
		$("#"+id).hide()
}
</script>
 
</body>
</html>