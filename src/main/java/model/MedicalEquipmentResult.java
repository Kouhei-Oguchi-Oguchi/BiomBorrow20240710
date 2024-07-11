package model;
import java.util.ArrayList;
public class MedicalEquipmentResult {
	private MedicalEquipment equipment;
	private ArrayList <MedicalEquipment> equipments;
	private String errorMessage;
	
	public MedicalEquipmentResult(MedicalEquipment equipment, String errorMessage) {
		this.equipment = equipment;
		this.errorMessage = errorMessage;
	}
	public MedicalEquipmentResult(ArrayList<MedicalEquipment> equipments, String errorMessage) {
		this.equipments = equipments;
		this.errorMessage = errorMessage;
	}
	public ArrayList<MedicalEquipment> getEquipments() {
		return equipments;
	}
	public MedicalEquipment getEquipment() {
		return equipment;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public boolean isSuccess() {
		return equipment != null;
	}
	public boolean isEquipmentsSuccess() {
		return !equipments.isEmpty();
	}
	public String toString() {
		return "MedicalEquipment{" +
				"equipment=" + (equipment != null ? equipment.toString() :"null") +
				"equipments" + (equipments != null ? equipments.toString() : "null") +
				", errowMessage" + errorMessage + '\'' + '}';
	}
}
