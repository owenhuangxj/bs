package com.ss.bookstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author implements Serializable{
	private static final long serialVersionUID = 758188159347781484L;
	private Long id;
	private String authorName;
	private List<Book> books = new ArrayList<Book>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Author(){}
	public Author(Long id, String authorName) {
		this.id = id;
		this.authorName = authorName;
	}
	public Author(Long id, String authorName, List<Book> books) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", authorName=" + authorName + ", books=" + books + "]";
	}
}
