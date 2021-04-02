package com.cg.educationsystem.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;
	
	//@Column(length=30)
	//private int student_branch;
	
	//@Column(length=30)
	//private int course_id;
	
	@Column
	private Date payment_date;
	
	@Column
	private Date payment_due;
	
	@Column(length=30)
	private double fee_paid;
	
	@Column(length=30)
	private String fee_status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private StudentDetails studentdetails;
	
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	public Date getPayment_due() {
		return payment_due;
	}
	public void setPayment_due(Date payment_due) {
		this.payment_due = payment_due;
	}
	public double getFee_paid() {
		return fee_paid;
	}
	public void setFee_paid(double fee_paid) {
		this.fee_paid = fee_paid;
	}
	public String getFee_status() {
		return fee_status;
	}
	public void setFee_status(String fee_status) {
		this.fee_status = fee_status;
	}
	public StudentDetails getStudentdetails() {
		return studentdetails;
	}
	public void setStudentdetails(StudentDetails studentdetails) {
		this.studentdetails = studentdetails;
	}
	
}
