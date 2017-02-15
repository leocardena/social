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
@Table(name = "episode")
public class Episode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idepisode")
	private Long idEpisode;
	
	@ManyToOne
	@JoinColumn(name = "idseason")
	private Season season;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "votes")
	private long votes;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "aired")
	private DateTime aired;
	
    @OneToOne
    @JoinColumn(name = "idcommentparent")
	private CommentParent commentParent;
    
    @OneToOne
    @JoinColumn(name = "idratingparent")
    private RatingParent ratingParent;
    
    public Episode() {}
    
    public Long getIdEpisode() {
		return idEpisode;
	}

	public void setIdEpisode(Long idEpisode) {
		this.idEpisode = idEpisode;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
