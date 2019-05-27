<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security Home</title>
   <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" >
   <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>" type="text/css">
	
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>

</head>
<body>

<h2>Welcome to Spring Security</h2>

Hello
<form:form   action="${pageContext.request.contextPath}/Logout"  method="POST">
		
			<button type="submit" class="btn btn-success">Logout</button>
</form:form>

</body>
</html>