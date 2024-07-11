package model;

import java.time.LocalDateTime;

public class EquipmentQueryForm {
	private String itemName;
	private LocalDateTime queryDate;
	public EquipmentQueryForm(String itemName) {
		this.itemName = itemName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public LocalDateTime getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(LocalDateTime queryDate) {
		this.queryDate = queryDate;
	}
}