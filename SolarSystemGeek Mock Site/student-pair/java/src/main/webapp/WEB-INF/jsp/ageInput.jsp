<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



 <c:import url="/WEB-INF/jsp/common/header.jsp" />
<title>Alien Weight Calculator</title>
</head>
<body><c:url var="formAction" value="/alienAge"/>

<form method="GET" action="${formAction}">
	<div class="formInputGroup">
		<label for="alienAge" style= "color: white">Earth Age:</label> 
		<input type="text" name="earthAge" />
	</div>
	<div class="formInputGroup">
		<label for="ageMultiplier">Planet:</label> 
		<select name="ageMultiplier">
			<option value="4.15">Mercury</option>
			<option value="1.63">Venus</option>
			<option value="7.0">Earth</option>
			<option value="0.53">Mars</option>
			<option value="0.084">Jupiter</option>
			<option value="0.034">Saturn</option>
			<option value="0.012">Uranus</option>
			<option value="0.006">Neptune</option>
		</select>
	</div>
	
	<input class="formSubmitButton" type="submit" value="What's My Alien Age?" />
</form>

</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
