package com.amar.bookcatalogservice.schemaobjects;

import java.util.List;

public class UserRatingSo {

	private List<RatingSo> ratingSoList;

	public UserRatingSo() {
		super();
	}

	public UserRatingSo(List<RatingSo> ratingSoList) {
		super();
		this.ratingSoList = ratingSoList;
	}

	public List<RatingSo> getRatingSoList() {
		return ratingSoList;
	}

	public void setRatingSoList(List<RatingSo> ratingSoList) {
		this.ratingSoList = ratingSoList;
	}

}
