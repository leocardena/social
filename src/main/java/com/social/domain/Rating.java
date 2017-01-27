package com.social.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idrating")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="idprofile")
	private Profile profile;
	
	@Column(name = "date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime date;
	
	@Column(name = "note")
	private long note;
	
	@OneToOne
	@JoinColumn(name = "idratingparent")
	private RatingParent idRatingParent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public long getNote() {
		return note;
	}

	public void setNote(long note) {
		this.note = note;
	}

	public RatingParent getIdRatingParent() {
		return idRatingParent;
	}

	public void setIdRatingParent(RatingParent idRatingParent) {
		this.idRatingParent = idRatingParent;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
