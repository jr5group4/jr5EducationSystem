package com.cg.educationsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	private int payment_id;
	@Column(length=30)
	private int student_branch;
	@Column(length=30)
	private int course_id;
	@Column(length=30)
	private Date payment_date;
	@Column(length=30)
	private Date payment_due;
	@Column(length=30)
	private double fee_paid;
	@Column(length=30)
	private String fee_status;
	
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getStudent_branch() {
		return student_branch;
	}
	public void setStudent_branch(int student_branch) {
		this.student_branch = student_branch;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
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
	

}
