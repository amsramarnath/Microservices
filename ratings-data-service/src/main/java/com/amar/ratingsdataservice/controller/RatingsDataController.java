package com.amar.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amar.ratingsdataservice.schemaobjects.RatingSo;
import com.amar.ratingsdataservice.schemaobjects.UserRatingSo;

@RestController
@RequestMapping("/RatingsData")
public class RatingsDataController {

	@RequestMapping("/{bookId}")
	public RatingSo getRating(@PathVariable("bookId") String bookId) {
		return new RatingSo(bookId, 5);
	}

	@RequestMapping("users/{userName}")
	public UserRatingSo getUserRating(@PathVariable("userName") String userName) {

		List<RatingSo> ratingSoList = Arrays.asList(new RatingSo("550"/* 1 - If we pass 1 it is failing */, 5),
				new RatingSo("600", 4));

		UserRatingSo userRatingSo = new UserRatingSo();
		userRatingSo.setRatingSoList(ratingSoList);
		return userRatingSo;
	}

}
