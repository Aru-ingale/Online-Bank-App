package com.bankapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.dao.Account;
import com.bankapp.dao.UserDAO;
import com.bankapp.models.UserDetails;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private PrintWriter output;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// a method called automatically to initialize the servlet

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// obtains a character-based output stream that enables
		// text data to be sent to the client
		output = response.getWriter();

		// specifies the MIME type of the response to the browser
		response.setContentType("text/html");
		// returns the value associated with a parameter sent to
		// the servlet as part of a post request
		String salutation = request.getParameter("salutation");
		String fname = request.getParameter("fname");
		String mname = request.getParameter("mname");
		String lname = request.getParameter("lname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String state = request.getParameter("states");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String maritalstatus = request.getParameter("maritalstatus");
		String occupation = request.getParameter("occupation");
		
	
		UserDetails user = pupulateUser(salutation, fname, mname, lname, phone, dob, email, gender,
				address, state, city, zip, maritalstatus, occupation, userName, password);

		UserDAO account = new UserDAO();
		if (account.signUp(user)) {
			request.getSession(true).setAttribute("USERNAME", userName);
			
			response.sendRedirect("Login.jsp");
			// showSuccess();
		} else
			output.println(
					"Account creation failed because of existing username or invalid username. Please try again!");
	}

	private UserDetails pupulateUser(String salutation, String fname, String mname, String lname, String phone, String dob,
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