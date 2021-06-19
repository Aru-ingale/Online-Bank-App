package com.bankapp.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.bankapp.models.Account;
import com.bankapp.models.UserDetails;
import com.bankapp.util.BankUtil;

public class AccountDetails{

private int accountNumber;
private String userName;
private double Balance;
private String userId;

	public AccountDetails(int accountNumber, String cName, double bal, String UName){
		this.accountNumber = accountNumber;
		this.userName = cName;
		this.Balance = bal;
		this.userId = UName;
	}
	public AccountDetails(int accountNumber){
		this.accountNumber = accountNumber;
	}
	public AccountDetails(String UName){
		this.userName = UName;
	}
	
	public AccountDetails(){
	}
	
public boolean createAccount(Account acc, String userName) {
		
		boolean flag = true;
		int userId = 0;
		try {
		    //if (flag) {
		        Connection conn = DBConnection.getConnection();
		        Statement Stmt = conn.createStatement();
		        String maxAccountNumber = "SELECT accountnumber FROM account ORDER BY accountnumber DESC LIMIT 1";
		        ResultSet result= Stmt.executeQuery(maxAccountNumber);
		        String accountNumber = "";
		        while(result.next()) {
		        	accountNumber = BankUtil.generateBankAccountNumber(result.getString("accountnumber"));
		        }
		        if(accountNumber.equalsIgnoreCase("")) {
		        	accountNumber = "RCITY0001";
		        }
		        String SQL_Command = "SELECT userId FROM login_details WHERE userName ='"+userName+"'"; //SQL query command
		        ResultSet rs = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        while(rs.next()) {
		        	userId = rs.getInt("userid");
		        }
		        /*flag = flag && !Rslt.next();
		        if (flag) {*/
		        SQL_Command = "INSERT INTO account VALUES ('"+accountNumber+"','"+acc.getAccountType()+"',"+userId+",'"+acc.getSalution()+"',"
				    		+ "'"+acc.getAccountHolderName()+"','GPO PUNE-411001','RCIT000210','pending','"+acc.getBalance()+"')"; 
				   
				Stmt.executeUpdate(SQL_Command);
			    //}
			    Stmt.close();
			    conn.close();;
			//}
		}
	    catch(SQLException e)
	    {         flag = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (Exception e)
	    {         flag = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return flag;
	}


	public double open_CheckingAccount(){
			double bal = -100;
			boolean done = !userName.equals("") && !userId.equals("");
			try{
				if(done){

				DBConnection ToDB = new DBConnection();
				Connection con = ToDB.getConnection();
				Statement st = con.createStatement();
				String sql = "SELECT accountNumber FROM CheckingAccount WHERE accountNumber ='"+accountNumber+"'"; //SQL query command
				ResultSet Rslt = st.executeQuery(sql); //Inquire if the accountNumber exsits.
		        done = done && !Rslt.next();
					if (done) {
						Statement st2 = con.createStatement();
					    sql = "INSERT INTO CheckingAccount(accountNumber, CustomerName, Balance, CustomerID) VALUES ('"+accountNumber+ "','"+userName+"','"+Balance+"','"+userId+"')"; //Save the username, password and Name
					    st2.executeUpdate(sql);
					    bal = Balance;
				    }

			    st.close();
			    ToDB.closeConn();
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
	
	public boolean is_CheckingAccount_exist() {
		
		boolean Acc_no = true;
	
		try{
			DBConnection ToDB = new DBConnection();
			Connection con = ToDB.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT accountNumber FROM CheckingAccount WHERE accountNumber ='"+accountNumber+"'"; //SQL query command
			ResultSet Rslt = st.executeQuery(sql);
		     
				if (Rslt.next()) {
					Acc_no = true;
			    }
				else {
					Acc_no = false;
				}
			    st.close();
			    ToDB.closeConn();

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


	public double deposit_to_CheckingAccount(double amount){

			double r_amount = -100;
			boolean done;
						try{

							DBConnection ToDB = new DBConnection();
							Connection con = ToDB.getConnection();
							Statement st = con.createStatement();
							String sql = "SELECT accountNumber, Balance FROM CheckingAccount WHERE accountNumber ='"+accountNumber+"'"; //SQL query command
							ResultSet Rslt = st.executeQuery(sql);
					        done = Rslt.next();
								if (done) {
									double bal = Rslt.getDouble("Balance");
									double New_bal = bal + amount;
								    sql = "UPDATE CheckingAccount SET Balance = '"+New_bal+"' WHERE accountNumber='"+accountNumber+"'";
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

	public double withdraw_from_CheckingAccount(double amount){

			double r_amount = -100;
			boolean done;
						try{

								DBConnection ToDB = new DBConnection();
								Connection con = ToDB.getConnection();
								Statement st = con.createStatement();
								String sql = "SELECT accountNumber, Balance FROM CheckingAccount WHERE accountNumber ='"+accountNumber+"'"; //SQL query command
								ResultSet Rslt = st.executeQuery(sql);
						        done = Rslt.next();
									if (done) {
										double bal = Rslt.getDouble("Balance");
											if(bal>amount){
												double New_bal = bal - amount;
											    sql = "UPDATE CheckingAccount SET Balance = '"+New_bal+"' WHERE accountNumber='"+accountNumber+"'";
											    st.executeUpdate(sql);
											    r_amount = New_bal;
											}
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

	public double ViewCheckingBalance(){
		double balance = -100;
		boolean done;

		try{
			DBConnection ToDB = new DBConnection();
			Connection con = ToDB.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT Balance FROM CheckingAccount WHERE accountNumber ='"+accountNumber+"'"; //SQL query command
			ResultSet Rslt = st.executeQuery(sql);
		    done = Rslt.next();
				if (done) {
					balance = Rslt.getDouble("Balance");
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
		return balance;
	}

	public Vector getCAccounts(){
			Vector accounts = new Vector();

			try{
				DBConnection ToDB = new DBConnection();
				Connection con = ToDB.getConnection();
				Statement st = con.createStatement();
				String sql = "SELECT  accountNumber FROM account WHERE userName ='"+userName+"'"; //SQL query command
				ResultSet Rslt = st.executeQuery(sql);

					while (Rslt.next()) {
						int ac_no = Rslt.getInt("accountNumber");
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

	/*public static void main (String args []){
	}*/
}