package com.social.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;
import com.social.util.Access;
import com.social.util.ListType;

@Entity
@Table(name = "list")
public class Lists {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idlist")
	private Long id;
	
	@Column(name = "name")
	private String name;
	

	@JoinTable(name = "listtitle", 
			joinColumns = {@JoinColumn(name = "idlist", referencedColumnName = "idlist") }, 
			inverseJoinColumns = {@JoinColumn(name = "idtitle", referencedColumnName = "idtitle") })
	@ManyToMany
	private List<Title> title;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idprofile")
	private Profile profile;

	@Column(name = "date")
	private DateTime date;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "access")
	private Access access;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ListType listType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Title> getTitle() {
		return title;
	}

	public void setTitle(List<Title> title) {
		this.title = title;
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

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public ListType getListType() {
		return listType;
	}

	public void setListType(ListType listType) {
		this.listType = listType;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
