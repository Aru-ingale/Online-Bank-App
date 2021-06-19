package com.bankapp.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.*;
import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDetails;
import com.bankapp.dao.UserDAO;
import com.bankapp.dao.SavingsAccount;
import com.bankapp.models.UserDetails;
import com.bankapp.models.Users;

import java.util.*;

/**
 * Servlet implementation class LoginServlet
 * LoginServlet implements Filter
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String userName = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private AccountDetails ckAcc;
	private SavingsAccount svAcc;
	private Vector ckAccounts, svAccounts;
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            Users user = new Users();
            user.setUserName(userName);
            user.setPassword(password);
            UserDetails dbUser = new UserDAO().signIn(user);
            if(dbUser.getFname()!= "" && dbUser.getMname()!= "" && dbUser.getLname()!= "" ) {	
            	            	
   			 	// set session scoped attribute
   		        HttpSession session = request.getSession();
   		          		           		  
   		        //Passing User Name and Customer Name in session
   		        session.setAttribute("fname", dbUser.getFname());
   		        session.setAttribute("mname", dbUser.getMname());
   		        session.setAttribute("lname", dbUser.getLname());
   		        
	   		     Cookie loginCookie = new Cookie("user",userName);
	 			//setting cookie to expiry in 30 mins
	 			loginCookie.setMaxAge(30*60);
	 			response.addCookie(loginCookie);
   		        //Redirecting to Account Overview Page 
            	response.sendRedirect("welcome.jsp");
            }else {
            	response.sendRedirect("index.jsp");
            }
            
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
	
	/*public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException{
	
	}*/
	
}