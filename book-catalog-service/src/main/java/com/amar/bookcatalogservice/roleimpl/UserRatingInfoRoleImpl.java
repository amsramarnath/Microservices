package com.amar.bookcatalogservice.roleimpl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.amar.bookcatalogservice.schemaobjects.RatingSo;
import com.amar.bookcatalogservice.schemaobjects.UserRatingSo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class UserRatingInfoRoleImpl {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRatingSo getUserRating(String userName) {
		return restTemplate.getForObject("http://ratings-data-service/RatingsData/users/" + userName,
				UserRatingSo.class);
	}

	public UserRatingSo getFallbackUserRating(String userName) {

		UserRatingSo userRatingSo = new UserRatingSo();
		userRatingSo.setRatingSoList(Arrays.asList(new RatingSo("0", 0)));
		return userRatingSo;

	}
}
