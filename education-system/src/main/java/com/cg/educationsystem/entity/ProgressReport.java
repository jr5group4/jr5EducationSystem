package com.cg.educationsystem.entity;

import javax.persistence.Entity;

@Entity
public class ProgressReport {
	private int progress_report_id;
	private int student_marks;
	private String student_grade;
	private String present_for_test;
	private double student_percentage;
	private String student_result;
	public int getProgress_report_id() {
		return progress_report_id;
	}
	public void setProgress_report_id(int progress_report_id) {
		this.progress_report_id = progress_report_id;
	}
	public int getStudent_marks() {
		return student_marks;
	}
	public void setStudent_marks(int student_marks) {
		this.student_marks = student_marks;
	}
	public String getStudent_grade() {
		return student_grade;
	}
	public void setStudent_grade(String student_grade) {
		this.student_grade = student_grade;
	}
	public String getPresent_for_test() {
		return present_for_test;
	}
	public void setPresent_for_test(String present_for_test) {
		this.present_for_test = present_for_test;
	}
	public double getStudent_percentage() {
		return student_percentage;
	}
	public void setStudent_percentage(double student_percentage) {
		this.student_percentage = student_percentage;
	}
	public String getStudent_result() {
		return student_result;
	}
	public void setStudent_result(String student_result) {
		this.student_result = student_result;
	}
	
}
