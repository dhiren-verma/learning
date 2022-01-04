package designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class MedicalStore implements Store{
	
	private String medicalStoreName;
	private List<Medicine> medicines;
	
	public MedicalStore() {
		medicines = new ArrayList<>();
	}
	
	public void setMedicalStoreName(String medicalStoreName) {
		this.medicalStoreName = medicalStoreName;
	}
	
	public String getMedicalStoreName() {
		return medicalStoreName;
	}
	
	public List<Medicine> getMedicines() {
		return medicines;
	}

	@Override
	public String toString() {
		return "MedicalStore [medicalStoreName=" + medicalStoreName + ", medicines=" + medicines + "]";
	}
	
	public MedicalStore clone() throws CloneNotSupportedException {
//		//Shallow Cloning:
//		return (MedicalStore)super.clone();
		
		//Deep Cloning:
		MedicalStore clonedMedicalStore = new MedicalStore();
		
		clonedMedicalStore.getMedicines().addAll(medicines);
		
		return clonedMedicalStore;
	}
	
}
