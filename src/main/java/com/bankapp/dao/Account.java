package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.bankapp.models.UserDetails;
import com.bankapp.models.Users;
import com.bankapp.util.BankUtil;

public class Account {
	/*
	 * private String Username, Password, Password1, Name;
	 * 
	 * public Account(String UN, String PassW, String PassW1, String NM) {
	 * this.Username = UN; this.Password = PassW; this.Password1 = PassW1; this.Name
	 * = NM; }
	 * 
	 * public Account(String UN, String PassW) { this.Username = UN; this.Password =
	 * PassW; }
	 * 
	 * public String getUsername(){ return this.Username; }
	 */

	public Account() {

	}
	
	

/*public String loanApplication(UserDetails user) {
	String result = null;
		try {
		        Connection conn = DBConnection.getConnection();
		        //Statement Stmt = conn.createStatement();
		        String maxAccountNumber = "SELECT accountnumber FROM account ORDER BY accountnumber DESC LIMIT 1";
		        ResultSet result= Stmt.executeQuery(maxAccountNumber);
		        String accountNumber = "";
		        while(result.next()) {
		        	accountNumber = BankUtil.generateBankAccountNumber(result.getString("accountnumber"));
		        }
		        String sql = "insert into loandetails(FULLNAME,OCCUPATION,BIRTHDATE,MOBILENUMBER,ADDRESS,AADHARNUMBER,INCOME,LOANAMMOUNT,EMAIL) value(?,?,?,?,?,?,?,?,?)";
		        PreparedStatement ps;

				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getFullName());
				ps.setString(2, user.getOccupation());
				ps.setString(3, user.getDob());
				ps.setString(4, user.getPhone());
				ps.setString(5, user.getAddress());
				ps.setString(6, user.getAadharNumber());
				ps.setString(7, user.getIncome());
				ps.setString(8, user.getLoanAmmount());
				ps.setString(9, user.getEmail());
				ps.executeUpdate();
		        
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Data not entered";
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
}*/
		        
		       /* ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        flag = flag && !Rslt.next();
		        if (flag) {
				    SQL_Command = "INSERT INTO loandetails VALUES ('"+user.getFullName()+"','"+user.getAddress()+"','"+BankUtil.generateUserID()+"','"+user.getPropertyAddress()+"',"
				    		+ "'"+user.getPhone()+"','"+user.getDob()+"','"+user.getAadharNumber()+"','"+user.getEmail()+"','customer'"
				    				+ ",'"+user.getLoanAmmount()+"','"+user.getOccupation()+"','"+user.getIncome()+"','pending',curdate(),curdate())"; //Save the username, password and Name
				    Stmt.executeUpdate(SQL_Command);
			    }
			    Stmt.close();
			    conn.closeConn();
			}
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
	}*/
	public boolean createAccount(UserDetails user) {
		
		//boolean flag = !user.getUserName().equals("") && !user.getPassword().equals("");
		boolean flag = false;
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
		        /*String SQL_Command = "SELECT AccountNumber FROM users WHERE userName ='"+user.getUserName()+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        flag = flag && !Rslt.next();
		        if (flag) {*/
		        /*String  SQL_Command = "INSER INTO users VALUES ('"+user.getSalutation()+"','"+user.getAccountType()+"','"+BankUtil.generateUserID()+"','"+user.getFname()+"',"
				    		+ "'"+user.getMname()+"','"+user.getLname()+"','"+user.getAmount()+"','"+user.getPhone()+"','customer'"
				    				+ ",'"+user.getDob()+"','"+user.getGender()+"','"+user.getAddress()+"','"+user.getState()+"'"
				    						+ ",'"+user.getCity()+"','"+user.getZip()+"','"+user.getMaritalStatus()+"','"+user.getEmail()+"','"+accountNumber+"','"+user.getOccupation()+"','"+generateRandomPassword(5)+"','pending',curdate(),curdate())"; //Save the username, password and Name
				 */  
				    Stmt.executeUpdate("");
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
	


	/*
	 * SignIn method will check user's credential and allow user to LogIn to their
	 * account.
	 */

	

	/*
	 * public boolean changePassword(String NewPassword) { //5 boolean done = false;
	 * try { //20 DBConnection ToDB = new DBConnection(); //Have a connection to the
	 * DB Connection DBConn = ToDB.openConn(); Statement Stmt =
	 * DBConn.createStatement(); String SQL_Command =
	 * "SELECT * FROM USERS WHERE UserName ='"+this.Username+
	 * "'AND Password ='"+this.Password+"'"; //SQL query command ResultSet Result =
	 * Stmt.executeQuery(SQL_Command); //Inquire if the username exsits. if
	 * (Rslt.next()) { SQL_Command =
	 * "UPDATE users SET Password='"+NewPassword+"' WHERE Username ='"+this.
	 * Username+"'"; //Save the username, password and Name
	 * Stmt.executeUpdate(SQL_Command); Stmt.close(); ToDB.closeConn(); done=true; }
	 * } catch(java.sql.SQLException e) //5 { done = false;
	 * System.out.println("SQLException: " + e); while (e != null) {
	 * System.out.println("SQLState: " + e.getSQLState());
	 * System.out.println("Message: " + e.getMessage());
	 * System.out.println("Vendor: " + e.getErrorCode()); e = e.getNextException();
	 * System.out.println(""); } } catch (java.lang.Exception e) { done = false;
	 * System.out.println("Exception: " + e); e.printStackTrace (); } return done; }
	 */
}