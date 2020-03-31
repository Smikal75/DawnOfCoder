<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />
<title>Alien Travel Calculator</title>
</head>
<body>
	<c:set var="TravelingBy" value="Grey Sofa" />
	<c:choose>
		<c:when test="${param.modeOfTravel == 1350 }">
			<c:set var="TravellingBy" value="Concorde Supersonic Jet" />
		</c:when>
		<c:when test="${param.modeOfTravel == 570}">
			<c:set var="TravellingBy" value="Boeing 747 Max" />
		</c:when>
		<c:when test="${param.modeOfTravel == 200 }">
			<c:set var="TravellingBy" value="Bullet Train" />
		</c:when>
		<c:when test="${param.modeOfTravel == 100 }">
			<c:set var="TravellingBy" value="Ford Taurus" />
		</c:when>

		<c:otherwise>
			<c:set var="TravellingBy" value="foot" />
		</c:otherwise>


	</c:choose>
	<c:choose>
		<c:when test="${param.distanceFromEarth == 25724767 }">
			<p>
				<c:url var="venusImgSrc" value="/img/venus.jpg" />
				<img src="${venusImgSrc}" alt="Venus"
					style="display: block; margin-left: auto; margin-right: auto;">
			</p>
			<p
				style="color: white; text-align: center; font-size: 30px; display: block;">
				If you leave by
				<c:out value="${TravellingBy}" />
				when you are
				<c:out value="${param.startingAge}" />
				years old, you will be
				<fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 + param.startingAge}" />
				years old when you arrive on Venus in <fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 }"/> years!
			</p>
		</c:when>
		<c:when test="${param.distanceFromEarth == 56974146 }">
			<p>
				<c:url var="mercuryImgSrc" value="/img/mercury.jpg" />
				<img src="${mercuryImgSrc}" alt="Mercury"
					style="display: block; margin-left: auto; margin-right: auto;">
			</p>
		<p
				style="color: white; text-align: center; font-size: 30px; display: block;">
				If you leave by
				<c:out value="${TravellingBy}" />
				when you are
				<c:out value="${param.startingAge}" />
				years old, you will be
				<fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 + param.startingAge}" />
				years old when you arrive on Mercury in <fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 }"/> years!
			</p>
		</c:when>
		<c:when test="${param.distanceFromEarth == 48678219 }">
			<p>
				<c:url var="marsImgSrc" value="/img/mars.jpg" />
				<img src="${marsImgSrc}" alt="Mars"
					style="display: block; margin-left: auto; margin-right: auto;">
			</p>
			<p
				style="color: white; text-align: center; font-size: 30px; display: block;">
				If you leave by
				<c:out value="${TravellingBy}" />
				when you are
				<c:out value="${param.startingAge}" />
				years old, you will be
				<fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 + param.startingAge}" />
				years old when you arrive on Mars in <fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 }"/> years!
			</p>
		</c:when>
		<c:when test="${param.distanceFromEarth == 390674710 }">
			<p>
				<c:url var="jupiterImgSrc" value="/img/jupiter.jpg" />
				<img src="${jupiterImgSrc}" alt="Jupiter"
					style="display: block; margin-left: auto; margin-right: auto;">
			</p>
		<p
				style="color: white; text-align: center; font-size: 30px; display: block;">
				If you leave by
				<c:out value="${TravellingBy}" />
				when you are
				<c:out value="${param.startingAge}" />
				years old, you will be
				<fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 + param.startingAge}" />
				years old when you arrive on Jupiter in <fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 }"/> years!
			</p>
		</c:when>
		<c:when test="${param.distanceFromEarth == 792248270 }">
			<p>
				<c:url var="saturnImgSrc" value="/img/saturn.jpg" />
				<img src="${saturnImgSrc}" alt="Saturn"
					style="display: block; margin-left: auto; margin-right: auto;">
			</p>
		<p
				style="color: white; text-align: center; font-size: 30px; display: block;">
				If you leave by
				<c:out value="${TravellingBy}" />
				when you are
				<c:out value="${param.startingAge}" />
				years old, you will be
				<fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 + param.startingAge}" />
				years old when you arrive on Saturn in <fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 }"/> years!
			</p>
		</c:when>
		<c:when test="${param.distanceFromEarth == 1692662530 }">
			<p>
				<c:url var="uranusImgSrc" value="/img/uranus.jpg" />
				<img src="${uranusImgSrc}" alt="Uranus"
					style="display: block; margin-left: auto; margin-right: auto;">
			</p>
			<p
				style="color: white; text-align: center; font-size: 30px; display: block;">
				If you leave by
				<c:out value="${TravellingBy}" />
				when you are
				<c:out value="${param.startingAge}" />
				years old, you will be
				<fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 + param.startingAge}" />
				years old when you arrive on Uranus in <fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 }"/> years!
			</p>
		</c:when>
		<c:when test="${param.distanceFromEarth == 2703959960}">
			<p>
				<c:url var="neptuneImgSrc" value="/img/neptune.jpg" />
				<img src="${neptuneImgSrc}" alt="Neptune"
					style="display: block; margin-left: auto; margin-right: auto;">
			</p>
			<p
				style="color: white; text-align: center; font-size: 30px; display: block;">
				If you leave by
				<c:out value="${TravellingBy}" />
				when you are
				<c:out value="${param.startingAge}" />
				years old, you will be
				<fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 + param.startingAge}" />
				years old when you arrive on Neptune in <fmt:formatNumber type="number" maxFractionDigits="2"
					value="${param.distanceFromEarth/ param.modeOfTravel/8760 }"/> years!
			</p>
		</c:when>

		<c:otherwise>
			<p>
				<c:url var="earthImgSrc" value="/img/earth.jpg" />
				<img src="${earthImgSrc}" alt="Earth"
					style="display: block; margin-left: auto; margin-right: auto;">
			</p>
			<p
				style="color: white; text-align: center; font-size: 30px; display: block;">
				If you are interested in buying a Grey Sofa, Earth is a great destination!
			</p>
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