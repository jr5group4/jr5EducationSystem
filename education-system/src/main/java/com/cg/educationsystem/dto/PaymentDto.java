package com.cg.educationsystem.dto;

import java.sql.Date;
public class PaymentDto {
	private int paymentId;
	private Date paymentDate;
	private Date paymentDue;
	private double feePaid;
	private String feeStatus;
	private int courseId;
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/*public PaymentDto(int paymentId, Date paymentDate, Date paymentDue, double feePaid, String feeStatus,
			int courseId) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentDue = paymentDue;
		this.feePaid = feePaid;
		this.feeStatus = feeStatus;
		this.courseId = courseId;
	}*/
	
}
