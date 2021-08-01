<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="com.bankapp.models.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<meta name="author" content="Arundhati Ingale">
<title>Royal City Family Banking | Welcome.</title>
<link rel="stylesheet" href="./css/stylesheet.css">
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
			<div id="branding">
				<h1>
					<span class="highlight">Royal City</span> Bank.
				</h1>
			</div>
			<nav>
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li class="current"><a href="ViewBalance.jsp">View Balance</a></li>
					<li><a href="Deposit.jsp">Deposit</a></li>
					<li><a href="Withdraw.jsp">Withdraw</a></li>
					<li><a href="Transfer.jsp">Transfer</a></li>
					<li><a href="OpenAccount.jsp">Open Account</a></li>
					<li><a href="AdminServlet.do">Admin</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<section id="showcase">
		<div class="container">
			<h1>India's Most Affordable Banking.</h1>
			<p>Royal City Family banking is proud to all indians and we are
				also proud to serve the nation.</p>
		</div>
	</section>
	<section id="options">
		<div class="container">
			<h1 style="float: none;">Account Summary.</h1>
			<form style="float: left;" action="" method="POST">

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
					if (session.getAttribute("userName") == null) {
						response.sendRedirect("Login.jsp");
					} else {

						String savingAccountNo = (String) session.getAttribute("svAccountNumber");
						String svbalance = (String) session.getAttribute("svBalance");
						String currentAccountNo = (String) session.getAttribute("crAccountNumber");
						String crbalance = (String) session.getAttribute("crBalance");
					%>
				<TABLE cellPadding='3' id="ViewChecking">
					<tr>
						<td>Choose Your Account :</td>
						<td><select name="accountNumber" id="accnumber" required class="drpdwn" onchange="updateText('accnumber')">
								<option value="">--Select--</option>
								<% if(savingAccountNo != null) {%>
								<option value="<%=svbalance%>"><%=savingAccountNo%></option>
								<% } if(currentAccountNo != null) { %>
								<option value="<%=crbalance%>"><%=currentAccountNo%></option>
								<% } %>
						</select></td>
					</tr>
					<tr>
						<td>AMOUNT:</td>
						<td><INPUT TYPE='number' NAME='amount' id="accnumberText"
							 onKeyUp="checkAmount()" disabled="disabled"></td>
					</tr>
				</TABLE>
				<%
					}
				%>
				<!--<div id="logout">
					<button id='LogoutButton' style="margin-top: 20px;"
						class="button_1">
						<span>Logout</span>
					</button>
				</div> -->
			</form>

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
<script>
function updateText(type) { 
	 var id = type+'Text';
	 document.getElementById(id).value = document.getElementById(type).value;
	}
	
	var logout = document.getElementById("LogoutButton");
	logout.addEventListener("click", function() {
		document.forms[0].action = "LogoutServlet.do";
		document.forms[0].submit();
	}, false);
</script>
</html>