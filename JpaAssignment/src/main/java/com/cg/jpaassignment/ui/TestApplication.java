package com.cg.jpaassignment.ui;

import java.math.BigInteger;
import java.util.List;

import com.cg.jpaassignment.dto.Author;
import com.cg.jpaassignment.dto.Book;
import com.cg.jpaassignment.service.LibraryService;
import com.cg.jpaassignment.service.LibraryServiceImpl;

public class TestApplication {
	
	public static void main(String[] args) {
		Author author=new Author();
		author.setAuthorId(123);
		author.setFirstName("jane");
		author.setMiddleName("marie");
		author.setLastName("austin");
		author.setPhoneNo(BigInteger.valueOf(78930289));
		
		LibraryService service=new LibraryServiceImpl();
		System.out.println("-----------------------------------------------------------------------------------------------------");
		service.addAuthor(author);
		System.out.println("-----------------------------------------------------------------------------------------------------");
		List<Author> authorsList=service.viewAllAuthors();
		
		for(Author authorObj: authorsList) {
			System.out.println("-----------------------------------------------------------------------------------------------------");
			System.out.println("Author id: "+authorObj.getAuthorId());
			System.out.println("Author full name: "+authorObj.getFirstName()+" "+authorObj.getMiddleName()+" "+authorObj.getLastName());
			System.out.println("Author phone number: "+authorObj.getPhoneNo());
			System.out.println("-----------------------------------------------------------------------------------------------------");
		}
		
		/*
		 * author.setPhoneNo(BigInteger.valueOf(76390039));
		 * System.out.println(service.addAuthor(author));
		 */
		System.out.println("-----------------------------------------------------------------------------------------------------");
		
		Book book=new Book();
		
		book.setBookId(1001);
		book.setBookTitle("Java Fundamentals");
		book.setBookCost(500.0);
		book.setBookIsbn("123-456-7890");
		book.setAuthorsList(service.viewAllAuthors());
		
		System.out.println(book);
		
		
	
	}

}
