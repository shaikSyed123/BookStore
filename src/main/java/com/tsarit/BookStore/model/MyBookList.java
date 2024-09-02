package com.tsarit.BookStore.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MyBookList {
	@Id
	private int id;
	private String bookname;
	private String author;
	private String price;

	public MyBookList(int id, String bookname, String author, String price) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public MyBookList() {
		super();
		// TODO Auto-generated constructor stub
	}
}
