package com.cg.educationsystem.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	private int payment_id;
	
	//@Column(length=30)
	//private int student_branch;
	
	//@Column(length=30)
	//private int course_id;
	
	@Column(length=30)
	private Date payment_date;
	
	@Column(length=30)
	private Date payment_due;
	
	@Column(length=30)
	private double fee_paid;
	
	@Column(length=30)
	private String fee_status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private StudentDetails registration;
	
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
	public StudentDetails getRegistration() {
		return registration;
	}
	public void setRegistration(StudentDetails registration) {
		this.registration = registration;
	}
	
}
