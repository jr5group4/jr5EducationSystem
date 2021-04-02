package com.cg.educationsystem.entity;

import java.sql.Date;
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
@Table(name = "studentdetails")
public class StudentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	@Column(length = 30)
	private String firstName;
	
	@Column(length = 30)
	private String lastName;
	
	@Column(length = 30)
	private long phoneNumber;
	
	@Column(length = 30)
	private String studentEmailId;
	
	@Column
	private Date date;
	
	@OneToMany(mappedBy = "studentdetails",cascade = CascadeType.ALL)
	private List<Course> courses;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
