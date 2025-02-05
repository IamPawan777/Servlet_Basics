package hotalhomepage;

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


public class Viewguest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Viewguest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DataBaseFile.getJdbcConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		String query = "Select * from guest_details";
		
		try {
			pstmt = con.prepareStatement(query);
			result = pstmt.executeQuery();
			
//			if(result.next()) {
//				response.sendRedirect("viewAll.html");
//			}
//			else {
//				response.getWriter().append("again view");
//			}
			
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			pw.println("<table border='2'>");
			   	pw.println("<tr>");
			   	pw.println("<th>");
			   		pw.println("ID");
				pw.println("</th>");
				pw.println("<th>");
					pw.println("Name");
				pw.println("</th>");			
				pw.println("<th>");
					pw.println("Age");
				pw.println("</th>");			
				pw.println("<th>");
					pw.println("Mobile");
				pw.println("</th>");			
				pw.println("<th>");
					pw.println("Room No.");
				pw.println("</th>");			
				pw.println("<th>");
					pw.println("Date");
				pw.println("</th>");
				pw.println("</tr>");
				
				while(result.next()) {
					pw.println("<tr>");
					pw.println("<td>");
						pw.println(result.getInt(1));
					pw.println("</td>");
					pw.println("<td>");
						pw.println(result.getString(2));
					pw.println("</td>");			
					pw.println("<td>");
						pw.println(result.getInt(3));
					pw.println("</td>");			
					pw.println("<td>");
						pw.println(result.getString(4));
					pw.println("</td>");			
					pw.println("<td>");
						pw.println(result.getInt(5));
					pw.println("</td>");			
					pw.println("<td>");
						pw.println(result.getDate(6));
					pw.println("</td>");
					pw.println("</tr>");
				}					
			pw.println("</table>");
			
		} catch (SQLException e) {
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
