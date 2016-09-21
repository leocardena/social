package com.social.rest.dto;

import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.social.domain.Authority;
import com.social.domain.Profile;
import com.social.util.CustomDateTimeSerializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "firstName", "lastName", "country", "phone", "birthday", "genre", "login", "email", "password" })
public class UserDTO {
	
	@JsonIgnore
	@JsonProperty("firstName")
	private String firstName;

	@JsonIgnore
	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("country")
	private String country;

	@JsonProperty("phone")
	private String phone;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonProperty("birthday")
	private DateTime birthday;

	@JsonProperty("genre")
	private String genre;

	@JsonProperty("login")
	private String login;

	@JsonProperty("email")
	private String email;
	
	@JsonIgnore
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("authorities")
	private Set<String> authorities;

	public UserDTO() {
	};

	public UserDTO(Profile profile) {
		this(profile.getName(), profile.getCountry(), profile.getUser().getPhone(), profile.getBirthday(),
				profile.getGenre(), profile.getUser().getUsername(), profile.getUser().getEmail(),
				profile.getUser().getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
	}

	public UserDTO(String name, String country, String phone, DateTime birthday, String genre,
			String login, String email, Set<String> authorities) {
		this.name = name;
		this.country = country;
		this.phone = phone;
		this.birthday = birthday;
		this.genre = genre;
		this.login = login;
		this.email = email;
		this.authorities = authorities;
	}

	/**
	 * 
	 * @return The firstName
	 */
	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 *            The firstName
	 */
	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return The lastName
	 */
	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 *            The lastName
	 */
	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return The country
	 */
	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 *            The country
	 */
	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return The phone
	 */
	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	/**
	 * 
	 * @param phone
	 *            The phone
	 */
	@JsonProperty("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 
	 * @return The birthday
	 */
	@JsonProperty("birthday")
	public DateTime getBirthday() {
		return birthday;
	}

	/**
	 * 
	 * @param birthday
	 *            The birthday
	 */
	@JsonProperty("birthday")
	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}

	/**
	 * 
	 * @return The genre
	 */
	@JsonProperty("genre")
	public String getGenre() {
		return genre;
	}

	/**
	 * 
	 * @param genre
	 *            The genre
	 */
	@JsonProperty("genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * 
	 * @return The login
	 */
	@JsonProperty("login")
	public String getLogin() {
		return login;
	}

	/**
	 * 
	 * @param login
	 *            The login
	 */
	@JsonProperty("login")
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * 
	 * @return The email
	 */
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 *            The email
	 */
	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return The password
	 */
	@JsonIgnore
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 *            The password
	 */
	@JsonIgnore
	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param password
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The authorities
	 */
	public Set<String> getAuthorities() {
		return authorities;
	}

	/**
	 * 
	 * @param authorities
	 *            The authorities
	 */
	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}