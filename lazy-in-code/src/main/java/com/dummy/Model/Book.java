package com.dummy.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "Book")
@Table(name = "BOOK")
@DynamicUpdate
@NamedQueries(value = {
		@NamedQuery(name="Book.findBookId", query = "SELECT u from Book u where u.bookId =?1")
})
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 long id;
	
	@Column(name = "BOOK_ID")
	 String bookId;
	
	@Column(name = "GENRE")
	String genre;
	
	@Column(name = "AUTHOR")
	String author;
	
	@Column(name = "PUBLICATION")
	 String publication;

	public Book() {
		super();
	}

	public Book(long id, String bookId, String genre, String author, String publication) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.genre = genre;
		this.author = author;
		this.publication = publication;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}
	
}
