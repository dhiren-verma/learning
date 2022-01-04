package designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookStore implements Store{
	
	private String bookShopName;
	private List<Book> books;
	
	public BookStore() {
		books = new ArrayList<>();
	}
	
	public String getBookShopName() {
		return bookShopName;
	}
	
	public void setBookShopName(String bookShopName) {
		this.bookShopName = bookShopName;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	@Override
	public String toString() {
		return "BookShop [bookShopName=" + bookShopName + ", books=" + books + "]";
	}
	
	@Override
	public BookStore clone() throws CloneNotSupportedException {
//		//Shallow Cloning:
//		return (BookStore)super.clone();
		
		//Deep Cloning:
		BookStore clonedShop = new BookStore();
		
		clonedShop.getBooks().addAll(getBooks());
		
		return clonedShop;
	}
	
}