package com.greensill.myapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "model")
public class ModelEntity {

	@Column(name = "date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Column(name = "date_updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;

	@Column(name = "description")
	private String description;

	@Id
	@SequenceGenerator(name = "model_id_seq", sequenceName = "model_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "model_id_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long Id;

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
		return Id;
	}

	@PrePersist
	private void onCreate() {
		dateCreated = dateUpdated = new Date();
	}

	@PreUpdate
	private void onUpdate() {
		dateUpdated = new Date();
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
		Id = id;
	}

}
