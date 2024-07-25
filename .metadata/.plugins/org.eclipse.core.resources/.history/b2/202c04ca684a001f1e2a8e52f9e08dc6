package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pawan")	
public class Testing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_name = request.getParameter("username");
		String pass = request.getParameter("password");
//		response.getWriter().append("Testing doget method is calling: User= "+u_name+" || Password="+pass);		// 1. take from html(client) -> servlet(server) -> html(client)
		
//		RequestDispatcher disp = request.getRequestDispatcher("Communication");        	//2. for internal server (server to server)
//		disp.forward(request, response);
		
		
//		response.sendRedirect("https://translate.google.co.in/details?sl=en&tl=hi&text=subservient&op=translate");	//3. for external server (server to server)							// for extranal server
//		response.sendRedirect("Communication?data1="+u_name+"&data2="+pass);		//	 3. url parameter	
		
		request.setAttribute("data1", u_name+pass);							// 4.. request attribute
		request.setAttribute("data2", pass);
		request.getRequestDispatcher("Communication").forward(request, response);        	// for internal server

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_name = request.getParameter("username");
		String pass = request.getParameter("password");
		response.getWriter().append("Testing doPost method is calling: User= "+u_name+" Password="+pass);
	}

}
