package com.social.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social.security.util.Constants;

/**
 * A user.
 */
@Entity
@Table(name = "user")
public class User extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iduser")
	private Long id;

	@NotNull
	@Pattern(regexp = Constants.USERNAME_REGEX)
	@Size(min = 1, max = 50)
	@Column(name = "username")
	private String username;

	@JsonIgnore
	@NotNull
	@Size(min = 60, max = 60)
	@Column(name = "password")
	private String password;

	@Size(max = 50)
	@Column(name = "phone")
	private String phone;

	@Email
	@Size(max = 100)
	@Column(length = 100, name = "email")
	private String email;

	@NotNull
	@Column(name = "activated")
	private boolean activated = false;

	@Size(max = 20)
	@Column(name = "activationkey")
	@JsonIgnore
	private String activationKey;

	@Size(max = 20)
	@Column(name = "resetkey")
	private String resetKey;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "resetdate")
	private DateTime resetDate = null;

	@OneToOne(mappedBy = "user")
	private Profile profile;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "userauthority", joinColumns = {
			@JoinColumn(name = "iduser", referencedColumnName = "iduser") }, inverseJoinColumns = {
					@JoinColumn(name = "authorityname", referencedColumnName = "name") })
	private Set<Authority> authorities = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	// Lowercase the login before saving it in database
	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getResetKey() {
		return resetKey;
	}

	public void setResetKey(String resetKey) {
		this.resetKey = resetKey;
	}

	public DateTime getResetDate() {
		return resetDate;
	}

	public void setResetDate(DateTime resetDate) {
		this.resetDate = resetDate;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}