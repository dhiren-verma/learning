package designPatterns.creational.prototype;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookLoaderDAO {
	
	public List<Book> loadBooks() throws SQLException {
		List<Book> bookList = new ArrayList<>();
		
		for (int i=0; i<10; i++) {
			Book newBook = new Book();
			newBook.setBookId(i);
			newBook.setBookName("Book "+1);
			
			bookList.add(newBook);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				
				throw new SQLException("DB Exception");
			}
		}
		
		return bookList;
	} 
	
}