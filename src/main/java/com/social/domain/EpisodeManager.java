package com.social.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.social.util.EpisodeStatus;

@Entity
@Table(name = "episodemanager")
public class EpisodeManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idepisodemanager")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idprofile")
	private Profile profile;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idepisode")
	private Episode episode;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "episodestatus")
	private EpisodeStatus epidoseStatus;

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

	public Episode getEpisode() {
		return episode;
	}

	public void setEpisode(Episode episode) {
		this.episode = episode;
	}

	public EpisodeStatus getEpidoseStatus() {
		return epidoseStatus;
	}

	public void setEpidoseStatus(EpisodeStatus epidoseStatus) {
		this.epidoseStatus = epidoseStatus;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
