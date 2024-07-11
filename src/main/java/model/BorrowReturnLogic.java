package model;
import java.time.LocalDateTime;

import dao.BorrowReturnMysqlDAO;
public class BorrowReturnLogic {
	public MedicalEquipmentResult BorrowExecute(LocalDateTime BorrowDate, int meNO, int department) {
		BorrowDate borrowdays = new BorrowDate(BorrowDate);
		MedicalEquipment medicalEquipment = new MedicalEquipment(meNO);
		Place place = new Place(department);
		BorrowReturnMysqlDAO dao = new BorrowReturnMysqlDAO();
		return dao.BorrowCreate(borrowdays, medicalEquipment, place);
	}
	public  MedicalEquipmentResult ReturnExecute(int meNO, LocalDateTime ReturnDate) {
		ReturnDate returndays = new ReturnDate(ReturnDate);
		MedicalEquipment medicalEquipment = new MedicalEquipment(meNO);
		BorrowReturnMysqlDAO dao = new BorrowReturnMysqlDAO();
		return dao.ReturnCreate(medicalEquipment,returndays);
	}
	public MedicalEquipmentResult getMedicalEquipmentByMeNo(int meNO){
		MedicalEquipment medicalEquipment = new MedicalEquipment(meNO);
		BorrowReturnMysqlDAO dao = new BorrowReturnMysqlDAO();
		return dao.findMedicalEquipmentByMeNo(medicalEquipment);
	}
	public boolean execute(Login login) {
		BorrowReturnMysqlDAO dao = new BorrowReturnMysqlDAO();
		Account account = dao.findByLogin(login);
		return account != null;
	}
	public MedicalEquipmentResult EnrollEcecute(int meNO, String modelNumber, String serialNumber, String manufacturer, LocalDateTime introducedDate,int itemId) {
		MedicalEquipment enrollMedicalEquipment = new MedicalEquipment(meNO,modelNumber,serialNumber, manufacturer, introducedDate,itemId);
		BorrowReturnMysqlDAO dao = new BorrowReturnMysqlDAO();
		return dao.MedicalEquipmentEnroll(enrollMedicalEquipment);
	}
	public MedicalEquipmentResult getFindByItemName(String itemName) {
		EquipmentQueryForm finditemName = new EquipmentQueryForm(itemName);
		BorrowReturnMysqlDAO dao = new BorrowReturnMysqlDAO();
		return dao.findByItemName(finditemName);
	}
}




