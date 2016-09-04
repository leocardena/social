package com.social.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.joda.time.DateTime;

@Entity
@Table(name = "Message")
public class Message {
	
	private long id;
	
	private Profile sender;
	
	private Profile receiver;
	
	private DateTime date;
	
	private Boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Profile getSender() {
		return sender;
	}

	public void setSender(Profile sender) {
		this.sender = sender;
	}

	public Profile getReceiver() {
		return receiver;
	}

	public void setReceiver(Profile receiver) {
		this.receiver = receiver;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
