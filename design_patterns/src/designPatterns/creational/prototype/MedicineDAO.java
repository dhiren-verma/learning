package designPatterns.creational.prototype;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {
	
	public List<Medicine> loadMediciness() throws SQLException {
		List<Medicine> medicineList = new ArrayList<>();
		
		for (int i=0; i<10; i++) {
			Medicine newMedicine = new Medicine();
			newMedicine.setMedicineId(i);
			
			switch (i) {
				case 0: newMedicine.setMedicineName("Acetaminophen");
					break;
				case 1: newMedicine.setMedicineName("Naproxen");
					break;
				case 2: newMedicine.setMedicineName("Aspirin");
					break;
				case 3: newMedicine.setMedicineName("Dextromethorphan");
					break;
				case 4: newMedicine.setMedicineName("Guaifenesin");
					break;
				case 5: newMedicine.setMedicineName("Ibuprofen");
					break;
				case 6: newMedicine.setMedicineName("Benzocaine");
					break;
				case 7: newMedicine.setMedicineName("Oxymetazoline");
					break;
				case 8: newMedicine.setMedicineName("Pseudophedrine");
					break;
				case 9: newMedicine.setMedicineName("Dyphenhydramine");
					break;
				default: newMedicine.setMedicineName("Simethicone");
			}
			
			medicineList.add(newMedicine);
			
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
				throw new SQLException("DB Exception");
			}
		}
		
		return medicineList;
	}
	
}
