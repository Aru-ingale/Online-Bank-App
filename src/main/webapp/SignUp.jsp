<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%--@ page import ="com.bankapp.models.Account" --%>
<%@ page import="com.bankapp.dao.Account"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<meta name="author" content="Arundhati Ingale">
<title>Royal City Banking | Welcome.</title>
<!--  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">-->

<!-- jQuery library -->
  <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
 <script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/stylesheet.css">
<!-- <script src="./script/jquery-3.3.1.min.js"></script>
<script src="./script/main.js"></script> -->
<script type="text/javascript" src="./js/statecity.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<header>
	<div class="container">
		<div id="branding">
			<h1>
				<span class="highlight">Royal City</span> Banking Inc.
			</h1>
		</div>
		<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="ViewBalance.jsp">View Balance</a></li>
			<li><a href="Deposit.jsp">Deposit</a></li>
			<li><a href="Withdraw.jsp">Withdraw</a></li>
			<li><a href="Transfer.jsp">Transfer</a></li>
			<li><a href="OpenAccount.jsp">Open Account</a></li>
			<li><a href="AdminServlet.do">Admin</a></li>
		</ul>
		<!-- 
				<select> 
   					 <option value="" selected="selected">Select</option> 
    				 <option value="index.jsp">Home</option> 
    				 <option value="ViewBalance.jsp">View Balance</option> 
    				 <option value="Deposit.jsp">Deposit</option> 
    				 <option value="Transfer.jsp">Transfer</option> 
    				 <option value="OpenAccount.jsp">Open Account</option> 
  				</select> 	
  				 --> </nav>
	</div>
	</header>
	<section id="showcase">
	<div class="container">
		<h1>India's Most Affordable Banking.</h1>
		<p>Royal City banking is proud to all Indians and we are also
			proud to serve the nation.</p>
	</div>
	</section>
	<section id="options">
	<div class="container">
		<h1 style="float: none;">Thank You for Choosing Royal City
			Internet Banking. You can create Account below.</h1>
		<div>
			<form style="float: left;" name="SignUpPage"
				ACTION="SignUpServlet.do" METHOD="POST" onsubmit="return validation()">
				<table cellPadding='3' ALIGN='center'>
					<tr class="form-group">
						<td>PREFIX</td>
						<td><select name="salutation">
						        <option value="">Select </option>
								<option value="Miss">Miss</option>
								<option value="Mr">Mr</option>
								<option value="Mrs">Mrs</option>
						</select></td>
					</tr>
					<tr class="form-group">
						<td>FIRST NAME:</td>
						<td><input type="text" name="fname" id="fname"
							class="form-control" Value='' SIZE="15"
							placeholder="Enter First Name.." autocomplete="off"> <span
							id="firstname" class="text.danger font-weight-bold"></span></td>
					</tr>
					<tr class="form-group">
						<td>MIDDLE NAME:</td>
						<td><input type="text" name="mname" id="mname"
							class="form-control" Value='' SIZE="15"
							placeholder="Enter Middle Name.." autocomplete="off"> <span
							id="middlename" class="text.danger font-weight-bold"></span></td>
					</tr>
					<tr class="form-group">
						<td>LAST NAME:</td>
						<td><input type="text" name="lname" id="lname"
							class="form-control" Value='' SIZE="15"
							placeholder="Enter Last Name.." autocomplete="off"> <span
							id="lastname" class="text.danger font-weight-bold"></span></td>
					</tr>
					<tr class="form-group">
						<td>USER NAME:</td>
						<td><input type="text" name="username" id="username"
							class="form-control" Value='' SIZE="15"
							placeholder="Enter User Name.." autocomplete="off"> <span
							id="uname" class="text.danger font-weight-bold"></span></td>
					</tr>
					<tr class="form-group">
						<td>PASSWORD:</td>
						<td><INPUT TYPE='password' NAME='password' id="password"
							class="form-control" Value='' SIZE="15"
							placeholder="enter Your Password.." autocomplete="off"> <span
							id="pass" class="text.danger font-weight-bold"></span></td>

					</tr>
					<tr class="form-group">
						<td>REENTER PASSWORD:</td>
						<td><INPUT TYPE='password' NAME='password1' id="password1"
							class="form-control" Value='' SIZE="15"
							placeholder="Renter Your Password.." autocomplete="off">
							<span id="pass1" class="text.danger font-weight-bold"></span></td>

					</tr>
					<tr class="form-group">
						<td>MOBILE NUMBER:</td>
						<td><input type="tel" name="phone" id="phone"
							class="form-control" Value='' SIZE="15"
							placeholder="Enter Mobile Number.." autocomplete="off"> <span
							id="mobilenumber" class="text.danger font-weight-bold"></span></td>

					</tr>
					<tr class="form-group">
						<td>DATE OF BIRTH:</td>
						<td><INPUT type="date" name="dob" id="dob"
							class="form-control" Value='' SIZE="15"
							placeholder="Enter Your birthdate.." required /> <span
							id="birthdate" class="text.danger font-weight-bold"></span></td></td>
					</tr>
					<tr class="form-group">
						<td>EMAIL ID:</td>
						<td><INPUT type="text" name="email" id="email" Value=''
							class="form-control" SIZE="15"
							placeholder="Enter Your email id.." autocomplete="off"> <span
							id="emailid" class="text.danger font-weight-bold"></span></td>
					</tr>
					<tr class="form-group">
						<td>GENDER</td>
						<td><select name="gender" required />
						        <option value="">Select gender</option>
								<option value="MALE">MALE</option>
								<option value="FEMALE">FEMALE</option>
								<option value="UNSPECIFIED">UNSPECIFIED</option>
						</select></td>
					</tr>
					<tr class="form-group">
						<td>RESIDENTIAL ADDRESS:</td>
						<td><INPUT TYPE="text" NAME="address" id="address"
							class="form-control" SIZE="15"
							placeholder="Please Type address.." autocomplete="off">
							<span
							id="raddress" class="text.danger font-weight-bold"></span></td>
					</tr>
					<tr class="form-group">
						<td>STATE</td>
						<td><select name="states" id="states" class="form-control"
							onchange="setCities();" required />
							    <option value="">Select state</option>
								<option value="Andhra Pradesh">Andhra Pradesh</option>
								<option value="Bihar">Bihar</option>
								<option value="Chhattisgarh">Chhattisgarh</option>
								<option value="Goa">Goa</option>
								<option value="Gujarat">Gujarat</option>
								<option value="Haryana">Haryana</option>
								<option value="Himachal Pradesh">Himachal Pradesh</option>
								<option value="Jharkhand">Jharkhand</option>
								<option value="Karnataka">Karnataka</option>
								<option value="Kerala">Kerala</option>
								<option value="Madhya Pradesh">Madhya Pradesh</option>
								<option value="Maharashtra">Maharashtra</option>
								<option value="Manipur">Manipur</option>
								<option value="Meghalaya">Meghalaya</option>
								<option value="Mizoram">Mizoram</option>
								<option value="Nagaland">Nagaland</option>
								<option value="Odisha">Odisha</option>
								<option value="Punjab">Punjab</option>
								<option value="Rajasthan">Rajasthan</option>
								<option value="Sikkim">Sikkim</option>
								<option value="Tamil Nadu">Tamil Nadu</option>
								<option value="Telangana">Telangana</option>
								<option value="Tripura">Tripura</option>
								<option value="Uttar Pradesh">Uttar Pradesh</option>
								<option value="Uttrakhand">Uttarakhand</option>
								<option value="West Bengal">West Bengal</option>
								<option value="Assam">Assam</option>
						</select></td>
					</tr>
					<tr class="form-group">
						<td>CITY:</td>
						<td><select name="city" id="city" class="form-control" required />
						        <option value=""> Select </option>
								<option selected="" value="-1" disabled="">Select City</option>
								<option value="">please select a state</option>
						</select></td>
					</tr>
					<tr class="form-group">
						<td>ZIP CODE:</td>
						<td><input type="text" name="zip" id="zip"Value=''
							class="form-control" SIZE="15"
							placeholder="Enter postal/zip code.." autocomplete="off">
							<span
							id="zipcode" class="text.danger font-weight-bold"></span></td>
					</tr>
					<tr class="form-group">
						<td>MARITAL STATUS</td>
						<td><select name="maritalstatus" class="form-control" required />
						        <option value=""> Select </option>
								<option value="single">single</option>
								<option value="married">married</option>
								<option value="Widowed">Widowed</option>
								<option value="Separated">Separated</option>
								<option value="Divorced">Divorced</option>
						</select></td>
					</tr>
					<tr class="form-group">
						<td>OCCUPATION</td>
						<td><select name="occupation" class="form-control" required />
						        <option value=""> Select occupation</option>
								<option value="service">service</option>
								<option value="bussiness">bussiness</option>
								<option value="goverment servent">goverment servent</option>
								<option value="student">student</option>
								<option value="other">other</option>
						</select></td>
					</tr>
				</TABLE>
				<div id="formButton">
					<button NAME='submitBTN' class="button_1">
						<span>SignUp</span>
					</button>
				</div>
			</FORM>
		</div>
		<script>
			function validation() {
				var fname = document.getElementById('fname').value;
				var mname = document.getElementById('mname').value;
				var lname = document.getElementById('lname').value;
				var username = document.getElementById('username').value;
				var password = document.getElementById('password').value;
				var password1 = document.getElementById('password1').value;
				var phone = document.getElementById('phone').value;
				var email = document.getElementById('email').value;
				var address = document.getElementById('address').value;
				var zip = document.getElementById('zip').value;
				
				var userDateinput = document.getElementById("dob").value;  
				 console.log(userDateinput);
				 
			     // convert user input value into date object
				 var birthDate = new Date(userDateinput);
				  console.log(" birthDate"+ birthDate);
				 
				 // get difference from current date;
				 var difference=Date.now() - birthDate.getTime(); 
				 	 
				 var  ageDate = new Date(difference); 
				 var calculatedAge=   Math.abs(ageDate.getUTCFullYear() - 1970);
							    
				if(calculatedAge < 18){
					document.getElementById('birthdate').innerHTML = " **Age should be above 18 years";
					return false;
				}
				if (fname == "") {
					document.getElementById('firstname').innerHTML = " ** please fill the firstname field";
					return false;
				}
				if (mname == "") {
					document.getElementById('middlename').innerHTML = " ** please fill the middlename field";
					return false;
				}
				if (lname == "") {
					document.getElementById('lastname').innerHTML = " ** please fill the lastname field";
					return false;
				}
				if (username == "") {
					document.getElementById('uname').innerHTML = " ** please fill the username field";
					return false;
				}

				if ((username.length <= 2) || (username.length > 20)) {
					document.getElementById('uname').innerHTML = " ** user length must be between 2 and 20";
					return false;
				}

				if (!isNaN(username)) {
					document.getElementById('uname').innerHTML = " ** only charecters are allowed";
					return false;
				}
				if (password == "") {
					document.getElementById('pass').innerHTML = " ** please fill the password field";
					return false;
				}

				if ((password.length <= 5) || (password.length > 20)) {
					document.getElementById('pass').innerHTML = " ** password length must be between 5 and 20";
					return false;
				}

				if (password != password1) {
					document.getElementById('pass1').innerHTML = " ** password are not matching";
					return false;
				}

				if (password1 == "") {
					document.getElementById('pass1').innerHTML = " ** please fill the confirm password field";
					return false;
				}

				if (phone == "") {
					document.getElementById('mobilenumber').innerHTML = " ** please fill the mobile number field";
					return false;
				}
				
				if (isNaN(phone)) {
					document.getElementById('mobilenumber').innerHTML = " ** user must write digit only not character";
					return false;
				}
				
				if (phone.length!=10) {
					document.getElementById('mobilenumber').innerHTML = " ** mobile number must be 10 digit only";
					return false;
				}

				if (email == "") {
					document.getElementById('emailid').innerHTML = " ** please fill the email id field";
					return false;
				}

				if ((email.charAt(email.length - 4) != '.')
						&& (email.charAt(email.length - 3) != '.')) {
					document.getElementById('emailid').innerHTML = " ** @ invalid position";
					return false;
				}

				if (email.indexOf('@') <= 0) {
					document.getElementById('emailid').innerHTML = " ** @ invalid position";
					return false;
				}
				
				if (zip == "") {
					document.getElementById('zipcode').innerHTML = " ** please fill the zip code field";
					return false;
				}
				
				if (address == "") {
					document.getElementById('raddress').innerHTML = " ** please fill the address field";
					return false;
				}
			}
		</script>
	</section>
	<section id="boxes">
	<div class="container">
		<div class="box">
			<a href="HomeLoan.jsp"> <img src="./img/HomeLoan.jpg" width="100"
				height="100"></a>





			<h3>Home Loan</h3>
			<p>Make your dream come true. Apply for Home Loan Today.</p>
		</div>
		<div class="box">
			<a href="CarLoan.jsp"> <img src="./img/CarLoan.jpg" width="100"
				height="100"></a>
			<h3>Car Loan</h3>
			<p>Make your dream come true. Apply for Car Loan Today.</p>
		</div>
		<div class="box">
			<a href="BussinessLoan.jsp"> <img src="./img/BusinessLoan.jpg"
				width="100" height="100"></a>
			<h3>Business Loan</h3>
			<p>Make your efforts worthy. Apply for Business Loans Today.</p>
		</div>
	</div>
	</section>
	<footer>
	<p>Royal City Banking Inc. copyright &copy; 2021</p>

	</footer>
</body>
<script language="javascript">

	var logout = document.getElementById("LogoutButton");
	logout.addEventListener("click", function() {
		document.forms[0].action = "LogoutServlet.do";
		document.forms[0].submit();
	}, false);
	/*
	 function showBalance(){
	
	 var x = document.getElementById("show");
	 if(x.style.display === "none"){
	 x.style.display = "block";
	 }
	 else{
	 x.style.display = "none";
	 }
	 }
	 */
</script>
</html>