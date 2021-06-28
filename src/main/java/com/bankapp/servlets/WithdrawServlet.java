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
 * Servlet implementation class Withdraw
 */
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CurrentAccount crAcc;
	private SavingsAccount svAcc;
	private TransactionsDAO tr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String accountNumber = request.getParameter("accountNumber");
		String amt = request.getParameter("amount");
		String accounttype =  request.getParameter("accountType");
		double amount = Double.parseDouble(amt);
		String transDate = request.getParameter("transDate");
		String mobile = request.getParameter("number");
    	
		//Getting UserName
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		
		if(accountNumber != "" && amt != "") {
			
			//ckAcc = new AccountDetails();
			//svAcc = new SavingsAccount();
			/*if(ckAcc.is_CheckingAccount_exist()) {
				
				double bal = ckAcc.deposit_to_CheckingAccount(amt);
				
				tr = new Transactions("Deposit", amt, "Checking", "Checking",userName);
			    tr.Record_Transactions();
			    
			    request.setAttribute("CBalance", bal);
			    RequestDispatcher rd = request.getRequestDispatcher("/Deposit.jsp?Success=1");
			    rd.forward(request, response);*/
			Transaction trans = new Transaction();
			trans.setTransactionType("withdraw");
			trans.setFromAccount(accountNumber);
			trans.setToAccount(accountNumber);
			trans.setUserName(userName);
			trans.setAmount(amount);
			trans.setMobileNum(mobile);
			tr = new TransactionsDAO();
			
			if(svAcc.is_SavingsAccount_exist(accountNumber, accounttype)) {
				//transaction
				double bal = svAcc.deposit_to_SavingsAccount(amount,accountNumber);
				tr.Record_Transactions(trans);
				
				session.setAttribute("balance", ""+bal);
				    RequestDispatcher rd = request.getRequestDispatcher("/Deposit.jsp?Success=1");
				    rd.forward(request, response);
				
			}
			else if(crAcc.is_CurrentAccount_exist(accountNumber, accounttype)) {
				double bal = crAcc.deposit_to_CurrentAccount(amount,accountNumber);
				tr.Record_Transactions(trans);
				
				session.setAttribute("balance", ""+bal);
				    RequestDispatcher rd = request.getRequestDispatcher("/Deposit.jsp?Success=1");
				    rd.forward(request, response);
				/*double bal = svAcc.deposit_to_SavingsAccount(amt);
				
				tr = new Transactions("Deposit", amt, "Savings", "Savings",userName);
			    tr.Record_Transactions();
			    
				request.setAttribute("SBalance", bal);
				RequestDispatcher rd = request.getRequestDispatcher("/Deposit.jsp?Success=1");
			    rd.forward(request, response);*/
				
			}
		}
		else {
			//String msg = "Either your Account Selection or Amount is wrong. Please Refresh Page and Try Again!!";
			//request.getSession().setAttribute("Message", msg);
			response.sendRedirect("Deposit.jsp?Success=-1");
		}
    		/*String withdrawSelection = request.getParameter("Withdraw");
    		String amount = request.getParameter("Amount");
    		double amt = Double.parseDouble(amount);
    		
    		//Getting UserName
    		HttpSession session = request.getSession();
    		String userName = (String)session.getAttribute("UName");
    		
    		if(withdrawSelection != "" && amount != "") {
    			int Acc_no = Integer.parseInt(withdrawSelection);
    			ckAcc = new AccountDetails(Acc_no);
    			svAcc = new SavingsAccount(Acc_no);
    			if(ckAcc.is_CheckingAccount_exist()) {
    				
    				double bal = ckAcc.withdraw_from_CheckingAccount(amt);
    				
    				tr = new TransactionsDAO("Withdraw", amt, "Checking", "Checking",userName);
				    tr.Record_Transactions();
				    
				    request.setAttribute("CBalance", bal);
				    RequestDispatcher rd = request.getRequestDispatcher("/Withdraw.jsp?Success=1");
				    rd.forward(request, response);
    				
    			}
    			else if(svAcc.is_SavingsAccount_exist()) {
    				double bal = svAcc.withdraw_from_SavingsAccount(amt);
    				
    				tr = new TransactionsDAO("Withdraw", amt, "Savings", "Savings",userName);
				    tr.Record_Transactions();
				    
    				request.setAttribute("SBalance", bal);
    				RequestDispatcher rd = request.getRequestDispatcher("/Withdraw.jsp?Success=1");
				    rd.forward(request, response);
    				
    			}
    		}
    		else {
    			//String msg = "Either your Account Selection or Amount is wrong. Please Refresh Page and Try Again!!";
    			//request.getSession().setAttribute("Message", msg);
    			response.sendRedirect("Deposit.jsp?Success=-1");
    		}*/
    }
    
    
    

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

}