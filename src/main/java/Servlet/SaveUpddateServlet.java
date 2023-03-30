package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.AccountDAO;


public class SaveUpddateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("button");
		String lastSearchValue = request.getParameter("lastSearchvalue");
		
		String url = "updateErr";
		if (button.equals("Save")) {
			String username = request.getParameter("txtUsername");
			String password = request.getParameter("txtPasswword");
			String lastname = request.getParameter("txtLastname");
			String admin = request.getParameter("checkAdmin");
			
			try {
				boolean role = false;
				if (admin != null) {
					role = true;
				}
				AccountDAO dao = new AccountDAO();
				boolean result = dao.upodateRecord(username, password, lastname, role);
				if (result) {
					System.out.println("Result UPDATE " + result);
					System.out.println("LastSearchValue: " + lastSearchValue);
					url = "SearchServlet?txtSearchValue=" + lastSearchValue;
				}
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			url = "SearchServlet?txtSearchValue=" + lastSearchValue;
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
