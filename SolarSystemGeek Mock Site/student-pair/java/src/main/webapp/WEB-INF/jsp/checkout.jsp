<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<head>
<style>
</style>
</head>

<body>
	<section id="main-content">

		<p style="text-align: center; font-size: 26px; font-weight: bold">
			Checkout</p>

		<c:url var='checkoutUrl' value='/checkout' />
		<form action="${checkoutUrl}" method="POST">
			<div class="formGroup">
				<label for="fullName" style="color: black; font-size: 20px;">Full Name:</label> <input
					type="text" name="customerName" />
			</div>
			<div class="formGroup">
				<label for="address1" style="color: black; font-size: 20px;">Address 1:</label> <input
					type="text" name="address1" />
			</div>
			<div class="formGroup">
				<label for="address2" style="color: black; font-size: 20px;">Address 2:</label> <input
					type="text" name="address2" />
			</div>
			<div class="formGroup">
				<label for="city" style="color: black; font-size: 20px;">City:</label> <input
					type="text" name="city" />
			</div>
			<div class="formGroup">
				<label for="state" style="color: black; font-size: 20px;">State:</label>
			<select name = "state" id="state" style="font-size: 20px; ">
				<option value="AL">Alabama</option>
				<option value="AK">Alaska</option>
				<option value="AZ">Arizona</option>
				<option value="AR">Arkansas</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DE">Delaware</option>
				<option value="DC">District Of Columbia</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="IA">Iowa</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="ME">Maine</option>
				<option value="MD">Maryland</option>
				<option value="MA">Massachusetts</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MS">Mississippi</option>
				<option value="MO">Missouri</option>
				<option value="MT">Montana</option>
				<option value="NE">Nebraska</option>
				<option value="NV">Nevada</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NY">New York</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VT">Vermont</option>
				<option value="VA">Virginia</option>
				<option value="WA">Washington</option>
				<option value="WV">West Virginia</option>
				<option value="WI">Wisconsin</option>
				<option value="WY">Wyoming</option>
			</select>
			</div>
			<div class="formGroup">
				<label for="zipCode" inputmode="numeric" pattern="(?(00000(|-0000))|(\d{5}(|-\d{4})))$" style="color: black; font-size: 20px;">Zip Code:</label> <input
					type="text" name="zipCode" />
			</div>
			<div class="formGroup" style="padding-left: 400px">
				<input  type="submit" value="Submit!" />
			</div>
		</form>


	</section>

</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />