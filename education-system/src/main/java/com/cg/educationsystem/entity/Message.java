package com.cg.educationsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
	@Id
	private int message_id;
	
	@Column(length = 250)
	private String message_description;
	
	@OneToMany(mappedBy = "message",cascade = CascadeType.ALL)
	private List<StudentDetails> registration;
	
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
	public List<StudentDetails> getRegistration() {
		return registration;
	}
	public void setRegistration(List<StudentDetails> registration) {
		this.registration = registration;
	}
	
}
