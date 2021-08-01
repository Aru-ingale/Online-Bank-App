
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bankapp.models.Transaction"%>
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
			<li class="current"><a href="AdminServlet.do">Admin</a>
		</ul>
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
				response.sendRedirect("index.jsp");
			}
			String transactionMessage = (String) session.getAttribute("transactionMessage");
			String accountMessage = (String) session.getAttribute("accountMessage");
			if (transactionMessage != null && !transactionMessage.equalsIgnoreCase("")) {
		%>
		<label><%=transactionMessage%></label>>
		<%
			}if (accountMessage != null && !accountMessage.equalsIgnoreCase("")) {
		%>
		<label><%=transactionMessage%></label>>
		<%
			} %>
		<h3>Approve Transaction</h3>
		<table border="1">
			<thead>
				<tr>
					<td>USER NAME</td>
					<td>TRANSACTIONTYPE</td>
					<td>FROMACCOUNT</td>
					<td>TOACCOUNT</td>
					<td>USERID</td>
					<td>STATUS</td>
					<td>AMOUNT</td>
					<td>MOBILE NUMBER</td>
				</tr>

			</thead>
			<c:forEach items="${transactions}" var="transaction">

				<tr>
					<td><c:out value="${transaction.fname}" /> <c:out
							value="${transaction.mname}" /> <c:out
							value="${transaction.lname}" /></td>

					<td><c:out value="${transaction.transactionType}" /></td>
					<td><c:out value="${transaction.fromAccount}" /></td>
					<td><c:out value="${transaction.toAccount}" /></td>
					<td><c:out value="${transaction.userId}" /></td>
					<td><c:out value="${transaction.status}" /></td>
					<td><c:out value="${transaction.amount}" /></td>
					<td><c:out value="${transaction.mobileNum}" /></td>
					<td>
						<form action="AdminApproval.do" method="POST">
							<div id="formButton">
								<button id='Approve' class="button_1">
									<span>Approve</span>
								</button>
								<input type="hidden" name="transactionId"
									value="${transaction.transactionId}" /> <input type="hidden"
									name="userId" value="${transaction.userId}" />
							</div>
						</form>
					</td>
				</tr>

			</c:forEach>
		</table>
		
		<h3>Approve Account</h3>
		<table border="1">
			<thead>
				<tr>
					<td>USER NAME</td>
					<td>ACCOUNT NUMBER</td>
					<td>ACCOUNT TYPE</td>					
					<td>BALANCE</td>
					<td>STATUS</td>
					<td>USERID</td>
				</tr>

			</thead>
			<c:forEach items="${accounts}" var="account">

				<tr>
					<td><c:out value="${account.accountHolderName}" /></td>
					<td><c:out value="${account.accountNumber}" /></td>
					<td><c:out value="${account.accountType}" /></td>
					<td><c:out value="${account.balance}" /></td>
					<td><c:out value="${account.status}" /></td>
					<td><c:out value="${account.userId}" /></td>
					<td>
						<form action="AdminApprovalAccount.do" method="POST">
							<div id="formButton">
								<button id='Approve' class="button_1">
									<span>Approve</span>
								</button>
								<input type="hidden" name="userId"
									value="${account.userId}" /> <input type="hidden"
									name="accountType" value="${account.accountType}" />
							</div>
						</form>
					</td>
				</tr>

			</c:forEach>
		</table>
		
		<h3>Approve Loan</h3>
		<table border="1">
			<thead>
				<tr>
					<td>USER NAME</td>
					<td>TRANSACTIONTYPE</td>
					<td>lOAN Type</td>
					<td>lOAN AMOUNT</td>
					<td>MOBILE NUMBER</td>
				</tr>

			</thead>
			<c:forEach items="${loanDetails}" var="loan">

				<tr>
					<td><c:out value="${loan.fname}" /> <c:out
							value="${loan.mname}" /> <c:out
							value="${loan.lname}" /></td>

					<td><c:out value="${loan.transactionType}" /></td>
					<td><c:out value="${loan.fromAccount}" /></td>
					<td><c:out value="${loan.toAccount}" /></td>
					<td><c:out value="${loan.userId}" /></td>
					<td>
						<form action="AdminLoanApproval.do" method="POST">
							<div id="formButton">
								<button id='Approve' class="button_1">
									<span>Approve</span>
								</button>
								<input type="hidden" name="transactionId"
									value="${transaction.transactionId}" /> <input type="hidden"
									name="userId" value="${transaction.userId}" />
							</div>
						</form>
					</td>
				</tr>

			</c:forEach>
		</table>
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
