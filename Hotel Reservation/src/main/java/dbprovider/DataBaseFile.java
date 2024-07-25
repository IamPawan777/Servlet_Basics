package dbprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseFile {
	static final String DBURL = "jdbc:mysql://localhost:3306/Servlet_Hotel_Management";
	static final String DBUSER = "root";
	static final String DBPASSWORD = "IamPawan";
	 
	 
	 public static Connection getJdbcConnection() {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
		 
	 }
	 
	 public static void closeResourse(Connection con,  PreparedStatement pstmt) throws SQLException  {
//			if(connection != null) {
				con.close();
				pstmt.close();
//			}
		}
	 
}
