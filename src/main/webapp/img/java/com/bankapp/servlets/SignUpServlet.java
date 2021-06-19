package com.bankapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.models.Account;
import com.bankapp.models.User;

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
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String state = request.getParameter("states");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String maritalstatus = request.getParameter("maritalstatus");
		String occupation = request.getParameter("occupation");
		User user = new User(salutation, fname, mname, lname, userName, phone, dob, email, gender, password,
				address, state, city, zip, maritalstatus, occupation);

//		DB.insert();
		Account account = new Account();
		if (account.signUp(user)) {
			request.getSession(true).setAttribute("USERNAME", userName);
			response.sendRedirect("Login.jsp");
			// showSuccess();
		} else
			output.println(
					"Account creation failed because of existing username or invalid username. Please try again!");
	}

	// this "cleanup" method is called when a servlet is terminated by the server
	public void destroy() {
		output.close();
	}

}