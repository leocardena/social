package com.social.web.rest.dto;

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
@JsonPropertyOrder({ "firstName", "lastName", "country",
	"phone", "birthday", "genre", "login", "email", "password",
		"avatar" })
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

	@JsonProperty("username")
	private String username;

	@JsonProperty("email")
	private String email;

	@JsonIgnore
	@JsonProperty("password")
	private String password;

	@JsonProperty("name")
	private String name;

	@JsonProperty("avatar")
	private String avatar;

	@JsonProperty("authorities")
	private Set<String> authorities;

	public UserDTO() {
	}

	public UserDTO(Profile profile) {
		this(profile.getName(), profile.getCountry(), profile.getUser().getPhone(), profile.getBirthday(),
				profile.getGenre(), profile.getUser().getUsername(), profile.getUser().getEmail(), profile.getAvatar(),
				profile.getUser().getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
	}

	public UserDTO(String name, String country, String phone, DateTime birthday, String genre, String username,
			String email, String avatar, Set<String> authorities) {
		this.name = name;
		this.country = country;
		this.phone = phone;
		this.birthday = birthday;
		this.genre = genre;
		this.username = username;
		this.email = email;
		this.avatar = avatar;
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
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param login
	 *            The login
	 */
	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
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

	/**
	 * 
	 * @return The avatar
	 */
	@JsonProperty("avatar")
	public String getAvatar() {
		return avatar;
	}

	/**
	 * 
	 * @param avatar
	 *            The avatar
	 */
	@JsonProperty("avatar")
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}