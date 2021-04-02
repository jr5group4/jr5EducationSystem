package com.cg.educationsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	private int course_id;
	
	@Column(length=30)
	private String course_name;
	
	@Column(length=30)
	private int duration;
	
	@Column(length=30)
	private Date start_date;
	
	@Column(length=30)
	private Date end_date;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Registration registration;
	
	@ManyToMany(targetEntity = Trainer.class, cascade = { CascadeType.ALL }) 
	@JoinTable(name = "course_trainer",   
    joinColumns = { @JoinColumn(name = "course_id") },   
    inverseJoinColumns = { @JoinColumn(name = "trainer_id") })
	private List<Trainer> trainer;
	
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

}
