 package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BorrowReturnLogic;
import model.Login;

/**
 * Servlet implementation class BiomBorrowLoginServlet
 */
@WebServlet("/BiomBorrowLoginServlet")
public class BiomBorrowLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BiomBorrowLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}
	// TODO Auto-generated method stub


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		Login login = new Login(userId, pass);
		BorrowReturnLogic bo = new BorrowReturnLogic();
		boolean result = bo.execute(login);
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/WelcomeBiomBorrow.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("BiomBorrowLoginServlet");
		}

	}

}
