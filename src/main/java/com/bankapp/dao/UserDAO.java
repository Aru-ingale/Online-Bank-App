package com.bankapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapp.models.UserDetails;
import com.bankapp.models.Users;
import com.bankapp.util.BankUtil;

public class UserDAO {

	public UserDetails signIn(Users user) {
		UserDetails dbUser = new UserDetails();

		boolean done = !user.getUserName().equals("") && !user.getPassword().equals("");
		try {
			if (done) {
				Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				String query = "select fname,mname,lname from users where userId = (SELECT userid FROM login_details WHERE userName = '" + user.getUserName()
						+ "' AND Password = '" + user.getPassword() + "')";
				ResultSet rs = st.executeQuery(query);
				done = done && rs.next();
				if (done) {
					dbUser.setFname(rs.getString("fname"));
					dbUser.setMname(rs.getString("mname"));
					dbUser.setLname(rs.getString("lname"));
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
		return dbUser;

	}

	public boolean signUp(UserDetails user) {

		// boolean flag = !user.getUserName().equals("") &&
		// !user.getPassword().equals("");
		
		boolean flag = true;
		try {
			// if (flag) {
			DBConnection conn = new DBConnection(); // Have a connection to the DB
			Connection DBConn = conn.getConnection();
			Statement Stmt = DBConn.createStatement();
			int userId = 0;	
			String SQL_Command = "SELECT userName FROM login_details WHERE userName ='" + user.getUserName() + "'"; // SQL query
																											// command
			ResultSet Rslt = Stmt.executeQuery(SQL_Command); // Inquire if the username exsits.
			flag = flag && !Rslt.next();
			if (flag) {
				SQL_Command = "INSERT INTO login_details (username,password) values('"+user.getUserName()+"','"+user.getPassword()+"')";
				Stmt.executeUpdate(SQL_Command);
				
				SQL_Command = "select userid from login_details where userName = '" + user.getUserName() + "'";
				ResultSet result = Stmt.executeQuery(SQL_Command);
				while(result.next()) {
					userId = result.getInt("userId");
				}
				SQL_Command = "INSERT INTO users VALUES ('"+userId+"','"+user.getSalutation()+"','"+user.getFname()+"',"
			    		+ "'"+user.getMname()+"','"+user.getLname()+"','"+user.getPhone()+"','customer'"
			    				+ ",'"+user.getDob()+"','"+user.getGender()+"','"+user.getAddress()+"','"+user.getState()+"'"
			    						+ ",'"+user.getCity()+"','"+user.getZip()+"','"+user.getMaritalStatus()+"','"+user.getEmail()+"','"+user.getOccupation()+"','"+BankUtil.generateRandomPassword(5)+"','pending',curdate(),curdate())"; 
			    																							
				Stmt.executeUpdate(SQL_Command);
			}
			Stmt.close();
			conn.closeConn();
			// }
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
			e.printStackTrace();
		}
		return flag;
	}

}
