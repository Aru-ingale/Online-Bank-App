package com.bankapp.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private Connection connection;
	private String URL;

	public DBConnection() {
		// URL = "jdbc:odbc:JavaClass";
		URL = "jdbc:mysql://localhost:3306/mydatabase\",\"root\",\"password";
		connection = null;

	}

	public Connection openConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "password");
			// ";
		} catch (Exception e) {
			System.out.println("DB error" + e.getMessage());
		}
		return connection;
	}

	public void closeConn() {
		try {
			connection.close();
		} catch (Exception e) {
			System.out.println("DB connection close error"+ e.getMessage());
			System.err.println("Can't close the database connection.");
		}
	}

	/*public String insert( ServletConfig config )throws ServletException{
		       String result = null;
		     Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = openConn();
		result = "Data entered successfully";
		String sql = "insert into users(PREFIX,FUSER,MUSER,LUSER,USERNAME,MOBILENUMBER,BIRTHDATE,EMAIL,GENDER,PASSWORD,ADDRESS,STATE,CITY,ZIPCODE,MARITALSTATUS,OCCUPATION) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;

		ps = conn.prepareStatement(sql);
		ps.setString(1, config.getPREFIX());
		ps.setString(2, config.getFUSER());
		ps.setString(3, me.getMUSER());
		ps.setString(4, me.getLUSER());
		ps.setString(5, me.getUSERNAME());
		ps.setString(6, me.getMOBILENUMBER());
		ps.setString(7, me.getBIRTHDATE());
		ps.setString(8, me.getEMAIL());
		ps.setString(9, me.getGENDER());
		ps.setString(10, me.getPASSWORD());
		ps.setString(11, me.getADDRESS());
		ps.setString(12, me.getSTATE());
		ps.setString(13, me.getCITY());
		ps.setString(14, me.getZIPCODE());
		ps.setString(15, me.getMARITALSTATUS());
		ps.setString(16, me.getOCCUPATION());
		ps.executeUpdate();

	
	  public Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws
	  SQLException { Vector currentRow = new Vector();
	  
	  for(int i=1;i<=rsmd.getColumnCount();i++) switch(rsmd.getColumnType(i)) {
	  case Types.VARCHAR: case Types.LONGVARCHAR:
	  currentRow.addElement(rs.getString(i)); break; case Types.INTEGER:
	  currentRow.addElement(new Long(rs.getLong(i))); break; case Types.DOUBLE:
	  currentRow.addElement(new Double(rs.getDouble(i))); break; case Types.FLOAT:
	  currentRow.addElement(new Float(rs.getFloat(i))); break; default:
	  System.out.println("Type was: "+ rsmd.getColumnTypeName(i)); }
	  
	  return currentRow; }
	 
}*/
}