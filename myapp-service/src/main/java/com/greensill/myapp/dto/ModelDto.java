package com.greensill.myapp.dto;

import java.util.Date;

public class ModelDto {

	private Date dateCreated;

	private Date dateUpdated;

	private String description;

	private Long id;

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
