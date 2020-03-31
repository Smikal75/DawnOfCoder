<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
<section id="main-content">

<p style="text-align:center; font-size:26px; font-weight:bold">
Solar System GeekSTORE!
</p>



<div style= "display: flex; ">
<div style= "display: block; height: 300px; width: auto;"> 

<c:url value= "/img/${product.imageName}" var="itemImage"/>
<a href="detail"><img src = "${itemImage}"/></a>

</div>
<div style= "display: block; word-wrap: normal; height: auto; width: auto; padding-left:30px">
<h2><c:out value="${product.name }"/></h2>
<h2 style="color:blue"><c:out value="${product.price}"/></h2>
<p><c:out value="${product.description}"/></p>
<c:url value="/productDetail" var ="addToCartUrl"/>
<form action= "${addToCartUrl}" method="POST" style="padding-left:30px">
Enter quantity: 
<input type="hidden" name="productId" value="${param.productId}">
<input type="number" name="quantity">
<input type="submit" value="Add to Cart">
</form>

</div>
</div>
</section>

</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />