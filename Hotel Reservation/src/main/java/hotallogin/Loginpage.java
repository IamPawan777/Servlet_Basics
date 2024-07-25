package hotallogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbprovider.DataBaseFile;

public class Loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("Email: "+email);
		System.out.println("Pass: "+password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Connection con = DataBaseFile.getJdbcConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String query = "select * from authentication where email ='"+email+"'and password='"+password+"'";
		
		try {
			pstmt = con.prepareStatement(query);
			result = pstmt.executeQuery();
			
			if(result.next()) {
//				response.sendRedirect("Home.html");
				RequestDispatcher disp = request.getRequestDispatcher("Home.html");
				response.getWriter().println("<h3>Login Successfully...!   </h3>");
				disp.include(request, response);
			}
			else {		
				RequestDispatcher disp = request.getRequestDispatcher("index.html");
				response.getWriter().println("<h3>Wrong Cradential...!   </h3>");
				disp.include(request, response);
			}
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				DataBaseFile.closeResourse(con, pstmt);
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
