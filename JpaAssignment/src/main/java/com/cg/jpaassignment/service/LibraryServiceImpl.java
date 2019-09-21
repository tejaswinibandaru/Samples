package com.cg.jpaassignment.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.jpaassignment.dao.LibraryDao;
import com.cg.jpaassignment.dao.LibraryDaoImpl;
import com.cg.jpaassignment.dto.Author;

public class LibraryServiceImpl implements LibraryService {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("jpaassignment");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	
	LibraryDao libraryDao=new LibraryDaoImpl(entityManager);

	public Author addAuthor(Author author) {
		// TODO Auto-generated method stub
		return libraryDao.saveAuthor(author);
	}

	public Integer deleteAuthor(Integer authorId) {
		// TODO Auto-generated method stub
		return libraryDao.removeAuthor(authorId);
	}

	public Author searchAuthor(Integer authorId) {
		// TODO Auto-generated method stub
		return libraryDao.findAuthorById(authorId);
	}

	public List<Author> viewAllAuthors() {
		// TODO Auto-generated method stub
		return libraryDao.findAllAuthors();
	}

}
