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
import java.sql.SQLException;

import dbprovider.DataBaseFile;

public class Addguest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Addguest() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DataBaseFile.getJdbcConnection();
		PreparedStatement pstmt = null;
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("username");
		String ageString = request.getParameter("age");
		int ageInt = Integer.parseInt(ageString);
		String mobile = request.getParameter("mobile");
		String roomString = request.getParameter("room");
		int roomInt = Integer.parseInt(roomString);
		String date = request.getParameter("date");
		
		String query = "insert into guest_details(Guest_name, age, Mobile_no, room_number, register_time) value(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setInt(2, ageInt);
			pstmt.setString(3, mobile);
			pstmt.setInt(4, roomInt);
			pstmt.setString(5, date);
			
			int rowaffected = pstmt.executeUpdate();
			if(rowaffected > 0) {
				RequestDispatcher disp = request.getRequestDispatcher("Home.html");
				response.getWriter().println("<h3>Inserted successfully... </h3>");
				disp.include(request, response);
			}
			else {
				RequestDispatcher disp = request.getRequestDispatcher("addGuest.html");
				response.getWriter().println("<h3>Not Inserted... </h3>");
				disp.include(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				DataBaseFile.closeResourse(con, pstmt);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
