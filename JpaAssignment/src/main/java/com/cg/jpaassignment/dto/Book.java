package com.cg.jpaassignment.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Book {
	@Id
	private Integer bookId;
	private String bookTitle;
	private Double bookCost;
	private String bookIsbn;
	@ManyToMany
	private List<Author> authorsList;
	
	public Book() {
		
	}
	
	

	public Book(Integer bookId, String bookTitle, Double bookCost, String bookIsbn, List<Author> authorsList) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookCost = bookCost;
		this.bookIsbn = bookIsbn;
		this.authorsList = authorsList;
	}



	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Double getBookCost() {
		return bookCost;
	}

	public void setBookCost(Double bookCost) {
		this.bookCost = bookCost;
	}

	public String getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	
	

	public List<Author> getAuthorsList() {
		return authorsList;
	}



	public void setAuthorsList(List<Author> authorsList) {
		this.authorsList = authorsList;
	}



	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookCost=" + bookCost + ", bookIsbn="
				+ bookIsbn + "]";
	}
	
	
	
}
