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
<link rel="stylesheet" href="./css/stylesheet.css">
<!-- <script src="./script/jquery-3.3.1.min.js"></script>
<script src="./script/main.js"></script> -->
<script src="./js/statecity.js"></script>
<script language="JavaScript" type="text/javascript"></script>
</head>
<script type="text/javascript">
	function validation(){
		var fname = document.getElementById('fname').value;
		var mname = document.getElementById('mname').value;
		var lname = document.getElementById('lname').value;
		var uname = document.getElementById('uname').value;
		var email = document.getElementById('email').value;
		var password = document.getElementById('password').value;
		var addresss = document.getElementById('addresss').value;
		var occupation = document.getElementById('occupation').value;
		
		if(fname == ""){
			document.getElementById('firstname').innerHTML="**please fill the first name field";
			return false;
		}
		if((fname.length <=2) || (fname.length >=20)) {
			document.getElementById('firstname').innerHTML="**user length must be between 1 and 2";
			return false;
		}
		if(!isNaN(fname)) {
			document.getElementById('firstname').innerHTML="only charachters are allowed";
			return false;
		}
		if(mname == ""){
			document.getElementById('middlename').innerHTML="**please fill the middle name field";
			return false;
		}
		if((mname.length <=2) || (mname.length >=20)) {
			document.getElementById('middlename').innerHTML="**user length must be between 1 and 2";
			return false;
		}
		if(!isNaN(mname)) {
			document.getElementById('middlename').innerHTML="only charachters are allowed";
			return false;
		}
		if(lname == ""){
			document.getElementById('lastname').innerHTML="**please fill the last name field";
			return false;
		}
		if((lname.length <=2) || (lname.length >=20)) {
			document.getElementById('lastname').innerHTML="**user length must be between 1 and 3";
			return false;
		}
		if(!isNaN(lname)) {
			document.getElementById('lastname').innerHTML="only charachters are allowed";
			return false;
		}
		if(username == ""){
			document.getElementById('uname').innerHTML="**please fill the username field";
			return false;
		}
		if((username.length <=5) || (username.length >=15)) {
			document.getElementById('uname').innerHTML="**user length must be between 8 and 20";
			return false;
		}
		if(email == ""){
			document.getElementById('emailid').innerHTML="**please fill the emailid field";
			return false;
		}
		if(email.indexOf('@') <= 0 ) {
			document.getElementById('emailid').innerHTML="**@ invalid position";
			return false;
		}
		if((email.charAt(email.length-4)!='.') && (email.charAt(email.length-3)!='.')){
			document.getElementById('emailid').innerHTML="**. invalid position";
			return false;
		}
		if(password == ""){
			document.getElementById('pass').innerHTML="**please fill the password field";
			return false;
		}
		if((password.length <=8) || (password.length >=20)) {
			document.getElementById('pass').innerHTML="**user length must be between 8 and 20";
			return false;
		}
		if(address == ""){
			document.getElementById('addresses').innerHTML="**please fill the address field";
			return false;
		}
		if(occupation == ""){
			document.getElementById('occupation1').innerHTML="**please fill the occupation field";
			return false;
		}
		password = form.password.value;
        password1 = form.password1.value;
              
        // If Not same return False.    
        if (password != password1) {
            alert ("\nPassword did not match: Please try again...")
            return true;
        }
	}
	</script>

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
		<FORM style="float: left;" NAME="SignUpPage" ACTION="SignUpServlet.do" onclick="return validation()" 
			METHOD="POST">
			<TABLE cellPadding='3' ALIGN='center'>
				<tr>
					<td>PREFIX</td>
					<td><select name="salutation">
							<option value="Miss">Miss</option>
							<option value="Mr">Mr</option>
							<option value="Mrs">Mrs</option>
					</select></td>
				</tr>
				<tr>
					<td>FIRST NAME:</td>
					<td><input type="text" name="fname" id="fname" Value='' SIZE="15"
						placeholder="Enter First Name.." autocomplete="off">
						<span id="firstname" class="text.danger;font-weight-bold"></span></td>
				</tr>
				<tr>
					<td>MIDDLE NAME:</td>
					<td><input type="text" name="mname" id="mname" Value='' SIZE="15"
						placeholder="Enter Middle Name.." autocomplete="off"></td>
						<span id="middlename" class="text.danger;font-weight-bold"></span></td>
				</tr>
				<tr>
					<td>LAST NAME:</td>
					<td><input type="text" name="lname" id="lname" Value='' SIZE="15"
						placeholder="Enter Last Name.." autocomplete="off"></td>
						<span id="lastname" class="text.danger;font-weight-bold"></span></td>
				</tr>
				<tr>
					<td>USER NAME:</td>
					<td><input type="text" name="username" id="username"
						Value='' SIZE="15"
						placeholder="Enter User Name.." autocomplete="off"
						onClick="toggle_custom_property(this.form.text_field)"></td>
						<span id="uname" class="text.danger;font-weight-bold"></span></td>
				</tr>
				<tr>
					<td>PASSWORD:</td>
					<td><INPUT TYPE='password' NAME='password' Value='' SIZE="15"
						placeholder="enter Your Password.." autocomplete="off"></td>
					<span id="pass" class="text.danger;font-weight-bold"></span></td>
				</tr>
				<tr>
					<td>REENTER PASSWORD:</td>
					<td><INPUT TYPE='password' NAME='password1' Value='' SIZE="15"
						placeholder="Renter Your Password.." autocomplete="off"></td>
					<td><span id="message"></span></td>
				</tr>
				<tr>
					<td>MOBILE NUMBER:</td>
					<td><input type="tel" name="phone" Value='' SIZE="15"
						placeholder="Enter Mobile Number.."></td>
						<span id="mobilenumber" class="text.danger;font-weight-bold"></span></td>
				</tr>
				<tr>
					<td>DATE OF BIRTH:</td>
					<td><INPUT type="date" name='dob' Value='' SIZE='15'
						placeholder="Enter Your birthdate.."></td>
				</tr>
				<tr>
					<td>EMAIL ID:</td>
					<td><INPUT type="email" name='email' id="email" Value='' SIZE='15'
						placeholder="Enter Your email id.." autocomplete="off"></td>
						<span id="emailid" class="text.danger;font-weight-bold"></span></td>
				</tr>
				<tr>
					<td>GENDER</td>
					<td><select name="gender">
							<option value="MALE">MALE</option>
							<option value="FEMALE">FEMALE</option>
							<option value="UNSPECIFIED">UNSPECIFIED</option>
					</select></td>
				</tr>
				<tr>
					<td>RESIDENTIAL ADDRESS:</td>
					<td><INPUT TYPE='textarea' NAME='address' SIZE='15'
						placeholder="Please Type address.."></td>
						<span id="addresses" class="text.danger;font-weight-bold"></span></td>
				</tr>
				<tr>
					<td>STATE</td>
					<td><select name="states" id="states" onchange="setCities();">
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
				<tr>
					<td>CITY:</td>
					<td><select name="city" id="city">
							<option selected="" value="-1" disabled="">Select City</option>
							<option value="">please select a state</option>
					</select></td>
				</tr>
				<tr>
					<td>ZIP CODE:</td>
					<td><input type="text" name="zip" Value='' SIZE="15"
						placeholder="Enter postal/zip code.."></td>
				</tr>
				<tr>
					<td>MARITAL STATUS</td>
					<td><select name="maritalstatus">
							<option value="single">single</option>
							<option value="married">married</option>
							<option value="Widowed">Widowed</option>
							<option value="Separated">Separated</option>
							<option value="Divorced">Divorced</option>
					</select></td>
				</tr>
				<tr>
					<td>OCCUPATION</td>
					<td><select name="occupation">
							<option value="service">service</option>
							<option value="bussiness">bussiness</option>
							<option value="goverment servent">goverment servent</option>
							<option value="student">student</option>
							<option value="other">other</option>
					</select></td>
					<span id="occupation1" class="text.danger;font-weight-bold"></span></td>
				</tr>
			</TABLE>
			<div id="formButton">
				<button NAME='submitBTN' class="button_1">
					<span>SignUp</span>
				</button>
			</div>
		</FORM>
	</div>
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
</html>