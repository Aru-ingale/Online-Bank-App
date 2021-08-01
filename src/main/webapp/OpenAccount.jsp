<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%--@ page import ="com.bankapp.models.Account" --%>
<%@ page import ="com.bankapp.dao.Account" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link rel = "stylesheet" href ="./css/stylesheet.css">
<!-- <script src="./script/jquery-3.3.1.min.js"></script>
<script src="./script/main.js"></script> -->
<script type="text/javascript" src="./js/statecity.js"></script>
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
  				 -->
			</nav>
		</div>
	</header>
	<section id ="showcase">
		<div class="container">
		<h1>India's Most Affordable Banking.</h1>
		<p>Royal City banking is proud to all Indians and we are also proud to serve the nation.</p>
		</div>
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
	</section>
	<section id ="options">
	    <p>
	    <%
	     if(request.getAttribute("msg") != null){
	     %>
	    	 <%=request.getAttribute("msg") %>
	    <% 
	    }
	    %>
	   </p>
		<div class="container">
			<h1 style="float:none;">Thank You for Choosing Royal City Internet Banking. You can create Account below.</h1>
				<FORM style="float:left;" NAME="OpenAccountPage" onsubmit="return validation()" ACTION="OpenAccountServlet.do" METHOD ="POST">
		<TABLE cellPadding='3' ALIGN='center'>
			<TR class="form-group">
					<TD>Choose Account Type :</TD>
					<td>
					<select name ="accounttype" required class="drpdwn">
						<option value="">--Select--</option>
						<option value = "Current">Current</option>
						<option value = "Saving">Saving</option>
					</select>
					</td>
					</TR>
			<tr class="form-group">
				<td>PREFIX</td>
                <td><select name="salutation">
  				<option value="Miss">Miss</option>
  				<option value="Mr">Mr</option>
  				<option value="Mrs">Mrs</option>
                </select></td>
			</tr>
			<tr class="form-group">
				<td>FULL NAME:</td>
				<td><input type="text" name="fullname" id="fullname" class="form-control" Value='' SIZE="15" placeholder="Enter Full Name.." autocomplete="off">
				<span id="name" class="text.danger font-weight-bold"></span>
				</td>
			</tr>
			
			<tr class="form-group">
				<td>BALANCE:</td>
				<td><input type="text" name="balance" id="balance" class="form-control" Value='' SIZE="15" placeholder="Enter Balance.." autocomplete="off">
				<span id="balance1" class="text.danger font-weight-bold"></span>
				</td>
			</tr>
			<tr class="form-group">
				<td>Enter Token:</td>
				<td><input type="text" name="token" id="token" class="form-control" Value='' SIZE="15" placeholder="Enter Token Code" autocomplete="off">
				<span id="token1" class="text.danger font-weight-bold"></span>
				</td>
			</tr>
		</TABLE>
		<div id="formButton">
			<button NAME='submitBTN' class = "button_1"><span>OpenAccount</span></button>
		</div>
		</FORM>
		</div>
		 <script>
			function validation() {
				var fullname = document.getElementById('fullname').value;
				var balance = document.getElementById('balance').value;
				
				
				if (fullname == "") {
					document.getElementById('name').innerHTML = " ** please fill the mobile number field";
					return false;
				}
				
				if (balance == "") {
					document.getElementById('balance1').innerHTML = " ** please fill the address field";
					return false;
				}
				</script>
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