<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
 <%String uname = (String)request.getSession(true).getAttribute("UName");
 	if (uname == null){
 		uname ="";
 	}
 %>
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
</head>
<body>
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
	</section>
	<section id ="options">
		<div class="container">
			<h1 style="float:none;"> Welcome to Royal City Internet Banking.</h1>
				<FORM style="float:left;" NAME="LoginPage" ACTION="<%=request.getContextPath()%>/LoginServlet.do" onsubmit="return validation()" METHOD ="POST">
					<TABLE cellPadding='3' ALIGN='center'>
						<TR  class="form-group">
						<TD>USERNAME:</TD>
						<TD>
						<INPUT TYPE='text' NAME='username' id="username" class="form-control" SIZE='15' autocomplete="off" placeholder="User Name"value = <%=uname %> >
						<span id="uname" class="text.danger font-weight-bold"></span>
						</TD>
						</TR>
						<TR  class="form-group">
						<TD>PASSWORD:</TD>
						<TD>
						<INPUT TYPE='password' NAME='password' id="password" class="form-control" SIZE='15' autocomplete="off" placeholder="Password">
						<span id="pass" class="text.danger font-weight-bold"></span>
						</TD>
						</TR>
					</TABLE>
						<div id="formButton">
						<button NAME='submitBTN' onClick="checkInputs()" class = "button_1"><span>Login</span></button>
						</div>
				</FORM>
		</div>
		<script>
			function validation() {
				var username = document.getElementById('username').value;
				var password = document.getElementById('password').value;
				
				
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
		<p>Royal City Banking Inc. copyright &copy; 2020</p>
	
	</footer>
</body>
<SCRIPT LANGUAGE="JavaScript"> 
		function checkInputs()
		{
		var Prompts = "";
		Username = window.document.LoginPage.UserName.value;
		Password = window.document.LoginPage.Password.value;
		if (Username == "" || Password == "") {
		if (Username == "")
		Prompts +="Please enter your username!\n";
		if (Password == "")
		Prompts +="Please enter your password!\n";
		if (Prompts != "")
		window.alert(Prompts);
		} else {
		document.LoginPage.submit();
		}
		}
		</SCRIPT>
</html>