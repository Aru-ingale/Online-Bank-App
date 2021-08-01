package com.bankapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.dao.TransactionsDAO;
import com.bankapp.models.Transaction;

public class AdminApproval extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1003427051188486902L;
	private TransactionsDAO trandDAO;
	
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
		
        String userId = request.getParameter("userId");
        int transactionId = Integer.parseInt(request.getParameter("transactionId"));
        Transaction tr = new Transaction();
        
        tr.setUserId(Integer.parseInt(userId));
        tr.setTransactionId(transactionId);
		boolean success = trandDAO.approveTransactions(tr);
	    String transactionMessage = success ? "Transaction Approved" : "Transaction Rejected";
		session.setAttribute("transactionMessage", transactionMessage);
		List<Transaction> transactions = trandDAO.getAllTransactions();
		
		session.setAttribute("transactions", transactions);
		response.sendRedirect("Admin.jsp");
	}

}
