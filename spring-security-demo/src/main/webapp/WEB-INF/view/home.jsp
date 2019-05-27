<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
<p>
 User: <security:authentication property="principal.username" />
 <br><br>
 
 Role: <security:authentication property="principal.authorities" />
</p>

<p>
<a href="${pageContext.request.contextPath}/leaders">Leadership</a>
</p>

<form:form   action="${pageContext.request.contextPath}/logout"  method="POST">
		
			<button type="submit" class="btn btn-success">Logout</button>
</form:form>

</body>
</html>