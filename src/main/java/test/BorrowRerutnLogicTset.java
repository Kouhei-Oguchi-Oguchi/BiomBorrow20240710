package test;
import java.time.LocalDateTime;
import java.util.Scanner;

import model.BorrowReturnLogic;
import model.Login;
import model.MedicalEquipmentResult;
public class BorrowRerutnLogicTset {
	public static void main(String[] args) {
		testBorrowExecuteOK();
		//testBorrowExecuteDuplicate();
		//testBorrowExecuteNotFound();
		//testReturnExecuteOK();
		//testReturnExecuteNG();
		//testMedicalEquipmentByMeNo();
		//testExecuteOK();
		//testExecuteNG();
		//testEonrollOK();
		//testEnrollDuplicate();
		//testFindName();
		//testFindNG();
	}
	public static void testBorrowExecuteOK() {
		LocalDateTime BorrowDate = LocalDateTime.of(2023, 1, 1, 0, 0);
		int meNO = 1003;
		int department = 1;
		BorrowReturnLogic bo = new BorrowReturnLogic();
		MedicalEquipmentResult resultBo = bo.BorrowExecute(BorrowDate, meNO, department);
		resultBo.toString();
		System.out.println(resultBo);
	}
	public static void testBorrowExecuteDuplicate() {
		LocalDateTime BorrowDate = LocalDateTime.of(2023, 1, 1, 0, 0);
		int meNO = 1012;
		int department = 1;
		BorrowReturnLogic bo = new BorrowReturnLogic();
		MedicalEquipmentResult resultBo = bo.BorrowExecute(BorrowDate, meNO, department);
		resultBo.toString();
		System.out.println(resultBo);
	}
	public static void testBorrowExecuteNotFound() {
		LocalDateTime BorrowDate = LocalDateTime.of(2023, 1, 1, 0, 0);
		int meNO = 1100;
		int department = 1;
		BorrowReturnLogic bo = new BorrowReturnLogic();
		MedicalEquipmentResult resultBo = bo.BorrowExecute(BorrowDate, meNO, department);
		resultBo.toString();
		System.out.println(resultBo);
	}
	public static void testReturnExecuteOK() {
		LocalDateTime ReturnDate = LocalDateTime.of(2022, 1, 2, 0, 0);
		int meNO = 1000;
		BorrowReturnLogic bo = new BorrowReturnLogic();
		MedicalEquipmentResult resultBo = bo.ReturnExecute(meNO,ReturnDate);
		resultBo.toString();
		System.out.println(resultBo);
	}
	public static void testReturnExecuteNG() {
		System.out.println("MENO入力");
		Scanner scanner = new Scanner (System.in);
		int meNO = scanner.nextInt();
		LocalDateTime ReturnDate = LocalDateTime.of(2022, 1, 2, 0, 0);
		BorrowReturnLogic bo = new BorrowReturnLogic();
		MedicalEquipmentResult resultBo = bo.ReturnExecute(meNO,ReturnDate);
		resultBo.toString();
		System.out.println(resultBo);
	}
	public static void testMedicalEquipmentByMeNo() {
		int meNO = 1000;
		BorrowReturnLogic bo = new BorrowReturnLogic();
		MedicalEquipmentResult equipmentValue = bo.getMedicalEquipmentByMeNo(meNO);
		equipmentValue.toString();
		System.out.println(equipmentValue);
	}
    public static void testExecuteOK() {
    	Login login = new Login("kouhei", "pskouhei");
    	BorrowReturnLogic bo = new BorrowReturnLogic();
    	boolean result = bo.execute(login);
    	if(result) {
    		System.out.println("成功");
    	}else {
    		System.out.println("失敗");
    	}
    }
    public static void testExecuteNG() {
    	Login login = new Login("oguchi", "pskouhei");
    	BorrowReturnLogic bo = new BorrowReturnLogic();
    	boolean result = bo.execute(login);
    	if (!result) {
    		System.out.println("成功");
    	}else {
    		System.out.println("失敗");
    	}
    }
    public static void testEonrollOK() {
    	int meNO = 1600;
    	String modelNumber = "testBo";
    	String SerialNumber = "testBo";
    	String Manufacturer = "testBo";
    	LocalDateTime  introducedDate = LocalDateTime.of(2024,1,1,0,0);
    	int itemId = 1; 
    	BorrowReturnLogic bo = new BorrowReturnLogic();
    	MedicalEquipmentResult equipmentValue = bo.EnrollEcecute(meNO, modelNumber, SerialNumber, Manufacturer, introducedDate, itemId);
    	equipmentValue.toString();
    	System.out.println(equipmentValue);
    }
    public static void testEnrollDuplicate() {
    	int meNO = -1;
    	String modelNumber = "testBo";
    	String SerialNumber = "tesutBo";
    	String Manufacturer = "testBo";
    	LocalDateTime  introducedDate = LocalDateTime.of(2024,1,1,0,0);
    	int itemId = 1;
    	BorrowReturnLogic bo = new BorrowReturnLogic();
    	MedicalEquipmentResult equipmentValue = bo.EnrollEcecute(meNO, modelNumber, SerialNumber, Manufacturer, introducedDate, itemId);
    	equipmentValue.toString();
    	System.out.println(equipmentValue);
    }
    public static void testFindName() {
    	String itemName = "Infusion Pump";
    	BorrowReturnLogic bo = new BorrowReturnLogic();
    	MedicalEquipmentResult equipments = bo.getFindByItemName(itemName);
    	equipments.toString();
    	System.out.println(equipments);
    }
    public static void testFindNG() {
    	String itemName = null;
    	BorrowReturnLogic bo = new BorrowReturnLogic();
    	MedicalEquipmentResult equipments = bo.getFindByItemName(itemName);
    	equipments.toString();
    	System.out.println(equipments);
    }
}