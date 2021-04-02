package com.cg.educationsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="trainer")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainer_id;
	
	@Column(length=30)
	private String trainer_name;
	
	@Column(length=30)
	private long phone_number;
	
	@Column(length=30)
	private int trainer_experience;
	
	@Column(length=30)
	private String trainer_email_id;
	
	public String getTrainer_name() {
		return trainer_name;
	}
	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}
	public int getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public int getTrainer_experience() {
		return trainer_experience;
	}
	public void setTrainer_experience(int trainer_experience) {
		this.trainer_experience = trainer_experience;
	}
	public String getTrainer_email_id() {
		return trainer_email_id;
	}
	public void setTrainer_email_id(String trainer_email_id) {
		this.trainer_email_id = trainer_email_id;
	}

}
