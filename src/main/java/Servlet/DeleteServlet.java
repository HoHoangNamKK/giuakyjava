package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.AccountDAO;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String lastSearchValue = request.getParameter("lastSearchvalue");
		
//		hien ra kt
//		String.out.println("--------------------------------------");
//		System.out.println("Username: " + username);
//		System.out.println("LastSearchValue: " + lastSearchValue);
		
		AccountDAO dao = new AccountDAO();
		boolean result;
		try {
			result = dao.deleteRecord(username);
			String url = "deleteErr";
			if (result) {
				url = "SearchServlet?txtSearchValue=" + lastSearchValue;
			}
			response.sendRedirect(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
