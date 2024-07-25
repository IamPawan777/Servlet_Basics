package servletClass;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/firstServletClass")
public class FirstServletClass implements Servlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("int class");
	}

	public void destroy() {
		System.out.println("destroy class");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null; 
	}


	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Service class");
	}

}
