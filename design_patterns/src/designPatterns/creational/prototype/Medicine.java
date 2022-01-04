package designPatterns.creational.prototype;

public class Medicine {
	
	private int medicineId;
	private String medicineName;
	
	public int getMedicineId() {
		return medicineId;
	}
	
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	
	public String getMedicineName() {
		return medicineName;
	}
	
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	@Override
	public String toString() {
		return "\nMedicine [medicineId=" + medicineId + ", medicineName=" + medicineName + "]";
	}
	
}