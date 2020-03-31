<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />


<section>
	<c:url var='postMessageUrl' value='/postToForum' />				
			<form action="${postMessageUrl}" method = "POST">
				<div class="formGroup">
					<label for="Username" style="color: white">Username</label>
					<input type="text" name="Username" />
				</div>
				<div class="formGroup">
					<label for="Subject" style="color: white">Subject</label>
					<input type="text" name="Subject" />
				</div>	
				<div class="formGroup">		
					<label for="Message" style="color: white">Message</label>
				<!-- 	<input type="textarea" name="Message" style="height:200px"/> -->
				<textarea rows="10" cols="100" name="Message" ></textarea>
				</div>	
				
				<div class="formGroup">
					<input type="submit" value="Submit!" />
				</div>	
				</form>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />