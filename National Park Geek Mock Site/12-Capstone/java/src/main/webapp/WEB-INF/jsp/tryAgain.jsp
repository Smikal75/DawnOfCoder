<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<c:url value="/css/npgeekstyling.css" var="cssHref" />
<link rel="stylesheet" type="text/css" href="${cssHref}">
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>NATIONAL PARK GEEK!</title>
</head>
<body class="background">
<div class = "form">
	<c:url var="postSurvey" value="/postSurvey" />

		<h2>A Response Already Exists for This Email Address. Please Try again.</h2>
	
	</div>
</body>
</html>