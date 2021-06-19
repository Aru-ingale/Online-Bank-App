package com.bankapp.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

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
	
	public String generateRandomPassword(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
          +"lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	public boolean signUp(User user) {
		
		boolean flag = !user.getUserName().equals("") && !user.getPassword().equals("");
		try {
		    if (flag) {
		        DBConnection conn = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = conn.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT user_name FROM Account WHERE user_name ='"+user.getUserName()+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        flag = flag && !Rslt.next();
		        if (flag) {
				    SQL_Command = "INSERT INTO Account VALUES ('"+user.getSalutation()+"','1234'','"+user.getFname()+"',"
				    		+ "'"+user.getMname()+"','"+user.getLname()+"','"+user.getUserName()+"','"+user.getPhone()+"','customer'"
				    				+ ",'"+user.getDob()+"','"+user.getGender()+"','"+user.getAddress()+"','"+user.getState()+"'"
				    						+ ",'"+user.getCity()+"','"+user.getZip()+"','"+user.getPassword()+"','"+user.getMaritalStatus()+"','"+user.getEmail()+"','1234','"+user.getOccupation()+"','"+generateRandomPassword(5)+"','pending',curdate(),curdate())"; //Save the username, password and Name
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
	}

	/*
	 * SignIn method will check user's credential and allow user to LogIn to their
	 * account.
	 */

	public String signIn(User user) {
		String Name = "";
		boolean done = !user.getUserName().equals("") && !user.getPassword().equals("");
		try {
			if (done) {
				DBConnection db = new DBConnection();
				Connection con = db.openConn();
				Statement st = con.createStatement();
				String query = "SELECT Name FROM Account WHERE Username = '" + user.getUserName() + "' AND Password = '"
						+ user.getPassword() + "'";
				ResultSet rs = st.executeQuery(query);
				done = done && rs.next();
				if (done) {
					Name = rs.getString("Name");
					System.out.println("LogIn Successful!");
				}
				st.close();
				con.close();
			}
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
		return Name;

	}

	/*
	 * public boolean changePassword(String NewPassword) { //5 boolean done = false;
	 * try { //20 DBConnection ToDB = new DBConnection(); //Have a connection to the
	 * DB Connection DBConn = ToDB.openConn(); Statement Stmt =
	 * DBConn.createStatement(); String SQL_Command =
	 * "SELECT * FROM Account WHERE Username ='"+this.Username+
	 * "'AND Password ='"+this.Password+"'"; //SQL query command ResultSet Rslt =
	 * Stmt.executeQuery(SQL_Command); //Inquire if the username exsits. if
	 * (Rslt.next()) { SQL_Command =
	 * "UPDATE Account SET Password='"+NewPassword+"' WHERE Username ='"+this.
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