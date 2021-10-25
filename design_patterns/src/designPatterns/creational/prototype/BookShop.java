package designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable{
	
	private String bookShopName;
	private List<Book> books;
	
	public BookShop() {
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
	protected BookShop clone() throws CloneNotSupportedException {
//		//Shallow Cloning:
//		return (BookShop)super.clone();
		
		//Deep Cloning:
		BookShop clonedShop = new BookShop();
		
		clonedShop.getBooks().addAll(getBooks());
		
		return clonedShop;
	}
	
}