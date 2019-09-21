package com.cg.jpaassignment.service;

import java.util.List;

import com.cg.jpaassignment.dto.Author;

public interface LibraryService {
	
	public Author addAuthor(Author author);
	public Integer deleteAuthor(Integer authorId);
	public Author searchAuthor(Integer authorId);
	public List<Author> viewAllAuthors();
	

}
