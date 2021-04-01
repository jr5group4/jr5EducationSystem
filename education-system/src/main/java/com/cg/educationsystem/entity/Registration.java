package com.cg.educationsystem.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entity")
public class Registration {
	@Id
	private int student_id;
	@Column(length = 30)
	private String first_name;
	@Column(length = 30)
	private String last_name;
	@Column(length = 30)
	private int phone_number;
	@Column(length = 30)
	private String student_email_id;
	@Column
	private Date date;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public String getStudent_email_id() {
		return student_email_id;
	}
	public void setStudent_email_id(String student_email_id) {
		this.student_email_id = student_email_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
