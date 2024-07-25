package hotalhomepage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbprovider.DataBaseFile;

/**
 * Servlet implementation class Removeguest
 */
public class Removeguest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Removeguest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DataBaseFile.getJdbcConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("username");
		String query = "delete from guest_details where Guest_name= ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			int rowaffected = pstmt.executeUpdate();
			
			if(rowaffected > 0) {
				RequestDispatcher disp = request.getRequestDispatcher("Home.html");
				response.getWriter().println("<h3>deleted Successfully... </h3>");
				disp.include(request, response);
			}
			else {
				RequestDispatcher disp = request.getRequestDispatcher("Home.html");
				response.getWriter().println("<h3>Guest not presented... </h3>");
				disp.include(request, response);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
