<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<head>
<style>
li #checkout {
         background-color: #1c87c9;
         border: none;
         border-radius: 20px;
         color: white;
         padding: 20px 34px;
         text-align: center;
         text-decoration: none;
         display: inline-block;
         font-size: 20px;
         margin: 4px 2px;
         cursor: pointer;
         font-weight: bold;
         }
         
a #checkout {
color: white;
}

a:visited #checkout{
color:white;
}

</style>
</head>

<body>
	<section id="main-content">

		<p style="text-align: center; font-size: 26px; font-weight: bold">
			Solar System GeekSTORE! Your Cart Contains:</p>


		<c:forEach items="${items}" var="product">
			<div style="display: flex;">
				<div style="display: block; height: 300px; width: auto;">
					<c:url value="/img/${product.key.imageName}" var="itemImage" />
					<img src="${itemImage}" />
				</div>
				<div
					style="display: block; word-wrap: normal; height: auto; width: auto; padding-left: 30px">
					<h2>
						<c:out value="${product.key.name}" />
					</h2>
					<h2 style="color: blue">
						Quantity:
						<c:out value="${product.value}" />
					</h2>
					<h2 style="color: blue">
						Price :
						<c:out value="${product.key.price}" />
					</h2>
					<%--<h2 style="color:blue">Total    :<c:out value="${product.key.price * product.value}"/></h2>
 --%>
				</div>
			</div>
		</c:forEach>
		<div style="display:flexbox; flex-align:column; text-align: right; padding-right: 10px;">
		<ul style="display:inline-block;">	
			<li id="checkout" style="display:inline-block;"><a id="checkout" href="<c:url value="/spaceStore"/>">Keep Shopping</a></li>
			<li id="checkout" style="display:inline-block;"><a id="checkout" href="<c:url value="/emptyCart"/>">Empty Cart</a></li>
			<li id="checkout" style="display:inline-block;"><a id="checkout" href=" <c:url value="/checkout"/>">Checkout: Your Total - ${total}</a></li>
		</ul>
		</div>
	</section>

</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />