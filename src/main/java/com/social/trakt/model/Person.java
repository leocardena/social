package com.social.trakt.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "name", "ids", "images", "biography", "birthday", "death", "birthplace", "homepage" })

public class Person {

	@JsonProperty("name")
	private String name;
	@JsonProperty("ids")
	private Ids ids;
	@JsonProperty("images")
	private Images images;
	@JsonProperty("biography")
	private String biography;
	@JsonProperty("birthday")
	private String birthday;
	@JsonProperty("death")
	private Object death;
	@JsonProperty("birthplace")
	private String birthplace;
	@JsonProperty("homepage")
	private String homepage;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("ids")
	public Ids getIds() {
		return ids;
	}

	@JsonProperty("ids")
	public void setIds(Ids ids) {
		this.ids = ids;
	}

	public Images getImages() {
		return images;
	}

	@JsonProperty("images")
	public void setImages(Images images) {
		this.images = images;
	}

	@JsonProperty("biography")
	public String getBiography() {
		return biography;
	}

	@JsonProperty("biography")
	public void setBiography(String biography) {
		this.biography = biography;
	}

	@JsonProperty("birthday")
	public String getBirthday() {
		return birthday;
	}

	@JsonProperty("birthday")
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@JsonProperty("death")
	public Object getDeath() {
		return death;
	}

	@JsonProperty("death")
	public void setDeath(Object death) {
		this.death = death;
	}

	@JsonProperty("birthplace")
	public String getBirthplace() {
		return birthplace;
	}

	@JsonProperty("birthplace")
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@JsonProperty("homepage")
	public String getHomepage() {
		return homepage;
	}

	@JsonProperty("homepage")
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}