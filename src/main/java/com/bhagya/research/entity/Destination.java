package com.bhagya.research.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String destinationTitle;
	private String destinationDescription;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestinationTitle() {
		return destinationTitle;
	}

	public void setDestinationTitle(String destinationTitle) {
		this.destinationTitle = destinationTitle;
	}

	public String getDestinationDescription() {
		return destinationDescription;
	}

	public void setDestinationDescription(String destinationDescription) {
		this.destinationDescription = destinationDescription;
	}

}
