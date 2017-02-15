package com.social.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chat")
public class Chat implements Serializable {
	
	private static final long serialVersionUID = 2455660248946500527L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idchat")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idprofileone")
	private Profile profileOne;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idprofiletwo")
	private Profile profileTwo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getProfileOne() {
		return profileOne;
	}

	public void setProfileOne(Profile profileOne) {
		this.profileOne = profileOne;
	}

	public Profile getProfileTwo() {
		return profileTwo;
	}

	public void setProfileTwo(Profile profileTwo) {
		this.profileTwo = profileTwo;
	}
	
}
