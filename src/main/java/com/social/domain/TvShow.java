package com.social.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TvShow")
public class TvShow extends Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idTvShow")
	private long id;
	
	@OneToMany(targetEntity=Season.class, mappedBy="tvShow", fetch=FetchType.EAGER)
	//@JoinColumn(name = "idTvShow")
	private List<Season> seasons;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

}


