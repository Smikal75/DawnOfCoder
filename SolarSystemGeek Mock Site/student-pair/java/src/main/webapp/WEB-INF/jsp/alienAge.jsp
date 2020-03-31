<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


 <c:import url="/WEB-INF/jsp/common/header.jsp" />
<title>Alien Weight Calculator</title>
</head>
<body>
<c:choose>
<c:when test= "${param.ageMultiplier == 1.63 }">
<p ><c:url var="venusImgSrc" value="/img/venus.jpg" />
		<img src="${venusImgSrc}" alt="Venus"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you are <c:out value="${param.earthAge}"/> years old on Earth, 
		you are <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthAge * param.ageMultiplier}"/> in Venus years! </p>
</c:when>
<c:when test= "${param.ageMultiplier == 4.15 }">
<p ><c:url var="mercuryImgSrc" value="/img/mercury.jpg" />
		<img src="${mercuryImgSrc}" alt="Mercury"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you are <c:out value="${param.earthAge}"/> years old. on Earth,
		you are <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthAge * param.ageMultiplier}"/> in Mercury years! </p>
</c:when>
<c:when test= "${param.ageMultiplier == 0.53 }">
<p ><c:url var="marsImgSrc" value="/img/mars.jpg" />
		<img src="${marsImgSrc}" alt="Mars"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you are <c:out value="${param.earthAge}"/> years old on Earth,
		you are <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthAge * param.ageMultiplier}"/> in Mars years! </p>
</c:when>
<c:when test= "${param.ageMultiplier == 0.084 }">
<p ><c:url var="jupiterImgSrc" value="/img/jupiter.jpg" />
		<img src="${jupiterImgSrc}" alt="Jupiter"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you are <c:out value="${param.earthAge}"/> years old on Earth,
		you are <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthAge * param.ageMultiplier}"/> in Jupiter years! </p>
</c:when>
<c:when test= "${param.ageMultiplier == 0.034 }">
<p ><c:url var="saturnImgSrc" value="/img/saturn.jpg" />
		<img src="${saturnImgSrc}" alt="Saturn"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you are <c:out value="${param.earthAge}"/> years old on Earth,
		you are <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthAge * param.ageMultiplier}"/> in Saturn years! </p>
</c:when>
<c:when test= "${param.ageMultiplier == 0.012 }">
<p ><c:url var="uranusImgSrc" value="/img/uranus.jpg" />
		<img src="${uranusImgSrc}" alt="Uranus"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you are <c:out value="${param.earthAge}"/> years old on Earth,
		you are <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthAge * param.ageMultiplier}"/> in Uranus years! </p>
</c:when>
<c:when test= "${param.ageMultiplier == 0.006 }">
<p ><c:url var="neptuneImgSrc" value="/img/neptune.jpg" />
		<img src="${neptuneImgSrc}" alt="Neptune"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you are <c:out value="${param.earthAge}"/> years old on Earth,
		you are <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthAge * param.ageMultiplier}"/> in Neptune years! </p>
</c:when>

<c:otherwise>
<p ><c:url var="earthImgSrc" value="/img/earth.jpg" />
		<img src="${earthImgSrc}" alt="Earth" style=" display:block;  margin-left: auto;
  margin-right: auto;"> </p><p style="color:white; text-align:center; font-size: 30px; display:block;">You are the same age on earth, duh. <c:out value="${param.earthAge}"/> but you are 
  <c:out value="${param.earthAge * param.ageMultiplier}"/> in dog years!</p>
</c:otherwise>

</c:choose>


</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />








<%-- 	<option value="0.37">Mercury</option>
			<option value="0.9">Venus</option>
			<option value="1.0">Earth</option>
			<option value="0.38">Mars</option>
			<option value="2.65">Jupiter</option>
			<option value="1.13">Saturn</option>
			<option value="1.09">Uranus</option>
			<option value="1.43">Neptune</option>--%>