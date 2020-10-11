package com.amar.bookinfoservice.roleimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.amar.bookinfoservice.ext.schemaobjects.ExtBookSummarySo;
import com.amar.bookinfoservice.schemaobjects.BookSo;

@Component
public class BookInfoRoleImpl {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	public BookSo getBookInfo(String bookId) {

		// TODO: If we pass bookId as 1 it is throwing error. Need to fix this

		String url = "https://api.themoviedb.org/3/movie/" + bookId + "?api_key=" + apiKey;

		// try {
		ExtBookSummarySo extBookSummarySo = restTemplate.getForObject(url, ExtBookSummarySo.class);

		if (extBookSummarySo != null) {
			return new BookSo(bookId, extBookSummarySo.getTitle(), extBookSummarySo.getOverview());
		}
		// } catch (Exception e) {

		// System.out.println("Exception= " + e);
		// }

		return null;
	}

}
