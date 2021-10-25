package designPatterns.creational.prototype;

import java.sql.SQLException;

public class PrototypeDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		//Lets assume that this'Class fetches Book List from DB:
		//As its fetching from DB, there might be some delays associated:
		BookLoaderDAO bookLoaderDao = new BookLoaderDAO();
		
		System.out.println("Instantiaiting First Book Shop");
		
		BookShop firstBookShop = new BookShop();
		firstBookShop.setBookShopName("Novelty Book Store");
		
		try {
			firstBookShop.getBooks().addAll(bookLoaderDao.loadBooks());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("First Book Store is:\n"+firstBookShop);
		
		System.out.println("\n\nInstantiaiting Second Book Shop");
		
		//Now lest say we need to construct another Book Store which has same list of Books:
		//But the optimization issue at hand is that we don't want to load Books from DB when
		//we already have loaded them once in another BookShop:
		//In this Scenario, we can use the Earlier BookSShop as a Prototype to create a new BookShop:
		BookShop secondBookShop = firstBookShop.clone();
		secondBookShop.setBookShopName("Grover Book Store");
		
		System.out.println("Second Book Store is:\n"+secondBookShop);
	}

}
