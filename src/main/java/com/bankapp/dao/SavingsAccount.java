package com.bankapp.dao;
import java.lang.*;
import java.util.*;
import java.sql.*;
import com.bankapp.*;

public class SavingsAccount{

private int SavingsAccountNumber;
private String CustomerName;
private double Balance;
private String CustomerID;



	public SavingsAccount(int SavingsAccountNumber, String cName, double bal, String UName){
			this.SavingsAccountNumber = SavingsAccountNumber;
			this.CustomerName = cName;
			this.Balance = bal;
			this.CustomerID = UName;
		}

	public SavingsAccount(int SavingsAccountNumber){
			this.SavingsAccountNumber = SavingsAccountNumber;
	}

	public SavingsAccount(String UName){
		this.CustomerID = UName;
	}
	
	public SavingsAccount(){
	}

	public double open_SavingsAccount(){
			double bal = -100;
			boolean done = !CustomerName.equals("") && !CustomerID.equals("");
			try{
				if(done){

				Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				String sql = "SELECT SavingsAccountNumber FROM SavingsAccount WHERE SavingsAccountNumber ='"+SavingsAccountNumber+"'"; //SQL query command
				ResultSet Rslt = st.executeQuery(sql); //Inquire if the accountNumber exsits.
		        done = done && !Rslt.next();
					if (done) {
					    Statement st2 = con.createStatement();
					    sql = "INSERT INTO SavingsAccount(SavingsAccountNumber, CustomerName, Balance, CustomerID) VALUES ('"+SavingsAccountNumber+ "','"+CustomerName+"','"+Balance+"','"+CustomerID+"')"; //Save the username, password and Name
					    st2.executeUpdate(sql);
					    bal = Balance;
				    }

			    st.close();
			    DBConnection.closeConn();
				}

			}
			catch(java.sql.SQLException e){
				done = false;
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
		             done = false;
		    		 System.out.println("Exception: " + e);
					 e.printStackTrace ();
		    }
	return bal;
	}
	
	public boolean is_SavingsAccount_exist(String accountNumber, String accountType) {
		
			boolean Acc_no = true;
		
			try{
				Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				String sql = "SELECT accountNumber FROM account WHERE accountNumber ='"+accountNumber+"' and accountType = '"+accountType+"'"; //SQL query command
				ResultSet Rslt = st.executeQuery(sql);
			     
					if (Rslt.next()) {
						Acc_no = true;
				    }
					else {
						Acc_no = false;
					}
				    st.close();
				    DBConnection.closeConn();

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
			
		return Acc_no;
	}

	public double deposit_to_SavingsAccount(double amount){

			double r_amount = -100;
			boolean done;
						try{

							DBConnection ToDB = new DBConnection();
							Connection con = ToDB.getConnection();
							Statement st = con.createStatement();
							String sql = "SELECT account, Balance FROM SavingsAccount WHERE accountNumber ='"+SavingsAccountNumber+"'"; //SQL query command
							ResultSet Rslt = st.executeQuery(sql); //Inquire if the username exsits.
					        done = Rslt.next();
								if (done) {
									double bal = Rslt.getDouble("Balance");
									double New_bal = bal + amount;
									sql = "UPDATE account SET Balance = '"+New_bal+"' WHERE accountNumber='"+SavingsAccountNumber+"'";
									st.executeUpdate(sql);
								    r_amount = New_bal;
							    }
						    st.close();
						    ToDB.closeConn();

						}
						catch(java.sql.SQLException e){
							done = false;
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
					             done = false;
					    		 System.out.println("Exception: " + e);
								 e.printStackTrace ();
					    }
		return r_amount;

	}

	public double withdraw_from_SavingsAccount( double amount , String accountNumber){

			double r_amount = -100;
			boolean done;
						try{

								Connection con = DBConnection.getConnection();
								Statement st = con.createStatement();
								String sql = "SELECT accountNumber, Balance FROM account WHERE accountNumber ='"+accountNumber+"'"; //SQL query command
								ResultSet Rslt = st.executeQuery(sql);
						        done = Rslt.next();
									if (done) {
										double bal = Rslt.getDouble("Balance");
										if(bal>amount){
											double New_bal = bal - amount;
										    sql = "UPDATE account SET Balance = '"+New_bal+"' WHERE accountNumber='"+accountNumber+"'";
										    st.executeUpdate(sql);
										    r_amount = New_bal;
										}
									}

								    st.close();
								    DBConnection.closeConn();

						}
						catch(java.sql.SQLException e){
								done = false;
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
					             done = false;
					    		 System.out.println("Exception: " + e);
								 e.printStackTrace ();
					    }
		return r_amount;
	}
	
	public double deposit_to_SavingsAccount(double amount, String accountNumber) {

		double r_amount = -100;
		boolean done;
		try {

			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT accountNumber, Balance FROM account WHERE accountNumber ='" + accountNumber + "'"; // SQL
																													// query
																													// command
			ResultSet Rslt = st.executeQuery(sql);
			done = Rslt.next();
			if (done) {
				double bal = Rslt.getDouble("Balance");
				double New_bal = bal + amount;
				sql = "UPDATE account SET Balance = '" + New_bal + "' WHERE accountNumber='" + accountNumber + "'";
				st.executeUpdate(sql);
				r_amount = New_bal;

			}
			st.close();
			DBConnection.closeConn();
		} catch (java.sql.SQLException e) {
			done = false;
			System.out.println("SQLException: " + e);
			while (e != null) {
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Message: " + e.getMessage());
				System.out.println("Vendor: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			}
		} catch (java.lang.Exception e) {
			done = false;
			System.out.println("Exception: " + e);
			e.printStackTrace();
		}
		return r_amount;
}

	public double ViewSavingsBalance(String SavingsAccountNumber){
			double balance = -100;
			boolean done;

			try{
				Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				String sql = "SELECT Balance FROM account WHERE accountNumber ='"+SavingsAccountNumber+"'"; //SQL query command
				ResultSet Rslt = st.executeQuery(sql);
			    done = Rslt.next();
					if (done) {
						balance = Rslt.getDouble("Balance");
				    }
				    st.close();
				    con.close();

			}
			catch(java.sql.SQLException e){
				done = false;
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
				done = false;
				System.out.println("Exception: " + e);
				e.printStackTrace ();
			}
	return balance;
	}

	public Vector getSAccounts(){
				Vector accounts = new Vector();

				try{
					DBConnection ToDB = new DBConnection();
					Connection con = ToDB.getConnection();
					Statement st = con.createStatement();
					String sql = "SELECT  SavingsAccountNumber FROM SavingsAccount WHERE CustomerID ='"+CustomerID+"'"; //SQL query command
					ResultSet Rslt = st.executeQuery(sql);
						while(Rslt.next()){
							int ac_no = Rslt.getInt("SavingsAccountNumber");
							accounts.add(ac_no);
					    }
					    st.close();
					    ToDB.closeConn();
				}
				catch(java.sql.SQLException e){
					//done = false;
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
					//done = false;
					System.out.println("Exception: " + e);
					e.printStackTrace ();
				}
		return accounts;
	}

	public double getCurrentBalance(String accountNumber, String accounttype) {
		// TODO Auto-generated method stub
		return 0;
	}

/*	public static void main (String args []){
	}*/




}