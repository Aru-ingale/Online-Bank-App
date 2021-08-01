package com.bankapp.servlets;

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;

import com.bankapp.dao.UserDAO;
import com.bankapp.models.LoanDetails;
import com.bankapp.models.UserDetails;  
  
public class LoanServlet extends HttpServlet {  
	private PrintWriter output;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
output = response.getWriter();
          
String fullname=request.getParameter("fullname");  
String occupation=request.getParameter("occupation");  
String dob=request.getParameter("dob");  
String phone=request.getParameter("phone");  
String address=request.getParameter("address");
String propertyaddress=request.getParameter("propertyaddress");
String aadharnumber=request.getParameter("aadharnumber");
String income=request.getParameter("income");
String loanammount=request.getParameter("loanammount");
String email=request.getParameter("email");
          
try{  
	LoanDetails user = pupulateUser(fullname,occupation,dob,phone,address,propertyaddress,aadharnumber,income,loanammount,email);
  
	UserDAO account = new UserDAO();
	if (account.loanServlet(user)) {
		request.getSession(true).setAttribute("FULLNAME", fullname);
		
		response.sendRedirect("Login.jsp");
		// showSuccess();
	} else
		output.println("Account creation failed because of existing username or invalid username. Please try again!");
}

private LoanDetails pupulateUser(String salutation, String fname, String mname, String lname, String phone, String dob,
		String email, String gender, String address, String state, String city, String zip, String maritalstatus,
		String occupation, String userName, String password) {
	
	UserDetails user = new UserDetails();
	user.setSalutation(salutation);
	user.setFname(fname);
	user.setMname(mname);
	user.setLname(lname);
	user.setPhone(phone);
	user.setDob(dob);
	user.setEmail(email);
	user.setGender(gender);
	user.setAddress(address);
	user.setState(state);
	user.setCity(city);
	user.setZip(zip);
	user.setMaritalStatus(maritalstatus);
	user.setOccupation(occupation);
	user.setUserName(userName);
	user.setPassword(password);
	return user;
}

// this "cleanup" method is called when a servlet is terminated by the server
public void destroy() {
	output.close();
}

}