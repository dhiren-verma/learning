package designPatterns.creational.prototype;

import java.sql.SQLException;

public class PrototypeDemo {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		StoreManager storeManager = StoreManager.getStoreManager();
		
		//Lets assume that BookDAO fetches Book List from DB:
		//As its fetching from DB, there might be some delays associated:
		BookDAO bookDao = new BookDAO();
		System.out.println("Instantiaiting First Book Shop");
		BookStore firstBookShop = new BookStore();
		firstBookShop.setBookShopName("Novelty Book Store");
		
		try {
			firstBookShop.getBooks().addAll(bookDao.loadBooks());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("First Book Store is:\n"+firstBookShop);
		
		//Also lets add this Book Store to StoreManager
		storeManager.addNewStore(StoreType.BOOK_STORE, firstBookShop);
		
		//Lets assume that MedicineDAO fetches Medicines from DB:
		//As its fetching from DB, there might be some delays associated:
		MedicineDAO medicineDao = new MedicineDAO();
		System.out.println("Instantiaiting First Medical Shop");
		MedicalStore firstMedicineShop = new MedicalStore();
		firstMedicineShop.setMedicalStoreName("Soni Medical Store");
		
		try {
			firstMedicineShop.getMedicines().addAll(medicineDao.loadMediciness());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nFirst Medical Store is:\n"+firstMedicineShop);
		
		//Also lets add this Medical Store to StoreManager
		storeManager.addNewStore(StoreType.MEDICAL_STORE, firstMedicineShop);
		
		
		
		System.out.println("\n\nInstantiaiting Second Book Shop");
		
		//Now lets say we need to construct another Book Store which has same list of Books:
		//But the optimization issue at hand is that we don't want to load Books from DB when
		//we already have loaded them once in another BookShop:
		//In this Scenario, we can use the Earlier BookShop as a Prototype to create a new BookShop:
		BookStore secondBookShop = (BookStore) storeManager.getStore(StoreType.BOOK_STORE).clone();
		secondBookShop.setBookShopName("Grover Book Store");
		
		System.out.println("Second Book Store is:\n"+secondBookShop);
		
		System.out.println("\n\nInstantiaiting Second Medical Shop");
		
		//Now lets say we need to construct another Medical Store which has same OTC Medicines:
		//But the optimization issue at hand is that we don't want to load Medicines from DB when
		//we already have loaded them once in another MedicalShop:
		//In this Scenario, we can use the Earlier MedicalShop as a Prototype to create a new MedicalShop:
		MedicalStore secondMedicalShop = (MedicalStore) storeManager.getStore(StoreType.MEDICAL_STORE).clone();
		secondMedicalShop.setMedicalStoreName("Saunkhiya Medical Store");
		
		System.out.println("Second Medical Store is:\n"+secondMedicalShop);
	}

}
