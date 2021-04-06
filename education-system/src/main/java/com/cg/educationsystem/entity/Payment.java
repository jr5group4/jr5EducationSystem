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
	private int paymentId;
	
	@Column
	private Date paymentDate;
	
	@Column
	private Date paymentDue;
	
	@Column(length=30)
	private double feePaid;
	
	@Column(length=30)
	private String feeStatus;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "courseId")
	private Course course;
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getPaymentDue() {
		return paymentDue;
	}

	public void setPaymentDue(Date paymentDue) {
		this.paymentDue = paymentDue;
	}

	public double getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(double feePaid) {
		this.feePaid = feePaid;
	}

	public String getFeeStatus() {
		return feeStatus;
	}
	
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}

	public Payment(int paymentId, Date paymentDate, Date paymentDue, double feePaid, String feeStatus, Course course) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentDue = paymentDue;
		this.feePaid = feePaid;
		this.feeStatus = feeStatus;
		this.course = course;
	}
	public Payment() {
		
	}
}
