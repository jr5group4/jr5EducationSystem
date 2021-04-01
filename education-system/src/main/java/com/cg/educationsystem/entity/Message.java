package com.cg.educationsystem.entity;

import javax.persistence.Entity;

@Entity
public class Message {
	private int message_id;
	private String message_description;
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getMessage_description() {
		return message_description;
	}
	public void setMessage_description(String message_description) {
		this.message_description = message_description;
	}
	
}
