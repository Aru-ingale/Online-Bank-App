package com.bankapp.servlets;
import java.io.IOException;

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
 * Servlet implementation class DepositServlet
 */
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CurrentAccount currAcc;
	private SavingsAccount svAcc;
	private TransactionsDAO trandDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    		String accountNumber = request.getParameter("accountNumber");
    		String amt = request.getParameter("amount");
    		double amount = Double.parseDouble(amt);
    		String accountType =  request.getParameter("accountType");
    		String mobile = request.getParameter("number");
    		
    		
    		//Getting UserName
    		HttpSession session = request.getSession();
    		String userName = (String)session.getAttribute("userName");
    		
    		if(accountNumber != "" && amt != "") {
    			
    			currAcc = new CurrentAccount();
    			svAcc = new SavingsAccount();
    			/*if(ckAcc.is_CheckingAccount_exist()) {
    				
    				double bal = ckAcc.deposit_to_CheckingAccount(amt);
    				
    				tr = new Transactions("Deposit", amt, "Checking", "Checking",userName);
				    tr.Record_Transactions();
				    
				    request.setAttribute("CBalance", bal);
				    RequestDispatcher rd = request.getRequestDispatcher("/Deposit.jsp?Success=1");
				    rd.forward(request, response);*/
    			//transaction
				Transaction trans = new Transaction();
				trans.setTransactionType("deposit");
				trans.setFromAccount(accountNumber);
				trans.setToAccount(accountNumber);
				trans.setUserName(userName);
				trans.setAmount(amount);
				trans.setMobileNum(mobile);
				trandDAO = new TransactionsDAO();
    			
				if(svAcc.is_SavingsAccount_exist(accountNumber, accountType)) {
    				double bal = svAcc.deposit_to_SavingsAccount(amount,accountNumber);
    				//Record the deposit transaction
    				trandDAO.Record_Transactions(trans);
    				
    				session.setAttribute("balance", ""+bal);
    				session.setAttribute("svBalance", ""+bal);
 				    RequestDispatcher rd = request.getRequestDispatcher("/Deposit.jsp?Success=1");
 				    rd.forward(request, response);
    				
    			}
    			else if(currAcc.is_CurrentAccount_exist(accountNumber, accountType)) {
    				double bal = currAcc.deposit_to_CurrentAccount(amount, accountType);
    				
    				//Record the deposit transaction
    				trandDAO.Record_Transactions(trans);
				    
    				request.setAttribute("balance", ""+bal);
    				session.setAttribute("crBalance", ""+bal);
    				RequestDispatcher rd = request.getRequestDispatcher("/Deposit.jsp?Success=1");
				    rd.forward(request, response);
    				
    			}
    		}
    		else {
    			//String msg = "Either your Account Selection or Amount is wrong. Please Refresh Page and Try Again!!";
    			//request.getSession().setAttribute("Message", msg);
    			response.sendRedirect("Deposit.jsp?Success=-1");
    		}
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