<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


 <c:import url="/WEB-INF/jsp/common/header.jsp" />
<title>Alien Weight Calculator</title>
</head>
<body>
<c:choose>
<c:when test= "${param.planetaryGs == 0.9 }">
<p ><c:url var="venusImgSrc" value="/img/venus.jpg" />
		<img src="${venusImgSrc}" alt="Venus"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you weigh <c:out value="${param.earthWeight}"/>lbs. on Earth, 
		you weigh <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthWeight * param.planetaryGs}"/>lbs. on Venus! </p>
</c:when>
<c:when test= "${param.planetaryGs == 0.37 }">
<p ><c:url var="mercuryImgSrc" value="/img/mercury.jpg" />
		<img src="${mercuryImgSrc}" alt="Mercury"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you weigh <c:out value="${param.earthWeight}"/>lbs. on Earth,
		you weigh <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthWeight * param.planetaryGs}"/>lbs. on Mercury! </p>
</c:when>
<c:when test= "${param.planetaryGs == 0.38 }">
<p ><c:url var="marsImgSrc" value="/img/mars.jpg" />
		<img src="${marsImgSrc}" alt="Mars"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you weigh <c:out value="${param.earthWeight}"/>lbs. on Earth,
		you weigh <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthWeight * param.planetaryGs}"/>lbs. on Mars! </p>
</c:when>
<c:when test= "${param.planetaryGs == 2.65 }">
<p ><c:url var="jupiterImgSrc" value="/img/jupiter.jpg" />
		<img src="${jupiterImgSrc}" alt="Jupiter"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you weigh <c:out value="${param.earthWeight}"/>lbs. on Earth,
		you weigh <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthWeight * param.planetaryGs}"/>lbs. on Jupiter! </p>
</c:when>
<c:when test= "${param.planetaryGs == 1.13 }">
<p ><c:url var="saturnImgSrc" value="/img/saturn.jpg" />
		<img src="${saturnImgSrc}" alt="Saturn"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you weigh <c:out value="${param.earthWeight}"/>lbs. on Earth,
		you weigh <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthWeight * param.planetaryGs}"/>lbs. on Saturn! </p>
</c:when>
<c:when test= "${param.planetaryGs == 1.09 }">
<p ><c:url var="uranusImgSrc" value="/img/uranus.jpg" />
		<img src="${uranusImgSrc}" alt="Uranus"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you weigh <c:out value="${param.earthWeight}"/>lbs. on Earth,
		you weigh <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthWeight * param.planetaryGs}"/>lbs. on Uranus! </p>
</c:when>
<c:when test= "${param.planetaryGs == 1.43 }">
<p ><c:url var="neptuneImgSrc" value="/img/neptune.jpg" />
		<img src="${neptuneImgSrc}" alt="Neptune"style=" display:block;  margin-left: auto;
  margin-right: auto;"></p><p style="color:white; text-align:center; font-size: 30px; display:block;">If you weigh <c:out value="${param.earthWeight}"/>lbs. on Earth,
		you weigh <fmt:formatNumber type="number" maxFractionDigits="3" value="${param.earthWeight * param.planetaryGs}"/>lbs. on Neptune! </p>
</c:when>

<c:otherwise>
<p ><c:url var="earthImgSrc" value="/img/earth.jpg" />
		<img src="${earthImgSrc}" alt="Earth" style=" display:block;  margin-left: auto;
  margin-right: auto;"> </p><p style="color:white; text-align:center; font-size: 30px; display:block;">You weigh the same on earth, duh. <c:out value="${param.earthWeight}"/> lbs. ?! Put down the bagel.</p>
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