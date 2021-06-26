<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String uname = (String) request.getSession(true).getAttribute("UName");
if (uname == null) {
	uname = "";
}
%>
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
			<li><a href="Approval.jsp">Approval</a></li>
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
		<h1 style="float: none;">Welcome to Royal City Internet Banking.</h1>
		<FORM style="float: left;" NAME="ApprovalPage"
			ACTION="<%=request.getContextPath()%>/ApprovalServlet.do" METHOD="POST">
			<TABLE style="width: 80%"border: 20px solidblack ; border-color:white;>
				<tr>
					<td></td>
					<td>First Name</td>
					<td>Middle Name</td>
					<td>Last Name</td>
					<td>Mobile Number</td>
					<td>Date Of Birth</td>
					<td>Email Id</td>
					<td>Occupation</td>
					<td></td>
					<td></td>
				</tr>
			</TABLE>
		</FORM>
	</div>
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
	<p>Royal City Banking Inc. copyright &copy; 2020</p>

	</footer>
</body>
<SCRIPT LANGUAGE="JavaScript">
	function checkInputs() {
		var Prompts = "";
		Username = window.document.LoginPage.UserName.value;
		Password = window.document.LoginPage.Password.value;
		if (Username == "" || Password == "") {
			if (Username == "")
				Prompts += "Please enter your username!\n";
			if (Password == "")
				Prompts += "Please enter your password!\n";
			if (Prompts != "")
				window.alert(Prompts);
		} else {
			document.LoginPage.submit();
		}
	}
</SCRIPT>
</html>