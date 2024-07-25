package secondPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Communication
 */
public class Communication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Communication() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String u_name = request.getParameter("data1");
//		String pass = request.getParameter("data2");
//		
		String u_name = (String) request.getAttribute("data1");
		String pass = (String) request.getAttribute("data2");

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.append("doGet commnication servlet: User= "+u_name+" || Password="+pass);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_name = request.getParameter("username");
		String pass = request.getParameter("password");
		response.getWriter().append("doPost commnication servlet: User= "+u_name+" || Password="+pass);
	}

}
