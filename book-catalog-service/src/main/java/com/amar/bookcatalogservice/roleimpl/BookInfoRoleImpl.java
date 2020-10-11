package com.amar.bookcatalogservice.roleimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.amar.bookcatalogservice.schemaobjects.BookSo;
import com.amar.bookcatalogservice.schemaobjects.CatalogItemSo;
import com.amar.bookcatalogservice.schemaobjects.RatingSo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class BookInfoRoleImpl {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItemSo getCatalogItem(RatingSo rating) {
		BookSo bookSo = restTemplate.getForObject("http://book-info-service/BookInfo/" + rating.getBookId(),
				BookSo.class);
		return new CatalogItemSo(bookSo.getName(), bookSo.getDescription(), rating.getRating());
	}

	public CatalogItemSo getFallbackCatalogItem(RatingSo rating) {
		return new CatalogItemSo("Book Name not found", "", rating.getRating());
	}
}
