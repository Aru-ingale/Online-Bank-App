package com.bankapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.dao.Account;
import com.bankapp.models.Users;

/**
 * Servlet implementation class SignUpServlet
 */
public class LoanServlet extends HttpServlet {
	private PrintWriter output;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoanServlet() {
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
		String fullname = request.getParameter("fullname");
		String occupation = request.getParameter("occupation");
		String dob = request.getParameter("dob");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String propertyaddress = request.getParameter("propertyaddress");
		String aadharnumber = request.getParameter("aadharnumber");
		String income = request.getParameter("income");
		String loanammount = request.getParameter("loanammount");
		String email = request.getParameter("email");
		
		
		
		//User user = new User(fullname, occupation, dob, phone, address, propertyaddress, aadharnumber, income, loanammount, email);

//		DB.insert();
		//Account account = new Account();
		/*if (account.signUp(user)) {
			request.getSession(true).setAttribute("USERNAME", userName);
			
			response.sendRedirect("Login.jsp");
			// showSuccess();
		} else
			output.println(
					"Account creation failed because of existing username or invalid username. Please try again!");
	}*/
	}
	// this "cleanup" method is called when a servlet is terminated by the server
	public void destroy() {
		output.close();
	}

}