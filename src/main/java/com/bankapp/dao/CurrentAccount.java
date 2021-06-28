package com.bankapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CurrentAccount {

	public CurrentAccount() {

	}

	public boolean is_CurrentAccount_exist(String accountNumber, String accountType) {

		boolean Acc_no = true;

		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT accountNumber FROM account WHERE accountNumber ='" + accountNumber
					+ "' and accountType = '" + accountType + "'"; // SQL query command
			ResultSet Rslt = st.executeQuery(sql);

			if (Rslt.next()) {
				Acc_no = true;
			} else {
				Acc_no = false;
			}
			st.close();
			DBConnection.closeConn();

		} catch (java.sql.SQLException e) {

			System.out.println("SQLException: " + e);
			while (e != null) {
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("Message: " + e.getMessage());
				System.out.println("Vendor: " + e.getErrorCode());
				e = e.getNextException();
				System.out.println("");
			}
		} catch (java.lang.Exception e) {

			System.out.println("Exception: " + e);
			e.printStackTrace();
		}

		return Acc_no;
	}

	public double deposit_to_CurrentAccount(double amount, String accountNumber) {

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
	
	public double withdraw_from_CurrentAccount(double amount, String accountNumber){

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

}
