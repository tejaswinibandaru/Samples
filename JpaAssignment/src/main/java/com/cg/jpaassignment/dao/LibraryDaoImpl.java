package com.cg.jpaassignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.jpaassignment.dto.Author;
import com.cg.jpaassignment.dto.Book;

public class LibraryDaoImpl implements LibraryDao{
	
	private EntityManager em;
	public LibraryDaoImpl(EntityManager em) {
		this.em=em;
	}

	public Author saveAuthor(Author author) {
		// TODO Auto-generated method stub
		if(findAllAuthors()==null) {
			EntityTransaction transaction=em.getTransaction();
			transaction.begin();
			em.persist(author);
			transaction.commit();
		}
		else if(findAllAuthors().contains(author)) {
			EntityTransaction transaction=em.getTransaction();
			transaction.begin();
			Author authorToBeUpdated=em.merge(author);
			authorToBeUpdated.setPhoneNo(authorToBeUpdated.getPhoneNo());
			authorToBeUpdated.setBooks(authorToBeUpdated.getBooks());
			transaction.commit();
			return authorToBeUpdated;
		}else {
			EntityTransaction transaction=em.getTransaction();
			transaction.begin();
			em.persist(author);
			transaction.commit();
		}
		return author;
	}

	public Integer removeAuthor(Integer authorId) {
		// TODO Auto-generated method stub
		Author author=em.find(Author.class, authorId);
		if(author!=null) {
			EntityTransaction transaction=em.getTransaction();
			transaction.begin();
			em.remove(author);
			transaction.commit();
			return 1;
		}
		return 0;
	}

	public List<Author> findAllAuthors() {
		// TODO Auto-generated method stub
		TypedQuery<Author> query=em.createQuery("SELECT author FROM Author author", Author.class);
		return query.getResultList();
	}

	public Author findAuthorById(Integer authorId) {
		// TODO Auto-generated method stub
		return em.find(Author.class, authorId);
	}

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		if(findAllBooks()==null) {
			EntityTransaction transaction=em.getTransaction();
			transaction.begin();
			Book bookObj=em.merge(book);
			bookObj.setAuthorsList(bookObj.getAuthorsList());
			em.persist(bookObj);
			em.flush();
			transaction.commit();
		}
		else if(findAllBooks().contains(book)) {
			EntityTransaction transaction=em.getTransaction();
			transaction.begin();
			Book bookToBeUpdated=em.merge(book);
			bookToBeUpdated.setBookCost(bookToBeUpdated.getBookCost());
			transaction.commit();
			return bookToBeUpdated;
		}else {
			EntityTransaction transaction=em.getTransaction();
			transaction.begin();
			Book bookObj=em.merge(book);
			bookObj.setAuthorsList(bookObj.getAuthorsList());
			em.persist(bookObj);
			em.flush();
			transaction.commit();
		}
		return book;
	}

	public Integer removeBook(Integer bookId) {
		// TODO Auto-generated method stub
		Book book=em.find(Book.class, bookId);
		if(book!=null) {
			EntityTransaction transaction=em.getTransaction();
			transaction.begin();
			em.remove(book);
			transaction.commit();
			return 1;
		}
		return 0;
	}

	public Book findBookById(Integer bookId) {
		// TODO Auto-generated method stub
		return em.find(Book.class, bookId);
	}

	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		TypedQuery<Book> query=em.createQuery("SELECT book FROM Book book", Book.class);
		return query.getResultList();
	}

}
