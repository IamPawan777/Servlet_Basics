package hotalregistration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbprovider.DataBaseFile;

public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

//    String DBURL = "jdbc:mysql://localhost:3306/Servlet_Hotel_Management";
//    String DBUSER = "root";
//    String DBPASSWORD = "IamPawan";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("get name: "+username);
		System.out.println("Email: "+email);
		System.out.println("Pass: "+password);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DataBaseFile.getJdbcConnection();
		PreparedStatement pstmt = null;
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String query = "insert into authentication(name, email, password) values(?,?,?)";
//		System.out.println("post name: "+username);
//		System.out.println("Email: "+email);
//		System.out.println("Pass: "+password);
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, email);
				pstmt.setString(3, password);
				
				int added = pstmt.executeUpdate();
				
				response.setContentType("text/html");
				
				if(added > 0) {
//					System.out.println("post name: ");
					RequestDispatcher disp = request.getRequestDispatcher("registration.html");
					response.getWriter().println("<h3>Register Successfully... </h3>");
					disp.include(request, response);
				}
				else {
					response.getWriter().append("not DB add..");
//					System.out.println("post");
				}
			} 
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			finally {
				try {
					DataBaseFile.closeResourse(con, pstmt);
//					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
