package com.social.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private long id;

	@Column(name = "idprofile", nullable = false)
	private Long profile;

	@Column(name = "name")
	private String name;

	@JoinTable(name = "listtitle", joinColumns = {
			@JoinColumn(name = "idlist", referencedColumnName = "idlist") }, inverseJoinColumns = {
					@JoinColumn(name = "idtitle", referencedColumnName = "idtitle") })
	@ManyToMany
	private Set<Title> titles = new HashSet<Title>();

	@Column(name = "date")
	private DateTime date;

	@Enumerated(EnumType.STRING)
	@Column(name = "access")
	private Access access;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private ListType listType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getProfile() {
		return profile;
	}

	public void setProfile(Long profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Title> getTitles() {
		return titles;
	}

	public void setTitles(Set<Title> titles) {
		this.titles = titles;
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
