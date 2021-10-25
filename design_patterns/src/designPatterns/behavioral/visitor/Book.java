package designPatterns.behavioral.visitor;

public class Book implements Item {
	
	private int price;
	private String bookName;
	private String isbnNumber;
	
	public Book(int price, String bookName, String isbnNumber) {
		this.price = price;
		this.bookName = bookName;
		this.isbnNumber = isbnNumber;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getIsbnNumber() {
		return isbnNumber;
	}
	
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	@Override
	public int accept(ShoppingCardVisitor visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "Book [Name=" + bookName + ", ISBN Number=" + isbnNumber + "Price=" + price + "]";
	}
	
}