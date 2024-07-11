package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BorrowReturnLogic;
import model.MedicalEquipmentResult;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String medicalEquipmentValue = request.getParameter("medicalEquiment");
		String modelNumber = request.getParameter("modelNumber");
		String serialNumber = request.getParameter("serialNumber");
		String manufacturer = request.getParameter("manufacturer");
		String datetimeValue = request.getParameter("introduced-time");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		String ItemId = request.getParameter("itemId");
		LocalDateTime introducedDate = LocalDateTime.parse(datetimeValue, fmt);
		int meNO = Integer.parseInt(medicalEquipmentValue);
		int itemId = Integer.parseInt(ItemId);
		BorrowReturnLogic bo = new BorrowReturnLogic();
		MedicalEquipmentResult reslutEnroll = bo.EnrollEcecute(meNO, modelNumber, serialNumber, manufacturer, introducedDate, itemId);
		if (reslutEnroll.isSuccess()) {
			String Message = reslutEnroll.getErrorMessage();
			request.setAttribute("Message",Message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/EnrollDone.jsp");
			dispatcher.forward(request, response);
		}else {
			String errorMessage = reslutEnroll.getErrorMessage();
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ErrorMessage.jsp");
			dispatcher.forward(request, response);
		}
	}
}