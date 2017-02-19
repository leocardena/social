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
@Table(name = "episode")
public class Episode implements Serializable {
	
	private static final long serialVersionUID = -712042223105756506L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idepisode")
	private Long idEpisode;
	
	@Column(name = "idseason")
	private Long season;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "number")
	private Integer number;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "aired")
	private DateTime aired;
	
    @OneToOne
    @JoinColumn(name = "idcommentparent")
	private CommentParent commentParent;
    
    @OneToOne
    @JoinColumn(name = "idratingparent")
    private RatingParent ratingParent;
    
	public Episode createFrom(com.social.trakt.model.Episode traktEpisode, Long idSeason) {
		Episode episode = new Episode();
		episode.setAired(traktEpisode.getFirstAired() != null ? new DateTime(traktEpisode.getFirstAired()) : null);
		episode.setName(traktEpisode.getTitle() != null ? traktEpisode.getTitle() : null);
		episode.setNumber(traktEpisode.getNumber());
		episode.setSeason(idSeason);
		
		return episode;
	}
    
    public Episode() {}
    
    public Long getIdEpisode() {
		return idEpisode;
	}

	public void setIdEpisode(Long idEpisode) {
		this.idEpisode = idEpisode;
	}

	public Long getSeason() {
		return season;
	}

	public void setSeason(Long season) {
		this.season = season;
	}

	public DateTime getAired() {
		return aired;
	}

	public void setAired(DateTime aired) {
		this.aired = aired;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CommentParent getCommentParent() {
		return commentParent;
	}

	public void setCommentParent(CommentParent commentParent) {
		this.commentParent = commentParent;
	}

	public RatingParent getRatingParent() {
		return ratingParent;
	}

	public void setRatingParent(RatingParent ratingParent) {
		this.ratingParent = ratingParent;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aired == null) ? 0 : aired.hashCode());
		result = prime * result + ((commentParent == null) ? 0 : commentParent.hashCode());
		result = prime * result + ((idEpisode == null) ? 0 : idEpisode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((ratingParent == null) ? 0 : ratingParent.hashCode());
		result = prime * result + ((season == null) ? 0 : season.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Episode other = (Episode) obj;
		if (aired == null) {
			if (other.aired != null)
				return false;
		} else if (!aired.equals(other.aired))
			return false;
		if (commentParent == null) {
			if (other.commentParent != null)
				return false;
		} else if (!commentParent.equals(other.commentParent))
			return false;
		if (idEpisode == null) {
			if (other.idEpisode != null)
				return false;
		} else if (!idEpisode.equals(other.idEpisode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (ratingParent == null) {
			if (other.ratingParent != null)
				return false;
		} else if (!ratingParent.equals(other.ratingParent))
			return false;
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
