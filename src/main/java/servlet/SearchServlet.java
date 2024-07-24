package servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BorrowReturnLogic;
import model.MedicalEquipment;
import model.MedicalEquipmentResult;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formType = request.getParameter("formType");
		if("medicalEquipmentForm".equals(formType)) {
			String medicalEquipmentValue = request.getParameter("medicalEquipment");
			if(medicalEquipmentValue == null || medicalEquipmentValue.isEmpty()){
				String errorMessage = "4桁番号を入力してください";
				request.setAttribute("errorMessage", errorMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ErrorMessage.jsp");
				dispatcher.forward(request, response);
			}
			int meNO = Integer.parseInt(medicalEquipmentValue);
			BorrowReturnLogic bo = new BorrowReturnLogic();
			MedicalEquipmentResult medicalEquipmentResultValue = bo.getMedicalEquipmentByMeNo(meNO);
			String imageFileName;
			if(medicalEquipmentResultValue.isSuccess()) {
				MedicalEquipment medicalEquipment  = medicalEquipmentResultValue.getEquipment();
				if ("JM-OT707".equals(medicalEquipment.getModelNumber())) {
					imageFileName = "/BiomBorrow/images/OT-707.jpeg";;
				}else if("JM-OT808".equals(medicalEquipment.getModelNumber())){
					imageFileName = "/BiomBorrow/images/OT-808.jpeg";
				}else if("JM-OT808P".equals(medicalEquipment.getModelNumber())){
					imageFileName = "/BiomBorrow/images/OT-808.jpeg";
				}else {
					imageFileName = "/BiomBorrow/images/default.jpg";
				}
				HttpSession session = request.getSession();
				session.setAttribute("medicalEquipmentValue",medicalEquipment);
				session.setAttribute("imageFileName",imageFileName);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/SearchResult.jsp");
				dispatcher.forward(request, response);
			}else{
				String errorMessage = medicalEquipmentResultValue.getErrorMessage();
				request.setAttribute("errorMessage", errorMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ErrorMessage.jsp");
				dispatcher.forward(request, response);
			}
		}else if("itemNameForm".equals(formType)) {
			String itemName = request.getParameter("itemName");
			if(itemName == null || itemName.isEmpty()){
				String errorMessage = "機器が選択されていません";
				request.setAttribute("errorMessage", errorMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ErrorMessage.jsp");
				dispatcher.forward(request, response);
			}
			BorrowReturnLogic bo = new BorrowReturnLogic();
			MedicalEquipmentResult equipmentItems = bo.getFindByItemName(itemName);
			if(equipmentItems.isEquipmentsSuccess()) {
				ArrayList <MedicalEquipment> equipments = equipmentItems.getEquipments();
				HttpSession session = request.getSession();
				session.setAttribute("equipments",equipments);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/UsageStatus.jsp");
				dispatcher.forward(request, response);
			}else {
				String errorMessage =  equipmentItems.getErrorMessage();
				request.setAttribute("errorMessage", errorMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ErrorMessage.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
