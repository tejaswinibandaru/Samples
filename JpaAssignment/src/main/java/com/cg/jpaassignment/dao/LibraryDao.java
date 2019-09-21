package com.cg.jpaassignment.dao;

import java.util.List;

import com.cg.jpaassignment.dto.Author;
import com.cg.jpaassignment.dto.Book;


public interface LibraryDao {
	
	public Author saveAuthor(Author author);
	public Integer removeAuthor(Integer authorId);
	public List<Author> findAllAuthors();
	public Author findAuthorById(Integer authorId);
	
	public Book addBook(Book book);
	public Integer removeBook(Integer bookId);
	public Book findBookById(Integer bookId);
	public List<Book> findAllBooks();
	
}
