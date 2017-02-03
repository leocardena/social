package com.social.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Long id;
	
	@Column(name = "idprofile", nullable = false)
	private Long profile;
	
	@Column(name = "date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime date;
	
	@Column(name = "note")
	private Integer note;

    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idratingparent", unique= true)
	private RatingParent idRatingParent;
    
    public Rating () { }

	public Rating(Long id, Long profile, DateTime date, Integer note, RatingParent idRatingParent) {
		this.id = id;
		this.profile = profile;
		this.date = date;
		this.note = note;
		this.idRatingParent = idRatingParent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProfile() {
		return profile;
	}

	public void setProfile(Long profile) {
		this.profile = profile;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
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
