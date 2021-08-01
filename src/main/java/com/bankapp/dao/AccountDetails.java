package com.bankapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.management.RuntimeErrorException;

import com.bankapp.exception.CustomDBException;
import com.bankapp.models.Account;
import com.bankapp.models.UserDetails;
import com.bankapp.util.BankUtil;

public class AccountDetails {

	public AccountDetails() {
	}

	public Account createAccount(Account acc, String userName) {

		boolean flag = true;
		int userId = 0;
		Account account = new Account();
		try {
			Connection conn = DBConnection.getConnection();
			Statement Stmt = conn.createStatement();
			String maxAccountNumber = "SELECT accountnumber FROM account ORDER BY accountnumber DESC LIMIT 1";
			ResultSet result = Stmt.executeQuery(maxAccountNumber);
			String accountNumber = "";
			while (result.next()) {
				accountNumber = BankUtil.generateBankAccountNumber(result.getString("accountnumber"));
			}
			if (accountNumber.equalsIgnoreCase("")) {
				accountNumber = "RCITY0001";
			}
			String SQL_Command = "SELECT userId FROM login_details WHERE userName ='" + userName + "'"; 
			ResultSet rs = Stmt.executeQuery(SQL_Command); // Inquire if the username exsits.
			while (rs.next()) {
				userId = rs.getInt("userid");
			}
			SQL_Command = "SELECT accountnumber FROM account WHERE userId ='" + userId + "' and accountType='"
					+ acc.getAccountType() + "'"; 
			ResultSet Rslt = Stmt.executeQuery(SQL_Command);
			flag = flag && !Rslt.next();
			if (flag) {
				SQL_Command = "INSERT INTO account VALUES ('" + accountNumber + "','" + acc.getAccountType() + "',"
						+ userId + ",'" + acc.getSalution() + "'," + "'" + acc.getAccountHolderName()
						+ "','GPO PUNE-411001','RCIT000210','pending','" + acc.getBalance() + "')";

				Stmt.executeUpdate(SQL_Command);

				SQL_Command = "select accountNumber,accountType from account where userid =" + userId;
				ResultSet rs1 = Stmt.executeQuery(SQL_Command);
				while (rs1.next()) {
					account.setAccountNumber(rs1.getString("accountNumber"));
					account.setAccountType(rs1.getString("accounttype"));
					//account.setBalance(rs1.getDouble("balance"));
				}
			} else {
				throw new CustomDBException( "User already has "+acc.getAccountType()+" account.");
			}
			Stmt.close();
			conn.close();
		} catch (SQLException e) {
			flag = false;
			System.out.println("SQLException: " + e);
			while (e != null) {
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Message: " + e.getMessage());
				System.out.println("Vendor: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			}
		} catch (Exception e) {
			flag = false;
			System.out.println("Exception: " + e);
		}
		return account;
	}

	public List<Account> getAllAccountsForApproval() {
		List<Account> accounts = new ArrayList<>();
		try {
			Connection conn = DBConnection.getConnection();
			Statement Stmt = conn.createStatement();
			String query = "SELECT * FROM account where status = 'pending' ORDER BY accountnumber";
			ResultSet rs = Stmt.executeQuery(query); // Inquire if the username exsits.
			while (rs.next()) {
				Account acc = new Account();
				acc.setAccountHolderName(rs.getString("accountHolderName"));
				acc.setAccountNumber(rs.getString("accountNumber"));
				acc.setAccountType(rs.getString("accountType"));
				acc.setBalance(rs.getDouble("balance"));
				acc.setStatus(rs.getString("status"));
				acc.setUserId(rs.getInt("userId"));
				accounts.add(acc);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e);
			while (e != null) {
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Message: " + e.getMessage());
				System.out.println("Vendor: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
			
		return accounts;
	}

	public boolean approveAccount(String userId, String accountType) {
		Connection conn = DBConnection.getConnection();
		int i = 0;
		try {
			Statement stat = conn.createStatement();
			String query = "update account set status = 'approve' where userid = '"+userId+"' and accountType = '"+accountType+"'";
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

	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public double open_CheckingAccount(){ double bal = -100; boolean done =
	 * !userName.equals("") && !userId.equals(""); try{ if(done){
	 * 
	 * DBConnection ToDB = new DBConnection(); Connection con =
	 * ToDB.getConnection(); Statement st = con.createStatement(); String sql =
	 * "SELECT accountNumber FROM CheckingAccount WHERE accountNumber ='"
	 * +accountNumber+"'"; //SQL query command ResultSet Rslt =
	 * st.executeQuery(sql); //Inquire if the accountNumber exsits. done = done &&
	 * !Rslt.next(); if (done) { Statement st2 = con.createStatement(); sql =
	 * "INSERT INTO CheckingAccount(accountNumber, CustomerName, Balance, CustomerID) VALUES ('"
	 * +accountNumber+ "','"+userName+"','"+Balance+"','"+userId+"')"; //Save the
	 * username, password and Name st2.executeUpdate(sql); bal = Balance; }
	 * 
	 * st.close(); ToDB.closeConn(); }
	 * 
	 * } catch(java.sql.SQLException e){ done = false;
	 * System.out.println("SQLException: " + e); while (e != null) {
	 * System.out.println("SQLState: " + e.getSQLState());
	 * System.out.println("Message: " + e.getMessage());
	 * System.out.println("Vendor: " + e.getErrorCode()); e = e.getNextException();
	 * System.out.println(""); } } catch (java.lang.Exception e){ done = false;
	 * System.out.println("Exception: " + e); e.printStackTrace (); } return bal; }
	 */

	/*
	 * public boolean is_CheckingAccount_exist() {
	 * 
	 * boolean Acc_no = true;
	 * 
	 * try{ DBConnection ToDB = new DBConnection(); Connection con =
	 * ToDB.getConnection(); Statement st = con.createStatement(); String sql =
	 * "SELECT accountNumber FROM CheckingAccount WHERE accountNumber ='"
	 * +accountNumber+"'"; //SQL query command ResultSet Rslt =
	 * st.executeQuery(sql);
	 * 
	 * if (Rslt.next()) { Acc_no = true; } else { Acc_no = false; } st.close();
	 * ToDB.closeConn();
	 * 
	 * } catch(java.sql.SQLException e){
	 * 
	 * System.out.println("SQLException: " + e); while (e != null) {
	 * System.out.println("SQLState: " + e.getSQLState());
	 * System.out.println("Message: " + e.getMessage());
	 * System.out.println("Vendor: " + e.getErrorCode()); e = e.getNextException();
	 * System.out.println(""); } } catch (java.lang.Exception e){
	 * 
	 * System.out.println("Exception: " + e); e.printStackTrace (); }
	 * 
	 * return Acc_no; }
	 */

	/*
	 * public double deposit_to_CheckingAccount(double amount, String
	 * accountNumber){
	 * 
	 * double r_amount = -100; boolean done; try{
	 * 
	 * Connection con = DBConnection.getConnection(); Statement st =
	 * con.createStatement(); String sql =
	 * "SELECT accountNumber, Balance FROM account WHERE accountNumber ='"
	 * +accountNumber+"'"; //SQL query command ResultSet Rslt =
	 * st.executeQuery(sql); done = Rslt.next(); if (done) { double bal =
	 * Rslt.getDouble("Balance"); double New_bal = bal + amount; sql =
	 * "UPDATE account SET Balance = '"+New_bal+"' WHERE accountNumber='"
	 * +accountNumber+"'"; st.executeUpdate(sql); r_amount = New_bal;
	 * 
	 * } st.close(); DBConnection.closeConn();
	 * 
	 * 
	 * } catch(java.sql.SQLException e){ done = false;
	 * System.out.println("SQLException: " + e); while (e != null) {
	 * System.out.println("SQLState: " + e.getSQLState());
	 * System.out.println("Message: " + e.getMessage());
	 * System.out.println("Vendor: " + e.getErrorCode()); e = e.getNextException();
	 * System.out.println(""); } } catch (java.lang.Exception e){ done = false;
	 * System.out.println("Exception: " + e); e.printStackTrace (); } return
	 * r_amount;
	 * 
	 * }
	 */

	/*
	 * public double withdraw_from_CheckingAccount(double amount){
	 * 
	 * double r_amount = -100; boolean done; try{
	 * 
	 * DBConnection ToDB = new DBConnection(); Connection con =
	 * ToDB.getConnection(); Statement st = con.createStatement(); String sql =
	 * "SELECT accountNumber, Balance FROM CheckingAccount WHERE accountNumber ='"
	 * +accountNumber+"'"; //SQL query command ResultSet Rslt =
	 * st.executeQuery(sql); done = Rslt.next(); if (done) { double bal =
	 * Rslt.getDouble("Balance"); if(bal>amount){ double New_bal = bal - amount; sql
	 * = "UPDATE CheckingAccount SET Balance = '"+New_bal+"' WHERE accountNumber='"
	 * +accountNumber+"'"; st.executeUpdate(sql); r_amount = New_bal; } }
	 * 
	 * st.close(); ToDB.closeConn();
	 * 
	 * } catch(java.sql.SQLException e){ done = false;
	 * System.out.println("SQLException: " + e); while (e != null) {
	 * System.out.println("SQLState: " + e.getSQLState());
	 * System.out.println("Message: " + e.getMessage());
	 * System.out.println("Vendor: " + e.getErrorCode()); e = e.getNextException();
	 * System.out.println(""); } } catch (java.lang.Exception e){ done = false;
	 * System.out.println("Exception: " + e); e.printStackTrace (); } return
	 * r_amount; }
	 */

	/*
	 * public double ViewCheckingBalance(){ double balance = -100; boolean done;
	 * 
	 * try{ DBConnection ToDB = new DBConnection(); Connection con =
	 * ToDB.getConnection(); Statement st = con.createStatement(); String sql =
	 * "SELECT Balance FROM CheckingAccount WHERE accountNumber ='"+accountNumber+
	 * "'"; //SQL query command ResultSet Rslt = st.executeQuery(sql); done =
	 * Rslt.next(); if (done) { balance = Rslt.getDouble("Balance"); } st.close();
	 * ToDB.closeConn();
	 * 
	 * } catch(java.sql.SQLException e){ done = false;
	 * System.out.println("SQLException: " + e); while (e != null) {
	 * System.out.println("SQLState: " + e.getSQLState());
	 * System.out.println("Message: " + e.getMessage());
	 * System.out.println("Vendor: " + e.getErrorCode()); e = e.getNextException();
	 * System.out.println(""); } } catch (java.lang.Exception e){ done = false;
	 * System.out.println("Exception: " + e); e.printStackTrace (); } return
	 * balance; }
	 */

	/*
	 * public Vector getCAccounts(){ Vector accounts = new Vector();
	 * 
	 * try{ DBConnection ToDB = new DBConnection(); Connection con =
	 * ToDB.getConnection(); Statement st = con.createStatement(); String sql =
	 * "SELECT  accountNumber FROM account WHERE userName ='"+userName+"'"; //SQL
	 * query command ResultSet Rslt = st.executeQuery(sql);
	 * 
	 * while (Rslt.next()) { int ac_no = Rslt.getInt("accountNumber");
	 * accounts.add(ac_no); } st.close(); ToDB.closeConn(); }
	 * catch(java.sql.SQLException e){ //done = false;
	 * System.out.println("SQLException: " + e); while (e != null) {
	 * System.out.println("SQLState: " + e.getSQLState());
	 * System.out.println("Message: " + e.getMessage());
	 * System.out.println("Vendor: " + e.getErrorCode()); e = e.getNextException();
	 * System.out.println(""); } } catch (java.lang.Exception e){ //done = false;
	 * System.out.println("Exception: " + e); e.printStackTrace (); } return
	 * accounts; }
	 */

	/*
	 * public static void main (String args []){ }
	 */
}