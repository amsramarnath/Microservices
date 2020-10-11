package com.amar.ratingsdataservice.schemaobjects;

public class RatingSo {

	private String bookId;
	private int rating;

	public RatingSo(String bookId, int rating) {
		super();
		this.bookId = bookId;
		this.rating = rating;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
