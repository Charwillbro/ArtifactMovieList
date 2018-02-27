<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Movie Form</h2>
	<mvc:form modelAttribute="movie" action="result.mvc">
		<table>
			<tr>
				<td><mvc:label path="movieTitle">Movie Title</mvc:label></td>
				<td><mvc:input path="movieTitle" /></td>
			</tr>
			<tr>
				<td><mvc:label path="director">Director</mvc:label></td>
				<td><mvc:input path="director" /></td>
			</tr>
			<tr>
				<td><mvc:label path="runtime">Movie Runtime</mvc:label></td>
				<td><mvc:input path="runtime" /></td>
			</tr>

			<tr>
				<td><mvc:label path="rating">Movie Rating</mvc:label></td>
				<td><mvc:select path="rating" items="${rating}" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</mvc:form>
	<a href="viewAll.mvc">View all Movies</a>
</body>
</html>