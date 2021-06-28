<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Traditional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<meta name="author" content="Arundhati Ingale">
<title>Royal City Banking | Welcome.</title>
<!--<link rel="stylesheet"
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
		<h1 style="float: none;">Welcome to Royal City Internet Banking..</h1>
		<h1 style="float: none; color: orange;">Why Choose Royal City Bank
			Home Loans?</h1>
		<ul>
			<li> Attractive interest rates to make your Home Loans affordable
				and easier on your pocket.</li>
			<li> Customized repayment options to suit your needs.</li>
			<li> No hidden charges.</li>
			<li> Expert legal and technical counseling to help you make the
				right home buying decision.</li>
		</ul>
		<table style="width: 80%"border: 2pxsolidblack; border-color:white;>
			<tr>
				<th colspan="2" style="color: green; font-size: 23px;">Adjustable
					Rate Loans - Special Offer</th>
			</tr>
			<tr>
				<th colspan="2" style="color: orange; font-size: 20px;">Retail
					Prime Lending Rate: 16.05%</th>
			</tr>
			<tr align="left">
				<th font-size:20px;>Loan Slab</th>
					<td>Interest Rates (% p.a.)</td>
			</tr>
			<tr align="left">
				<th font-size:20px;>For Women* (upto 30 Lakhs)</th>
					<td>6.75 to 7.25</td>
			</tr>
			<tr align="left">
				<th font-size:20px;>For Others* (upto 30 Lakhs)</th>
					<td>6.80 to 7.30</td>
			</tr>
			<tr align="left">
				<th font-size:20px;>For Women* (30.01 Lakhs to 75 Lakhs)</th>
					<td>7.00 to 7.50</td>
			</tr>
			<tr align="left">
				<th font-size:20px;>For Others* (30.01 Lakhs to 75 Lakhs)</th>
					<td>7.05 to 7.55</td>
			</tr>

			<tr align="left">
				<th font-size:20px;>For Women* (75.01 Lakhs & Above)</th>
					<td>7.10 to 7.60</td>
			</tr>
			<tr align="left">
				<th font-size:20px;>For Others* (75.01 Lakhs & Above)</th>
					<td>7.15 to 7.65</td>
			</tr>

		</table>
		
	</div>
	
	</section>
	<section>
	<div>
		<FORM style="float: left;" NAME="HomeLoanPage"
			ACTION="HomeLoanServlet.do" METHOD="POST" onsubmit="return validation()">
			<TABLE cellPadding='3' ALIGN='center'>
				<tr class="form-group">
					<td>FULL NAME:</td>
					<td><input type="text" name="fullname" id="fullname" Value='' class="form-control" SIZE="15"
						placeholder="Enter First full name.." autocomplete="off">
						 <span id="name" class="text.danger font-weight-bold"></span>
						</td>
				</tr>
				<tr class="form-group">
					<td>OCCUPATION</td>
					<td><select name="occupation">
							<option value="service">service</option>
							<option value="bussiness">bussiness</option>
							<option value="goverment servent">goverment servent</option>
							<option value="student">student</option>
							<option value="other">other</option>
					</select>
					</td>
				</tr>
				<tr class="form-group">
					<td>DATE OF BIRTH:</td>
					<td><INPUT type="date" name='dob' id="dob" Value='' SIZE='15'
						placeholder="Enter Your birthdate.."></td>
				</tr>
				<tr class="form-group">
					<td>MOBILE NUMBER:</td>
					<td><input type="tel" name="phone" id="phone" class="form-control" Value='' SIZE="15"
						placeholder="Enter Mobile Number.." autocomplete="off">
						<span id="mobilenumber" class="text.danger font-weight-bold"></span>
						</td>
				</tr>
				<tr class="form-group">
					<td>RESIDENTIAL ADDRESS:</td>
					<td><INPUT TYPE='textarea' NAME='address' id="address" class="form-control" SIZE='15'
						placeholder="Please Type Address.." autocomplete="off">
						<span id="raddress" class="text.danger font-weight-bold"></span>
						</td>
				</tr>
				<tr class="form-group">
					<td>PROPERTY ADDRESS:</td>
					<td><INPUT TYPE='textarea' NAME='propertyaddress' id="propertyaddress" class="form-control" SIZE='15'
						placeholder="Please Type Property Address.." autocomplete="off">
						<span id="paddress" class="text.danger font-weight-bold"></span>
						</td>
				</tr>
				<tr class="form-group">
					<td>AADHAR NUMBER:</td>
					<td><input type="text" name="aadharnumber" id="aadharnumber" class="form-control" Value='' SIZE="15"
						placeholder="Enter Adhar Number.." autocomplete="off">
						<span id="number" class="text.danger font-weight-bold"></span>
						</td>
				</tr>
				<tr class="form-group">
					<td>INCOME:</td>
					<td><input type="radio" id="income1" name="income"
						value="10000"> <label for="income1">5000 - 10000</label></td>
					<br>
					<td><input type="radio" id="income2" name="income"
						value="15000"> <label for="income2">10000 - 15000</label></td>
					<br>
                    <td><input type="radio" id="income3" name="income"
						value="20000"> <label for="income3">15000 - 20000</label></td>
					<br>
					<td><input type="radio" id="income4" name="income"
						value="25000"> <label for="income4">20000 - 25000</label></td>
					<br>
					<td><input type="radio" id="income5" name="income"
						value="30000"> <label for="income5">25000+</label></td>
				</tr>
				<tr class="form-group">
					<td>LOAN AMMOUNT:</td>
					<td><input type="text" name="loanammount" id="loanammount" class="form-control" Value='' SIZE="15"
						placeholder="Enter Loan Ammount.." autocomplete="off">
						<span id="loan" class="text.danger font-weight-bold"></span>
						</td>
				</tr>
				<tr class="form-group">
					<td>EMAIL ID:</td>
					<td><INPUT type="text" name='email' id="email" class="form-control" Value='' SIZE='15'
						placeholder="Enter Your email id.." autocomplete="off">
						<span id="emailid" class="text.danger font-weight-bold"></span>
						</td>
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
				var fullname = document.getElementById('fullname').value;
				var phone = document.getElementById('phone').value;
				var address = document.getElementById('address').value;
				var propertyaddress = document.getElementById('propertyaddress').value;
				var aadharnumber = document.getElementById('aadharnumber').value;
				var loanammount = document.getElementById('loanammount').value;
				var email = document.getElementById('email').value;
				
				
				if (fullname == "") {
					document.getElementById('name').innerHTML = " ** please fill the fullname field";
					return false;
				}
				if (phone == "") {
					document.getElementById('mobilenumber').innerHTML = " ** please fill the mobile number field";
					return false;
				}
				
				if (address == "") {
					document.getElementById('raddress').innerHTML = " ** please fill the address field";
					return false;
				}
				
				if (propertyaddress == "") {
					document.getElementById('paddress').innerHTML = " ** please fill the property address field";
					return false;
				}

				if (aadharnumber == "") {
					document.getElementById('number').innerHTML = " ** please fill the adhar number field";
					return false;
				}
				
				if (loanammount == "") {
					document.getElementById('loan').innerHTML = " ** please fill the adhar number field";
					return false;
				}

				if (email == "") {
					document.getElementById('emailid').innerHTML = " ** please fill the email id field";
					return false;
				}

				if ((email.charAt(email.length - 4) != '.')
						|| (email.charAt(email.length - 3) != '.')) {
					document.getElementById('emailid').innerHTML = " ** @ invalid position";
					return false;
				}

				if (email.indexOf('@') <= 0) {
					document.getElementById('emailid').innerHTML = " ** @ invalid position";
					return false;
				}
				
			}
		</script>
	</section>
	<section id="boxes">
	<div class="container">
		<div class="box">
			<a href="HomeLoan.jsp"> <img src="./img/HomeLoan.jpg" width="100" height="100"  ></a>
			<h3>Home Loan</h3>
			<p>Make your dream come true. Apply for Home Loan Today.</p>
		</div>
		<div class="box">
			<a href="CarLoan.jsp"> <img src="./img/CarLoan.jpg" width="100" height="100"  ></a>
			<h3>Car Loan</h3>
			<p>Make your dream come true. Apply for Car Loan Today.</p>
		</div>
		<div class="box">
			<a href="BussinessLoan.jsp"> <img src="./img/BusinessLoan.jpg" width="100" height="100"  ></a>
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