package model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

public class MedicalEquipment implements Serializable, Cloneable {
	private int medicalEquipmen;
	private String modelNumber;
	private String serialNumber;
	private String manufacturer;
	private LocalDateTime introducedDate;
	private LocalDateTime borrowDate;
	private LocalDateTime returnDate;    
	private String place;
	private int itemId;
	private int returnID;
	private String deviceName;

	public MedicalEquipment() { }
	public MedicalEquipment(int medicalEquipmen) {
		this.medicalEquipmen = medicalEquipmen;
	}
	public int getMedicalEquipmen() {
		return medicalEquipmen;
	}
	public void setMedicalEquipmen(int medicalEquipmen) {
		this.medicalEquipmen = medicalEquipmen;
	}

	public  MedicalEquipment(int medicalEquipmen, String modelNumber, String serialNumber, String manufacturer, LocalDateTime introducedDate,LocalDateTime borrowDate,LocalDateTime returnDate, String place) {
		this.medicalEquipmen = medicalEquipmen;
		this.modelNumber = modelNumber;
		this.serialNumber = serialNumber;
		this.manufacturer = manufacturer;
		this.introducedDate = introducedDate;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.place = place;
	}
	public int getMedicalEquipmenNO() {
		return medicalEquipmen;
	}
	public void setMedicalEquipmenNO(int medicalEquipmen) {
		this.medicalEquipmen = medicalEquipmen;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Optional<LocalDateTime> getIntroducedDate() {
		return Optional.ofNullable(introducedDate);
	}
	public void setIntroducedDate(LocalDateTime introducedDate) {
		this.introducedDate = introducedDate;
	}
	public Optional<LocalDateTime> getBorrowDate() {
		return Optional.ofNullable(borrowDate);
	}
	public void setBorrowDate(LocalDateTime borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Optional<LocalDateTime> getReturnDate() {
		return Optional.ofNullable(returnDate);
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public  MedicalEquipment(int medicalEquipmen, String modelNumber, String serialNumber, String manufacturer, LocalDateTime introducedDate,String place) {
		this.medicalEquipmen = medicalEquipmen;
		this.modelNumber = modelNumber;
		this.serialNumber = serialNumber;
		this.manufacturer = manufacturer;
		this.introducedDate = introducedDate;
		this.place = place;

	}
	public int getMedicalEquipmentUnkow() {
		return medicalEquipmen;
	}
	public void setMedicalEquipmentUnkow(int medicalEquipmen) {
		this.medicalEquipmen = medicalEquipmen;
	}
	public String getModelNumberUnkonw() {
		return modelNumber;
	}
	public void setModelNumberUnknow(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getSerialNumberUnknow() {
		return serialNumber;
	}
	public void setSerialNumberUnkonw(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getManufacturerUnkonw() {
		return manufacturer;
	}
	public void setManufacturerUnkonw(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Optional<LocalDateTime> getIntroducedDateUnkonw() {
		return Optional.ofNullable(introducedDate);   
	}
	public void setIntroducedDateUnkonw(LocalDateTime introducedDate) {
		this.introducedDate = introducedDate;
	}
	public String getPlaceUnkonw() {
		return place;
	}
	public void setPlaceUnkonw(String place) {
		this.place = place;
	}
	public MedicalEquipment(int medicalEquipmen, String modelNumber, String serialNumber, String manufacturer, LocalDateTime introducedDate, int itemId) {
		this.medicalEquipmen = medicalEquipmen;
		this.modelNumber = modelNumber;
		this.serialNumber = serialNumber;
		this.manufacturer = manufacturer;
		this.introducedDate = introducedDate;
		this.itemId = itemId;

	}
	public int getmedicalEquipmentEnroll() {
		return medicalEquipmen;
	}
	public void setmedicalEquipmenEnroll(int medicalEquipmen) {
		this.medicalEquipmen = medicalEquipmen;
	}
	public String getModelNumberEnroll() {
		return modelNumber;
	}
	public void setModelNumberEnroll(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getSerialNumberEnroll() {
		return serialNumber;
	}
	public void setSerialNumberEnroll(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getManufacturerEnroll() {
		return manufacturer;
	}
	public void setManufacturerEnroll(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public LocalDateTime getIntroducedDateEnroll() {
		return introducedDate;  
	}
	public void setIntroducedDateEnroll(LocalDateTime introducedDate) {
		this.introducedDate = introducedDate;
	}
	public int getItemIdEnroll() {
		return itemId;
	}
	public void setItemIdEnroll(int itemId) {
		this.itemId = itemId;
	}
	public MedicalEquipment(int medicalEquipment, String placeName, LocalDateTime borrowDate, LocalDateTime returnDate) {
		this.medicalEquipmen = medicalEquipment;
		this.place = placeName;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	public int getMedicalEquipmentFindByItemName() {
		return medicalEquipmen;
	}
	public void setMedicalEquipmentFindByItemName(int medicalEquipment) {
		this.medicalEquipmen = medicalEquipment;

	}public String getPlaceNameFindByItemName() {
		return place;

	}public void setPlaceNameFindByItemName(String placeName) {
		this.place = placeName;

	}public LocalDateTime getBorrowDateFindByItemName() {
		return borrowDate;

	}public void setBorrowDateFindByItemName(LocalDateTime borrowDate) {
		this.borrowDate = borrowDate;

	}public LocalDateTime getReturnDateFindByItemName() {
		return returnDate;
	}
	public void setReturnDateFindByItemName(LocalDateTime returnDate) {
		this.returnDate = returnDate;;
	}
	public void setReturnID(int returnID) {
		this.returnID = returnID;
	}
	public  MedicalEquipment(int medicalEquipmen, String placeName, LocalDateTime borrowDate,LocalDateTime returnDate,String modelNumber, String serialNumber, String manufacturer, String deviceName) {
		this.medicalEquipmen = medicalEquipmen;
		this.place = placeName;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.modelNumber = modelNumber;
		this.serialNumber = serialNumber;
		this.manufacturer = manufacturer;
		this.deviceName = deviceName;
	}
	public int getMedicalEquipmentValue() {
		return medicalEquipmen;
	}
	public void setMedicalEquipmentValue(int medicalEquipment) {
		this.medicalEquipmen = medicalEquipment;
	}
	public String getPlaceNameValue() {
		return place;
	}
	public void setPlaceNameValue(String placeName) {
		this.place = placeName;
	}
	public LocalDateTime getBorrowDateValue() {
		return borrowDate;
	}
	public void setBorrowDateValue(LocalDateTime borrowDate) {
		this.borrowDate = borrowDate;
	}
	public LocalDateTime getReturnDateValue() {
		return returnDate;
	}
	public void setReturnDateValue(LocalDateTime returnDate) {
		this.returnDate = returnDate;;
	}
	public String getModelNumberValue() {
		return modelNumber;
	}
	public void setModelNumberValue(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getSerialNumberValue() {
		return serialNumber;
	}
	public void setSerialNumberValue(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getManufacturerValue() {
		return manufacturer;
	}
	public void setManufacturerValue(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public String setDeviceName(String deviceName) {
		return deviceName;
	}
	public String toString() {
		return "MedicalEquipment{" +
				"medicalEquipmen=" + medicalEquipmen +
				", modelNumber='" + modelNumber + '\'' +
				", serialNumber='" + serialNumber + '\'' +
				", manufacturer='" + manufacturer + '\'' +
				", introducedDate=" + introducedDate +
				", borrowDate=" + borrowDate +
				", returnDate=" + returnDate +
				", place='" + place + '\'' +
				", deviceName" + deviceName +
				'}';
	}
	public MedicalEquipment clone() {
		try {
			MedicalEquipment result = (MedicalEquipment) super.clone();
			result.medicalEquipmen = this.medicalEquipmen;
			System.out.println(medicalEquipmen);
			result.modelNumber = this.modelNumber;
			result.serialNumber = this.serialNumber;
			result.manufacturer = this.manufacturer;
			result.introducedDate = this.introducedDate;
			result.borrowDate = this.borrowDate;
			result.returnDate = this.returnDate;
			result.place = this.place;
		    result.returnID = this.returnID;
			result.deviceName = this.deviceName;
			return result;
		}catch (CloneNotSupportedException e) {
			throw new RuntimeException("クローンがサポートされていません", e);		}
		
	}
}
