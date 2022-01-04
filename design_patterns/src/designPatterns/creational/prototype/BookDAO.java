package designPatterns.creational.prototype;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
	public List<Book> loadBooks() throws SQLException {
		List<Book> bookList = new ArrayList<>();
		
		for (int i=0; i<10; i++) {
			Book newBook = new Book();
			newBook.setBookId(i);
			
			switch (i) {
				case 0: newBook.setBookName("Anna Karenina");
					break;
				case 1: newBook.setBookName("To kill a Mockingbird");
					break;
				case 2: newBook.setBookName("The Great Gatsby");
					break;
				case 3: newBook.setBookName("One Hundred Years of Solitude");
					break;
				case 4: newBook.setBookName("A Passage to India");
					break;
				case 5: newBook.setBookName("Invisible Man");
					break;
				case 6: newBook.setBookName("Don Quixote");
					break;
				case 7: newBook.setBookName("Beloved");
					break;
				case 8: newBook.setBookName("Mrs. Dalloway");
					break;
				case 9: newBook.setBookName("Things Fall Apart");
					break;
				default: newBook.setBookName("Jane Eyre");
			}
			
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