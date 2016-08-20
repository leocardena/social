package com.social.rest.dto;

import javax.annotation.Generated;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "nome", "sobrenome", "country", "phone", "birthday", "genre", "login", "email", "password" })
public class UserDTO {

	@JsonProperty("nome")
	private String nome;
	@JsonProperty("sobrenome")
	private String sobrenome;
	@JsonProperty("country")
	private String country;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("birthday")
	private String birthday;
	@JsonProperty("genre")
	private String genre;
	@JsonProperty("login")
	private String login;
	@JsonProperty("email")
	private String email;
	@JsonProperty("password")
	private String password;

	/**
	 * 
	 * @return The nome
	 */
	@JsonProperty("nome")
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 *            The nome
	 */
	@JsonProperty("nome")
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return The sobrenome
	 */
	@JsonProperty("sobrenome")
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * 
	 * @param sobrenome
	 *            The sobrenome
	 */
	@JsonProperty("sobrenome")
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 
	 * @param birthday
	 *            The birthday
	 */
	@JsonProperty("birthday")
	public void setBirthday(String birthday) {
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}