package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import dao.AccountDAO;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String showPage = "search.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		try {
			String searchValue = request.getParameter("txtSearchValue");

			AccountDAO dao = new AccountDAO();
			List<Account> result = dao.searchLastName(searchValue);
			
			request.setAttribute("SEARCHRESULT", result);
			RequestDispatcher rd = request.getRequestDispatcher(showPage);
			rd.forward(request, response);
		} catch (SQLException e) {
			e.getMessage();
		} catch (NamingException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF=8");
		try {
			String searchValue = request.getParameter("txtSearchValue");

			AccountDAO dao = new AccountDAO();
			List<Account> result = dao.searchLastName(searchValue);

//			in ra result
//			for (Account a: result) {
//				System.out.println(a.getUsername() + ":" + a.getPassword() + ":" + a.getLastname() + ":" +a.isRole());
//			}

			request.setAttribute("SEARCHRESULT", result);
			RequestDispatcher rd = request.getRequestDispatcher(showPage);
			rd.forward(request, response);

		} catch (SQLException e) {
			e.getMessage();
		} catch (NamingException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
