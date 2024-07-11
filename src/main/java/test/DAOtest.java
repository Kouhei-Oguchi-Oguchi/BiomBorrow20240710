package test;
import java.time.LocalDateTime;
import java.util.Scanner;

import dao.BorrowReturnMysqlDAO;
import model.Account;
import model.BorrowDate;
import model.BorrowReturnID;
import model.EquipmentQueryForm;
import model.Login;
import model.MedicalEquipment;
import model.MedicalEquipmentResult;
import model.Place;
import model.ReturnDate;
public class DAOtest {
	public static void main (String[] args) {
		//testBorrowCreate();
		//testReturnDateCreate();
		//testBorrowReturnDateCreateNG();
		//testBorrowReturnDateCreateDuplicate();
		//EquipmentInformation();
		//testEquipmentEnrollOK();
		//testEquipmentEnrollNG() ;
		//testEquipmentEnrollSerialUNIkey();
		//tsetFindByLoginOK();
		//tsetFindByLoginNG();
		//testFindItemOK();
		//testFindItemNG();
	}
	public static void testBorrowCreate() {
		LocalDateTime BorrowTest = LocalDateTime.of(2023, 12, 12, 0, 0);
		BorrowDate borrowdate = new BorrowDate(BorrowTest);
		System.out.println("MENO入力");
		Scanner scanner = new Scanner (System.in);
		int meNO = scanner.nextInt();
		MedicalEquipment medicalEquipment = new MedicalEquipment(meNO);
		Place place = new Place(1);
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		BorrowReturnID borrowreturnID = new BorrowReturnID();
		MedicalEquipmentResult result = borrowreturnDAO.BorrowCreate(borrowdate, medicalEquipment, place);
		result.toString();
		System.out.println(result);
	}
	public static void testReturnDateCreate() {
		LocalDateTime BorrowTset = LocalDateTime.of(2023, 1, 1, 0, 0);
		BorrowDate borrowdate = new BorrowDate(BorrowTset);
		MedicalEquipment borrowmedicalEquipment = new MedicalEquipment(1005);
		Place borrowPlace = new Place(1);
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		MedicalEquipmentResult borrowDateMessage = borrowreturnDAO.BorrowCreate(borrowdate, borrowmedicalEquipment, borrowPlace);
		borrowDateMessage.toString();
		System.out.println(borrowDateMessage);
		LocalDateTime ReturnTest = LocalDateTime.of(2023, 1, 2, 0, 0);
		ReturnDate returndate = new ReturnDate(ReturnTest);
		MedicalEquipmentResult returnDateMessage = borrowreturnDAO.ReturnCreate(borrowmedicalEquipment, returndate);
		System.out.println(returnDateMessage);
	}
	public static void testBorrowReturnDateCreateNG() {
		LocalDateTime BorrowTset = LocalDateTime.of(2023, 1, 1, 0, 0);
		BorrowDate borrowdate = new BorrowDate(BorrowTset);
		MedicalEquipment borrowmedicalEquipment = new MedicalEquipment(1005);
		Place borrowPlace = new Place(1);
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		MedicalEquipmentResult borrowDateMessage = borrowreturnDAO.BorrowCreate(borrowdate, borrowmedicalEquipment, borrowPlace);
		borrowDateMessage.toString();
		System.out.println(borrowDateMessage);
		LocalDateTime ReturnTest = LocalDateTime.of(2022, 12, 31, 0, 0);
		ReturnDate returndate = new ReturnDate(ReturnTest);
		MedicalEquipmentResult returnDateMessage = borrowreturnDAO.ReturnCreate(borrowmedicalEquipment, returndate);
		System.out.println(returnDateMessage);
	}
	public static void testBorrowReturnDateCreateDuplicate() {
		MedicalEquipment borrowmedicalEquipment = new MedicalEquipment(1011);
		LocalDateTime ReturnTest = LocalDateTime.of(2023, 1, 2, 0, 0);
		ReturnDate returndate = new ReturnDate(ReturnTest);
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		MedicalEquipmentResult returnDateMessage = borrowreturnDAO.ReturnCreate(borrowmedicalEquipment, returndate);
		returnDateMessage.toString();
		System.out.println(returnDateMessage);
	}
	public static void EquipmentInformation() {
		MedicalEquipment medicalEquipment = new MedicalEquipment(1000);
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		MedicalEquipmentResult fetchedEquipment = borrowreturnDAO.findMedicalEquipmentByMeNo(medicalEquipment);
		fetchedEquipment.toString();
		System.out.println(fetchedEquipment);
	}
	public static void testEquipmentEnrollOK() {
		LocalDateTime introducedTest = LocalDateTime.of(2023, 1, 1, 0, 0);
		MedicalEquipment medicalEquipment = new MedicalEquipment(1500,"test7", "test7", "test7", introducedTest, "a");
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		MedicalEquipmentResult enrollEquipment = borrowreturnDAO.MedicalEquipmentEnroll(medicalEquipment);
		enrollEquipment.toString();
		System.out.println(enrollEquipment);
	}
	public static void testEquipmentEnrollNG() {
		LocalDateTime introducedTest = LocalDateTime.of(2023, 1, 1, 0, 0);
		MedicalEquipment medicalEquipment = new MedicalEquipment(1000,"test8", "46853", "test8", introducedTest,1);
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		MedicalEquipmentResult enrollEquipment = borrowreturnDAO.MedicalEquipmentEnroll(medicalEquipment);
		enrollEquipment.toString();
		System.out.println(enrollEquipment);
	}
	public static void testEquipmentEnrollSerialUNIkey() {
		LocalDateTime introducedTest = LocalDateTime.of(2023, 1, 1, 0, 0);
		MedicalEquipment medicalEquipment = new MedicalEquipment(1600,"test7", "82016P", "test7", introducedTest,1);
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		MedicalEquipmentResult enrollEquipment = borrowreturnDAO.MedicalEquipmentEnroll(medicalEquipment);
		enrollEquipment.toString();
		System.out.println(enrollEquipment);
	}
	public static void tsetFindByLoginOK() {
		Login login = new Login("kouhei", "pskouhei");
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		Account result = borrowreturnDAO.findByLogin(login);
		if(result != null &&
		   result.getUserId().equals("kouhei") &&  
		   result.getPass().equals("pskouhei") &&
		   result.getInstitutionName().equals("seiwa") &&
		   result.getMail().equals("k9afh1143@gmail.com") ) {
           System.out.println("ログイン成功");
		} else {
			System.out.println("ログイン失敗");
		}
	}
	public static void tsetFindByLoginNG() {
		Login login = new Login("oguchi", "pskouhei");
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		Account result = borrowreturnDAO.findByLogin(login);
		if(result == null) {
			 System.out.println("ログイン失敗（OK)");
		}else {
			System.out.println("失敗");
		}
	}
	public static void testFindItemOK() {
		EquipmentQueryForm itemName = new EquipmentQueryForm("");
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		MedicalEquipmentResult itemNameResult = borrowreturnDAO.findByItemName(itemName);
		itemNameResult.toString();
		System.out.println(itemNameResult);
	}
	public static void testFindItemNG() {
		EquipmentQueryForm itemName = new EquipmentQueryForm(" ");
		BorrowReturnMysqlDAO borrowreturnDAO = new BorrowReturnMysqlDAO();
		MedicalEquipmentResult itemNameResult = borrowreturnDAO.findByItemName(itemName);
		itemNameResult.toString();
		System.out.println(itemNameResult);
	}
}

