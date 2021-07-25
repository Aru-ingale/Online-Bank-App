<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="com.bankapp.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<meta name="author" content="Arundhati Inagle">
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
<link rel = "stylesheet" href ="./css/stylesheet.css">
</head>
<body>
<div id="logout">
		<button id='LogoutButton' style="float: right; margin-top: 70px;"
			class="button_1">
			<span>Logout</span>
		</button>
	</div>
	<header>
		<div class="container">
			<div id ="branding">
				<h1><span class="highlight">Royal City</span> Banking Inc.</h1>
			</div>
			<nav>
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="ViewBalance.jsp">View Balance</a></li>
					<li><a href="Deposit.jsp">Deposit</a></li>
					<li class="current"><a href="Withdraw.jsp">Withdraw</a></li>
					<li><a href="Transfer.jsp">Transfer</a></li>
					<li><a href="OpenAccount.jsp">Open Account</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<section id ="showcase">
		<div class="container">
		<h1>India's Most Affordable Banking.</h1>
		<p>Royal City banking is proud to all Indians and we are also proud to serve the nation.</p>
		</div>
	</section>
	<section id ="options">
		<div class="container">
			<h1 style="float:none;"> Enter Your Details to Withdraw.</h1>
			
				<form style="float:left;" name="WithdrawPage" action="WithdrawServlet.do" method = "POST" onsubmit="return validation()">
				
	<%	
	
	/*This is secure page. So, after logout the page should not go back. For that we have two ways.
	1. Tell browser to not store cache and revalidate each page after revisiting.
	2. Disable browser back button. 
	
	However, Disabling browser back button is bad practice. It would create bad user experience. So, we have to use way no 1.
	For that we have to tell browser to not set cache and store as well as revalidate each page.
	So, we have to set "Browser Header".
	*/
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1 protocol version
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0 protocol version
	response.setDateHeader("Expires", 0); // Proxies

	
	// This is secure page and you can perform transaction after Login only. So, if not Login then go to Login Page.
		if(session.getAttribute("userName") == null){
			response.sendRedirect("Login.jsp");
		}else{
	
			String savingAccountNo = (String) session.getAttribute("svAccountNumber");
			String svbalance = (String) session.getAttribute("svBalance");
			String currentAccountNo = (String) session.getAttribute("crAccountNumber");
			String crbalance = (String) session.getAttribute("crBalance");
			String balance = (String) session.getAttribute("balance");

			//Getting number of Savings Account of User
			String currentAccounts = (String) session.getAttribute("currentAccount");
	        	
				%>
				<TABLE class="table" cellPadding='3' ALIGN='center'>
					<tr>
						<td>Choose Your Account :</td>
						<td><select name="accountNumber" id="accnumber" required class="drpdwn" onchange="updateText('accnumber')">
								<option value="">--Select--</option>
								<option value="<%=savingAccountNo%>"><%=savingAccountNo%></option>
								<option value="<%=currentAccountNo%>"><%=currentAccountNo%></option>
						</select></td>
					</tr>
					<tr>
						<td>Account Type :</td>
						<td><input type="text" value="" id="accnumberText" name="accountType"/></td>
					</tr>
					
					<tr>
						<td>MOBILE NUMBER :</td>
						<td><INPUT TYPE='number' NAME='number' SIZE='15'
							placeholder="Enter Amount" onKeyUp="checkAmount()"></td>
					</tr>
					<tr>
						<td>AMOUNT:</td>
						<td><INPUT TYPE='number' NAME='amount' SIZE='15'
							placeholder="Enter Amount" onKeyUp="checkAmount()"></td>
					</tr>

					</TABLE>
					<div id="formButton">
						<button id='WithdrawButton' class = "button_1"><span>Withdraw</span></button>
					</div>
					<div id="show">
					<h3>
						Your Current Balance is :<b><%=balance%></b>
					</h3>
				</div>
					<% }
	%>
				</form>
				
		</div>
	</section>
	<section id ="boxes">
		<div class= "container">
			<div class="box">
				<a href="HomeLoan.jsp"> <img src="./img/HomeLoan.jpg" width="100" height="100"  ></a>
				<h3> Home Loan</h3>
				<p>Make your dream come true. Apply for Home Loan Today.</p>
			</div>
			<div class="box">
				<a href="CarLoan.jsp"> <img src="./img/CarLoan.jpg" width="100" height="100"  ></a>
				<h3> Car Loan</h3>
				<p>Make your dream come true. Apply for Car Loan Today.</p>
			</div>
			<div class="box">
				<a href="BussinessLoan.jsp"> <img src="./img/BusinessLoan.jpg" width="100" height="100"  ></a>
				<h3> Business Loan</h3>
				<p>Make your efforts worthy. Apply for Business Loans Today.</p>
			</div>
		</div>
	</section>
	<footer>
		<p>Royal City Banking Inc. copyright &copy; 2020</p>
	
	</footer>
</body>
<script language = "javascript">

function checkAmount(){
	var amount = window.document.WithdrawPage.Amount.value;
	
	var prompt ="";
	if(amount < 0){
		prompt +="Amount should be Positive!!";
		if (prompt != ""){
			window.document.WithdrawPage.reset();
			window.alert(prompt);
		}
	}
}
function validation(){
	var amount = window.document.WithdrawPage.Amount.value;
	
	if(amount === ""){
		window.alert("Please Enter Amount.");
		return false;
	}
}

var logout = document.getElementById("LogoutButton");
logout.addEventListener("click",function(){
	document.forms[0].action = "LogoutServlet.do";
	document.forms[0].submit();
},false);
</script>
</html>