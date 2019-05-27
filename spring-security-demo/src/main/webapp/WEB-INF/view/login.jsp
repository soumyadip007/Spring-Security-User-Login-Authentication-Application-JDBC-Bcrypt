
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login</title>
   <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" >
   <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" type="text/css">
	
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<style>
		.failed {
			color: red;
		}
	</style>
</head>
<body>

<h2>Custom Login</h2>

<br>
<div class="container">
  <div class="row"> 
   <div class="col-sm">
   ${message}
<form:form   action="${pageContext.request.contextPath}/authenticateTheUser"  method="POST">
		
		
		<c:if test="${param.error != null}">
		
			<i class="failed">Sorry! You entered invalid username/password.</i>
			
		</c:if>
		
		<c:if test="${param.logout != null}">
		
			<i class="success">You have successfully logged out.</i>
		</c:if>
		<p>
			User name: <input type="text" name="username"  class="form-control"/>
		</p>

		<p>
			Password: <input type="password" name="password"  class="form-control"/>
		</p>
			<button type="submit" class="btn btn-success">Login</button>
</form:form>

</div>
</div>
</div>
</body>
</html>