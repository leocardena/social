package com.social.domain;

import java.io.Serializable;
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
public class Rating implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idrating")
	private Long idRating;

	@Column(name = "idprofile", nullable = false)
	private Long profile;
	
    @OneToOne
	@JoinColumn(name = "idratingparent", unique= true)
	private RatingParent idRatingParent;
	
	@Column(name = "date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime date;
	
	@Column(name = "note")
	private Integer note;
	
	@Column(name = "targettype")
	private String targetType;

    public Rating () { }

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

	public Long getIdRating() {
		return idRating;
	}
	

	public void setIdRating(Long idRating) {
		this.idRating = idRating;
	}
	

	public Long getProfile() {
		return profile;
	}
	

	public void setProfile(Long profile) {
		this.profile = profile;
	}
	

	public RatingParent getIdRatingParent() {
		return idRatingParent;
	}
	

	public void setIdRatingParent(RatingParent idRatingParent) {
		this.idRatingParent = idRatingParent;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
