package com.bankapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.dao.AccountDetails;
import com.bankapp.dao.TransactionsDAO;
import com.bankapp.models.Account;
import com.bankapp.models.Transaction;

public class AdminApprovalAccount extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1003427051188486902L;
	private TransactionsDAO trandDAO;
	private AccountDetails accDAO;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		// set session scoped attribute
	        HttpSession session = request.getSession();
		trandDAO = new TransactionsDAO();
		accDAO = new AccountDetails();
		 String userId = request.getParameter("userId");
		 String accountType = request.getParameter("accountType");
	  
		boolean success = accDAO.approveAccount(userId,accountType);
		String accountMessage = success ? "Account Approved" : "Account Rejected";
		session.setAttribute("accountMessage", accountMessage);
		List<Account> accounts = accDAO.getAllAccountsForApproval();
		
		session.setAttribute("accounts", accounts);
		response.sendRedirect("Admin.jsp");
	}

}

