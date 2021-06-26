<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<meta name="author" content="Arundhati Ingale">
<title>Royal City Banking | Welcome.</title>
<link rel="stylesheet" href="./css/stylesheet.css">
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
			<li class="current"><a href="index.jsp">Home</a></li>
			<li><a href="ViewBalance.jsp">View Balance</a></li>
			<li><a href="Deposit.jsp">Deposit</a></li>
			<li><a href="Withdraw.jsp">Withdraw</a></li>
			<li><a href="Transfer.jsp">Transfer</a></li>
			<li><a href="OpenAccount.jsp">Open Account</a></li>
		</ul>
		<div>
			<h3>
				Welcome <i><label><%=session.getAttribute("fname")%> <%=session.getAttribute("mname")%>
						<%=session.getAttribute("lname")%></label></i>
			</h3>
		</div>
		</nav>

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
		<h1>Welcome to Royal City Internet Banking. Please choose an
			option to proceed.</h1>
		<%
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
			userName = cookie.getValue();
			}
		}
		if (userName == null)
			response.sendRedirect("index.jsp");
		%>
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
		if (session.getAttribute("fname") == null & session.getAttribute("mname") == null
				&& session.getAttribute("lname") == null) {
			response.sendRedirect("Login.jsp");
		}
		%>


	</div>
	</section>


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
<script language="javascript">
	var signup = document.getElementById("SignUp");
	signup.addEventListener("click", function() {
		document.forms[0].action = "SignUp.jsp";
		document.forms[0].submit(); //submit the form or save it etc
	}, false);
	var login = document.getElementById("Login");
	login.addEventListener("click", function() {
		document.forms[0].action = "Login.jsp";
		document.forms[0].submit();
	}, false);
</script>
</html>