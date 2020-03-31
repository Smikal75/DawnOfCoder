<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
<section id="main-content">

<p style="text-align:center; font-size:26px; font-weight:bold">
Solar System Geek Forum
</p>

<p style="text-align:center">
<c:url value="/postToForum" var="postToForum"/>
<a href="postToForum">Post a Message</a>
</p>
<div class = "posts">

<c:forEach items="${posts}" var="post">
<table class="post" style = "width:100%">
<tr >
<td style="color:black; font-size: 20px; font-weight: bold">
 <c:out value="${post.subject}"/>
 </td>
</tr>
<tr>
<td style="color:black"class="post">

 <c:out value="by ${post.username} on ${post.datePosted}"/>
 </td>  
</tr>
<tr>
<td class="p.message" style="color:black">
 <c:out value="${post.message}"/>
 </td>
</tr>
</table>
</c:forEach>

</div>
</section>

</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />