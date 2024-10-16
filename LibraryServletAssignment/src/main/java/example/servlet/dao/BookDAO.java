package example.servlet.dao;

import java.util.List;

import example.servlet.entity.Book;

public interface BookDAO {
	 void addBook(Book book);
	    void updateBook(Book book);
	    void deleteBook(int bookId);
	    Book getBookById(int bookId);
	    List<Book> getAllBooks();
	}