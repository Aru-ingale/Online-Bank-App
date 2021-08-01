package com.bankapp.dao;
import java.lang.*;
import java.util.*;
import com.bankapp.*;
import com.bankapp.models.Transaction;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionsDAO{

private int TransactionID;
private String TransactionType;
private String TransactionDate;
private double Amount;
private String FromAccount;
private String ToAccount;
private String CustomerID;

private DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	public TransactionsDAO(String TransactionType, double Amount, String FromAcc, String ToAcc, String UName){

// This code snippet will generate TransactionID using random number.

		int Tran_ID = generator();
		this.TransactionID = Tran_ID;

// This code snippet will generate today's date and time when the constructor is called(or when the object is created)

		Date date = new Date();
		this.TransactionDate = sdf.format(date);

		this.TransactionType = TransactionType;
		this.Amount = Amount;
		this.FromAccount = FromAcc;
		this.ToAccount = ToAcc;
		this.CustomerID = UName;

	}
	
	public TransactionsDAO() {
		
	}

	private int generator(){
		// This code snippet is creating 6 digit random transaction id.
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		return n;
	}


	public void Record_Transactions(Transaction trans){

		try{
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			String str = "select userid from login_details where userName='"+ trans.getUserName()+"'";
			ResultSet rs = st.executeQuery(str);
			int userId = 0;
			while(rs.next()) {
				userId = rs.getInt("userid");
			}
			int Tran_ID = generator();
			String sql = "SELECT TransactionID FROM Transactions WHERE TransactionID ='"+Tran_ID+"'"; //SQL query command
			ResultSet Rslt = st.executeQuery(sql); //Inquire if the accountNumber exsits.
		    boolean done = !Rslt.next();
				if (done) {

				   	Statement st2 = con.createStatement();
				    sql = "INSERT INTO Transactions(TransactionID, TransactionType, FromAccount, ToAccount, USERID,Status,AMOUNT,mobilenumber,TransactionDate) VALUES ('"+Tran_ID+ "','"+trans.getTransactionType()+"','"+trans.getFromAccount()+"', '"+trans.getToAccount()+"','"+userId+"', 'pending', '"+trans.getAmount()+"','"+trans.getMobileNum()+"', curdate())"; //Save the username, password and Name
				    st2.executeUpdate(sql);
			    }
			    else{
						st.close();
						DBConnection.closeConn();
					// The generator method will only generate upto 6 digit Transactions ID. Once it will use all the numbers and will start
					// produce the same ID everytime. This recursion will go in infinite loop. Which is not good. So, This issue should be
					// address in the near future.
					Record_Transactions(trans);
					//System.out.println("THE TRANSACTION ID IS ALREADY EXISTS..!!!");
				}


		}
		catch(java.sql.SQLException e){

			System.out.println("SQLException: " + e);
				while (e != null)
				{   System.out.println("SQLState: " + e.getSQLState());
					System.out.println("Message: " + e.getMessage());
					System.out.println("Vendor: " + e.getErrorCode());
					e = e.getNextException();
					System.out.println("");
				 }
		}
		catch (java.lang.Exception e){

			 System.out.println("Exception: " + e);
			 e.printStackTrace ();
		}
	}



	public List<Transaction> getDepositeWithdrawTransactions(String accountNumber) {
		List<Transaction> transList = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		try {
			Statement stat = conn.createStatement();
			String query = "select t.TRANSACTIONTYPE,t.FROMACCOUNT,t.TOACCOUNT,t.USERID,t.STATUS,t.AMOUNT,"
					+ " t.MOBILENUMBER from transactions t INNER JOIN users u ON t.userid = u.userid "
					+ " where FROMACCOUNT='"+accountNumber+"' order by TRANSACTIONDATE;";
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				Transaction tr = new Transaction();
				tr.setTransactionType(rs.getString("transactiontype"));
				tr.setFromAccount(rs.getString("FROMACCOUNT"));
				tr.setToAccount(rs.getString("TOACCOUNT"));
				tr.setUserId(rs.getInt("USERID"));
				tr.setStatus(rs.getString("STATUS"));
				tr.setAmount(rs.getDouble("AMOUNT"));
				tr.setMobileNum(rs.getString("MOBILENUMBER"));
				transList.add(tr);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			while (e != null)
			{   System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Message: " + e.getMessage());
				System.out.println("Vendor: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			 }
		} 
		return transList;
	}
	
	
	public List<Transaction> getAllTransactions() {
		List<Transaction> transList = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		try {
			Statement stat = conn.createStatement();
			String query = "select u.fname,u.mname,u.lname, t.transactionid, t.TRANSACTIONTYPE,t.FROMACCOUNT,t.TOACCOUNT,t.USERID,t.STATUS,t.AMOUNT,"
					+ " t.MOBILENUMBER from transactions t INNER JOIN users u ON t.userid = u.userid where t.status = 'pending'"
					+ " order by TRANSACTIONDATE;";
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				Transaction tr = new Transaction();
				tr.setFname(rs.getString("fname"));
				tr.setMname(rs.getString("mname"));
				tr.setLname(rs.getString("lname"));
				tr.setTransactionId(rs.getInt("transactionId"));
				tr.setTransactionType(rs.getString("transactiontype"));
				tr.setFromAccount(rs.getString("FROMACCOUNT"));
				tr.setToAccount(rs.getString("TOACCOUNT"));
				tr.setUserId(rs.getInt("USERID"));
				tr.setStatus(rs.getString("STATUS"));
				tr.setAmount(rs.getDouble("AMOUNT"));
				tr.setMobileNum(rs.getString("MOBILENUMBER"));
				transList.add(tr);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			while (e != null)
			{   System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Message: " + e.getMessage());
				System.out.println("Vendor: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			 }
		} 
		return transList;
	}

	public boolean approveTransactions(Transaction tr) {
		Connection conn = DBConnection.getConnection();
		int i = 0;
		try {
			Statement stat = conn.createStatement();
			String query = "update transactions set status = 'approve' where userid = '"+tr.getUserId()+"' and transactionId = "+tr.getTransactionId();
			i = stat.executeUpdate(query);
						
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			while (e != null)
			{   System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Message: " + e.getMessage());
				System.out.println("Vendor: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			 }
		} 
		return i > 0 ? true : false;
	}

}