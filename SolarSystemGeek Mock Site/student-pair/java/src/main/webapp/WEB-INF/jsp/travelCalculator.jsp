<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



 <c:import url="/WEB-INF/jsp/common/header.jsp" />
<title>Alien Travel Calculator</title>
</head>
<body><c:url var="formAction" value="/alienTravel"/>

<form method="GET" action="${formAction}">
	<div class="formInputGroup">
		<label for="startingAge" style= "color: white">Starting Age?</label>
		<input type="text" name="startingAge" />
	</div>
	<div class="formInputGroup">
		<label for="modeOfTravel" style= "color: white">Mode of Travel:</label> 
		<select name="modeOfTravel"	id="modeOfTravel">
			<option value="3">Walking</option>
			<option value="100">Car</option>
			<option value="200">Bullet Train</option>
			<option value="570">Boeing 747</option>
			<option value="1350">Concorde</option>
			
		</select>
	</div>
		<div class="formInputGroup">
		<label for="distanceFromEarth"style= "color: white">Destination Planet:</label> 
		<select name="distanceFromEarth"	id="distanceFromEarth">
			<option value="56974146">Mercury</option>
			<option value="25724767">Venus</option>
			<option value="0">Earth</option>
			<option value="48678219">Mars</option>
			<option value="390674710">Jupiter</option>
			<option value="792248270">Saturn</option>
			<option value="1692662530">Uranus</option>
			<option value="2703959960">Neptune</option>
		</select>
	</div>
	<input class="formSubmitButton" type="submit" value="Travel to SPACE!" />
</form>

</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
