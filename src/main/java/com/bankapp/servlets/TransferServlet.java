package com.bankapp.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.dao.AccountDetails;
import com.bankapp.dao.CurrentAccount;
import com.bankapp.dao.SavingsAccount;
import com.bankapp.dao.TransactionsDAO;
import com.bankapp.models.Transaction;

/**
 * Servlet implementation class TrransferServlet
 */
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CurrentAccount ScrAcc, DcrAcc;
	private SavingsAccount SsvAcc, DsvAcc;
	private TransactionsDAO trandDAO;
	/*
	 * private AccountDetails SckAcc, DckAcc; private SavingsAccount SsvAcc, DsvAcc;
	 * private TransactionsDAO tr;
	 */

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransferServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fromAccountNumber = request.getParameter("fromAccountNumber");
		String toAccountNumber = request.getParameter("toAccountNumber");
		String amt = request.getParameter("amount");
		double amount = Double.parseDouble(amt);
		String accountType = request.getParameter("accountType");
		String mobile = request.getParameter("number");

		// Getting UserName
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");

		if (fromAccountNumber != "" && amt != "" && toAccountNumber != "") {
			/*int SAcc_no = Integer.parseInt(sourceSelection);
			int DAcc_no = Integer.parseInt(destinationSelection);

			SckAcc = new AccountDetails(SAcc_no);
			SsvAcc = new SavingsAccount(SAcc_no);

			DckAcc = new AccountDetails(DAcc_no);
			DsvAcc = new SavingsAccount(DAcc_no);*/
			Transaction trans = new Transaction();
			//trans.setTransactionType("deposit");
			trans.setFromAccount(fromAccountNumber);
			trans.setToAccount(toAccountNumber);
			trans.setUserName(userName);
			trans.setAmount(amount);
			trans.setMobileNum(mobile);
			trandDAO = new TransactionsDAO();
            ScrAcc = new CurrentAccount();
            DcrAcc = new CurrentAccount();
            SsvAcc = new SavingsAccount();
            DsvAcc = new SavingsAccount();
			if (ScrAcc.is_CurrentAccount_exist(fromAccountNumber, accountType) 
					&& DcrAcc.is_CurrentAccount_exist(toAccountNumber, accountType)) {
				trans.setTransactionType("withdraw");
				double Sbal = ScrAcc.withdraw_from_CurrentAccount(amount ,fromAccountNumber);
				//Record the deposit transaction
				trandDAO.Record_Transactions(trans);
				session.setAttribute("crBalance", ""+Sbal);
				trans.setTransactionType("deposit");
				double Dbal = DcrAcc.deposit_to_CurrentAccount(amount, toAccountNumber);
				//Record the deposit transaction
				trandDAO.Record_Transactions(trans);
				

				response.sendRedirect("Transfer.jsp?Success=1");

				String msg = "Transfer Successful!!";
				request.getSession().setAttribute("Message", msg);
				
				 /*request.setAttribute("balance", bal); 
				 RequestDispatcher rd = request.getRequestDispatcher("/Deposit.jsp"); 
				 rd.forward(request, response);*/
				 

			} else if (SsvAcc.is_SavingsAccount_exist(fromAccountNumber, accountType) 
					&& DsvAcc.is_SavingsAccount_exist(toAccountNumber, accountType)) {
				trans.setTransactionType("withdraw");	
				double Sbal = SsvAcc.withdraw_from_SavingsAccount(amount ,fromAccountNumber);
				//Record the deposit transaction
				trandDAO.Record_Transactions(trans);
				session.setAttribute("svBalance", ""+Sbal);
				trans.setTransactionType("deposit");
				double Dbal = DsvAcc.deposit_to_SavingsAccount(amount, toAccountNumber);
				//Record the deposit transaction
				trandDAO.Record_Transactions(trans);

				//response.sendRedirect("Transfer.jsp?Success=1");
				
				 //request.setAttribute("CBalance", ""+Dbal); 
				 RequestDispatcher rd =	 request.getRequestDispatcher("/Transfer.jsp?Success=1"); 
				 rd.forward(request, response);
				 

			} else if (ScrAcc.is_CurrentAccount_exist(fromAccountNumber, accountType) 
					&& DsvAcc.is_SavingsAccount_exist(toAccountNumber, accountType)) {

				trans.setTransactionType("withdraw");
				double Sbal = ScrAcc.withdraw_from_CurrentAccount(amount ,fromAccountNumber);
				//Record the deposit transaction
				trandDAO.Record_Transactions(trans);
				
				trans.setTransactionType("deposit");
				double Dbal = DsvAcc.deposit_to_SavingsAccount(amount, toAccountNumber);
				//Record the deposit transaction
				trandDAO.Record_Transactions(trans);

				response.sendRedirect("Transfer.jsp?Success=1");
				/*
				 * request.setAttribute("CBalance", bal); RequestDispatcher rd =
				 * request.getRequestDispatcher("/Deposit.jsp"); rd.forward(request, response);
				 */
			} else if (SsvAcc.is_SavingsAccount_exist(fromAccountNumber, accountType) 
					&& DcrAcc.is_CurrentAccount_exist(toAccountNumber, accountType)) {

				trans.setTransactionType("withdraw");
				double Sbal = SsvAcc.withdraw_from_SavingsAccount(amount ,fromAccountNumber);
				//Record the deposit transaction
				trandDAO.Record_Transactions(trans);
				
				trans.setTransactionType("deposit");
				double Dbal = DcrAcc.deposit_to_CurrentAccount(amount, toAccountNumber);
				//Record the deposit transaction
				trandDAO.Record_Transactions(trans);
				
				response.sendRedirect("Transfer.jsp?Success=1");
				/*
				 * request.setAttribute("CBalance", bal); RequestDispatcher rd =
				 * request.getRequestDispatcher("/Deposit.jsp"); rd.forward(request, response);
				 */
			}else {
				// String msg = "Either your Account Selection or Amount is wrong. Please
				// Refresh Page and Try Again!!";
				// request.getSession().setAttribute("Message", msg);
				response.sendRedirect("Transfer.jsp?Success=-1");
			}

		} else {
			// String msg = "Either your Account Selection or Amount is wrong. Please
			// Refresh Page and Try Again!!";
			// request.getSession().setAttribute("Message", msg);
			response.sendRedirect("Transfer.jsp?Success=-1");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}