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
		<h1 style="float: none; color: green;">Business Loan - Apply for Business Loan Online</h1>
		<h1 style="float: none; color: orange;">The following people are eligible to apply for a Business Growth Loan:</h1>
		<ul>
			<li> Self employed individuals, Proprietors, Private Ltd. Co. and Partnership Firms involved in the business of Manufacturing, Trading or Services.</li>
			<li> The business should have a minimum turnover of Rs. 40 lakhs</li>
			<li> Individuals who have been in the current business for a minimum of 3 years, with 5 years total business experience.</li>
			<li> Those whose business has been profit making for the previous 2 years</li>
			<li> The business should have a Minimal Annual Income (ITR) of Rs. 1.5 lakhs per annum</li>
			<li> The applicant should be at least 21 years at the time of applying for the loan, and should be no older than 65 years at the time of loan maturity</li>
		</ul>
		<FORM style="float: left;" NAME="HomeLoanPage"
			ACTION="HomeLoanServlet.do" METHOD="POST" onsubmit="return validation()"></FORM>
	</div>
	</section>
	<section>
	<div>
		<FORM style="float: left;" NAME="CarLoanPage"
			ACTION="LoanDetailsServlet.do" METHOD="POST" onsubmit="return validation()">
			<TABLE cellPadding='3' ALIGN='center'>
				<tr class="form-group">
					<td>FULL NAME:</td>
					<td><input type="text" name="fullname" class="form-control" id="fullname" Value='' SIZE="15"
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
					</select></td>
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
					<td><INPUT type="email" name='email' id="email" class="form-control" Value='' SIZE='15'
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
				if (isNaN(phone)) {
					document.getElementById('mobilenumber').innerHTML = " ** user must write digit only not character";
					return false;
				}
				
				if (phone.length!=10) {
					document.getElementById('mobilenumber').innerHTML = " ** mobile number must be 10 digit onlysssss";
					return false;
				}
				
				if (address == "") {
					document.getElementById('raddress').innerHTML = " ** please fill the address field";
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
						&& (email.charAt(email.length - 3) != '.')) {
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