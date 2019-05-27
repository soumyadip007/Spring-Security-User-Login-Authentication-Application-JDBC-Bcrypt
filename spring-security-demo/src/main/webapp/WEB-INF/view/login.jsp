<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" type="text/css">
	
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

<style>
		.failed {
			color: red;
		}
	</style>
</head>
<body>

<h2>Custom Login</h2>

<form:form   class="form-control" action="${pageContext.request.contextPath}/authenticateUser"  method="post">
		
		
		<c:if test="${param.error != null}">
		
			<i class="failed">Sorry! You entered invalid username/password.</i>
			
		</c:if>
		<p>
			User name: <input type="text" name="username"  class="form-control"/>
		</p>

		<p>
			Password: <input type="password" name="password"  class="form-control"/>
		</p>
		
		<input type="submit" value="Login" />
 
</form:form>

</body>
</html>