package com.social.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "title")
public class Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idtitle")
	private long id;
	
	@Column(name = "imdb")
	private String imdb;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "trailler")
	private String trailler;
	
	@Column(name = "homePage")
	private String homePage;
	
	@Column(name = "votes")
	private long votes;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrailler() {
		return trailler;
	}

	public void setTrailler(String trailler) {
		this.trailler = trailler;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
