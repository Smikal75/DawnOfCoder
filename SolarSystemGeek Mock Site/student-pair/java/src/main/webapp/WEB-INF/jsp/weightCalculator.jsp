<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



 <c:import url="/WEB-INF/jsp/common/header.jsp" />
<title>Alien Weight Calculator</title>
</head>
<body><c:url var="formAction" value="/alienWeight"/>

<form method="GET" action="${formAction}">
	<div class="formInputGroup">
		<label for="earthWeight" style= "color: white">Earth Weight:</label> 
		<input type="text" name="earthWeight" />
	</div>
	<div class="formInputGroup">
		<label for="planetaryGs">Planet:</label> 
		<select name="planetaryGs"	id="planetaryGs">
			<option value="0.37">Mercury</option>
			<option value="0.9">Venus</option>
			<option value="1.0">Earth</option>
			<option value="0.38">Mars</option>
			<option value="2.65">Jupiter</option>
			<option value="1.13">Saturn</option>
			<option value="1.09">Uranus</option>
			<option value="1.43">Neptune</option>
		</select>
	</div>
	
	<input class="formSubmitButton" type="submit" value="Weigh my SPACE WEIGHT" />
</form>

</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
