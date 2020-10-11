package com.amar.bookcatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amar.bookcatalogservice.roleimpl.BookInfoRoleImpl;
import com.amar.bookcatalogservice.roleimpl.UserRatingInfoRoleImpl;
import com.amar.bookcatalogservice.schemaobjects.CatalogItemSo;
import com.amar.bookcatalogservice.schemaobjects.UserRatingSo;

@RestController
@RequestMapping("/BookCatalog")
public class BookCatalogController {

	@Autowired
	private BookInfoRoleImpl bookInfoRoleImpl;

	@Autowired
	private UserRatingInfoRoleImpl userRatingRoleImpl;

	/*
	 * The below url is for the hystrix
	 * 
	 * http://localhost:8080/hystrix
	 * 
	 */
	
	
	@RequestMapping("/{userName}")
	// @HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItemSo> getCatalog(@PathVariable("userName") String userName) {

		UserRatingSo userRatingSo = userRatingRoleImpl.getUserRating(userName);

		if (userRatingSo != null && userRatingSo.getRatingSoList() != null) {

			return userRatingSo.getRatingSoList().stream().map(rating -> {

				return bookInfoRoleImpl.getCatalogItem(rating);

			}).collect(Collectors.toList());

		}

		return null;
	}

}
