package com.amar.bookinfoservice.schemaobjects;

public class BookSo {

	private String bookId;
	private String name;
	private String description;

	public BookSo() {
		super();
	}

	public BookSo(String bookId, String name, String description) {
		this.bookId = bookId;
		this.name = name;
		this.description = description;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
