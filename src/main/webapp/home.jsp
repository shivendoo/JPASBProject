<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H2>Add Student</H2> 
<form action="addstud">
<lable for="sid">Student Id</lable><input id="sid" type="text" name="sid"> <br>
<lable for="name">Studen Name</lable><input type="text" name="name"> <br>
<lable for="age">Student age</lable><input type="text" name="age"> <br>
<input type="submit" value="save">
</form>

<h2>Search Student</h2> 
<form action="findstud">
<lable for="sid">Student Id</lable><input id="sid" type="text" name="sid"> <br>
<input type="submit" value="Search">
</form>

<h2>Delete Student</h2> 
<form action="removestudent">
<lable for="sid">Student Id</lable><input id="sid" type="text" name="sid"> <br>
<input type="submit" value="Delete">
</form>


<h2>Search Student by Age</h2> 
<form action="getstudentbyage">
<lable for="age">Student Age</lable><input id="age" type="text" name="age"> <br>
<input type="submit" value="Search">
</form>

<h2>Search Student by Name</h2> 
<form action="getstudentbyname">
<lable for="name">Student Age</lable><input id="name" type="text" name="name"> <br>
<input type="submit" value="Search">
</form>

</body>
</html>