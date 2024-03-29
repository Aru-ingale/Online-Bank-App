package com.bankapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDetails;
import com.bankapp.dao.SavingsAccount;
import com.bankapp.dao.TransactionsDAO;
import com.bankapp.exception.CustomDBException;
import com.bankapp.models.UserDetails;

/**
 * Servlet implementation class OpenAccountServlet
 */
public class OpenAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountDetails ckAcc, nckAcc;
	private SavingsAccount svAcc, nsvAcc;
	private TransactionsDAO tr;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OpenAccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
			}
		}
		String accounttype = request.getParameter("accounttype");
		String salutation = request.getParameter("salutation");
		String fullName = request.getParameter("fullname");
		String bal = request.getParameter("balance");
		double balance = Double.parseDouble(bal);
		String vCode = request.getParameter("token");

		com.bankapp.models.Account account = new com.bankapp.models.Account();
		account.setAccountType(accounttype);
		account.setSalution(salutation);
		account.setAccountHolderName(fullName);
		account.setBalance(balance);
		account.setvCode(vCode);
		AccountDetails accDetails = new AccountDetails();
		com.bankapp.models.Account newAccount = new com.bankapp.models.Account();
		try {
		     newAccount = accDetails.createAccount(account, userName);
		}catch(CustomDBException ex) {
			//ex.getMessage();
			request.setAttribute("msg", "The verification code did not match!!!");
			RequestDispatcher rd = request.getRequestDispatcher("/OpenAccount.jsp?Success=-1");
			rd.forward(request, response);
		}
		HttpSession session = request.getSession();

		if (!newAccount.getAccountNumber().equalsIgnoreCase("")) {
			if (newAccount.getAccountType().equalsIgnoreCase("saving")) {
				session.setAttribute("svAccountNumber", newAccount.getAccountNumber());
				session.setAttribute("svAccountType", newAccount.getAccountType());
				//session.setAttribute("svBalance", "" + ""+newAccount.getBalance());
			} else {
				session.setAttribute("crAccountNumber", newAccount.getAccountNumber());
				session.setAttribute("crAccountType", newAccount.getAccountType());
				//session.setAttribute("crBalance", "" + ""+newAccount.getBalance());
			}
			request.setAttribute("msg", "Account Number "+ newAccount.getAccountNumber()+" is created successfully.!!");
			RequestDispatcher rd = request.getRequestDispatcher("/OpenAccount.jsp?Success=1");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Account Number is already Exist!!");
			RequestDispatcher rd = request.getRequestDispatcher("/OpenAccount.jsp?Success=-1");
			rd.forward(request, response);
		}
		/*
		 * int account_no = Integer.parseInt(acc_no); double amt =
		 * Double.parseDouble(amount);
		 * 
		 * // Getting UserName HttpSession session = request.getSession(); String
		 * userName = (String) session.getAttribute("user"); Account account = new
		 * Account(); account.createAccount(null); response.sendRedirect("welcome.jsp");
		 * 
		 * /* if(accountSelection != "" && amount != "") ckAcc = new
		 * AccountDetails(account_no); svAcc = new SavingsAccount(account_no);
		 * 
		 * if(accountSelection == "Checking") {
		 * 
		 * if(ckAcc.is_CheckingAccount_exist() || svAcc.is_SavingsAccount_exist()) {
		 * 
		 * request.setAttribute("msg", "Account Number is already Exist!!");
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/OpenAccount.jsp?Success=-1");
		 * rd.forward(request, response); }else {
		 * 
		 * nckAcc = new AccountDetails(account_no, customer_name, amt, userName);
		 * 
		 * double bal = nckAcc.open_CheckingAccount();
		 * 
		 * tr = new Transactions("Deposit", amt, "Checking", "Checking",userName);
		 * tr.Record_Transactions();
		 * 
		 * request.setAttribute("msg", "Account Created Successfully!!");
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/OpenAccount.jsp?Success=1");
		 * rd.forward(request, response); } }else
		 * if(accountSelection.equalsIgnoreCase("Savings")) {
		 * if(ckAcc.is_CheckingAccount_exist() || svAcc.is_SavingsAccount_exist()) {
		 * 
		 * request.setAttribute("msg", "Account Number is already Exist!!");
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/OpenAccount.jsp?Success=-1");
		 * rd.forward(request, response); }else {
		 * 
		 * nsvAcc = new SavingsAccount(account_no, customer_name, amt, userName);
		 * 
		 * double bal = nsvAcc.open_SavingsAccount();
		 * 
		 * tr = new Transactions("Deposit", amt, "Savings", "Savings",userName);
		 * tr.Record_Transactions();
		 * 
		 * request.setAttribute("msg", "Account Created Successfully!!");
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/OpenAccount.jsp?Success=1");
		 * rd.forward(request, response); } } } else { //String msg =
		 * "Either your Account Selection or Amount is wrong. Please Refresh Page and Try Again!!"
		 * ; //request.getSession().setAttribute("Message", msg);
		 * response.sendRedirect("OpenAccount.jsp?Success=-1"); }
		 */
	}

}