package com.social.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratingparent")
public class RatingParent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idratingparent")
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
