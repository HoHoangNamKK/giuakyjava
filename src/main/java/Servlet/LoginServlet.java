package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import dao.AccountDAO;

@WebServlet("LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String invalidPage = "invalid.jsp", searchPage = "search.jsp";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		
		AccountDAO dao = new AccountDAO();
		try {
			boolean result = dao.checkLogin(username, password);
			System.out.print("Result: " + result);
			String url = invalidPage;
			if (result)
			{
				url = searchPage;
				HttpSession session = request.getSession();
				session.setAttribute("USER", username);
			}
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
		} catch (SQLException ex) {
			log("LoginServlet_SQL: " + ex.getMessage());
		} catch (Exception ex) {
			log("Exception: " + ex.getMessage());
		}
	}

}
