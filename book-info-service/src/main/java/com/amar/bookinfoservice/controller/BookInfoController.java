package com.amar.bookinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amar.bookinfoservice.roleimpl.BookInfoRoleImpl;
import com.amar.bookinfoservice.schemaobjects.BookSo;

@RestController
@RequestMapping("/BookInfo")
public class BookInfoController {

	@Autowired
	private BookInfoRoleImpl bookInfoRoleImpl;

	@RequestMapping("/{bookId}")
	public BookSo getBookInfo(@PathVariable("bookId") String bookId) {

		if (!StringUtils.isEmpty(bookId)) {

			return bookInfoRoleImpl.getBookInfo(bookId);
		}

		return null;
	}

	/*
	 * @RequestMapping("/{bookId}") public BookSo
	 * getBookInfo(@PathVariable("bookId") String bookId) {
	 * 
	 * if (!StringUtils.isEmpty(bookId)) {
	 * 
	 * if (bookId.equalsIgnoreCase("1")) { return new BookSo(bookId, "Spring",
	 * "Spring Description"); } else if (bookId.equalsIgnoreCase("2")) { return new
	 * BookSo(bookId, "Java", "Java Description"); } else { return new
	 * BookSo(bookId, "Dummy", "Dummy Description"); } }
	 * 
	 * return new BookSo(); }
	 */

}
