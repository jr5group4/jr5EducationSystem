package com.cg.educationsystem.entity;

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
@Table(name = "progressreport")
public class ProgressReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int progressReportId;
	
	@Column(length = 3)
	private int studentMarks;
	
	@Column(length = 10)
	private String studentGrade;
	
	@Column(length = 10)
	private String presentForTest;
	
	@Column(length = 3)
	private double studentPercentage;
	
	@Column(length = 5)
	private String studentResult;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="courseId")
	private Course course;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	private StudentDetails student;
	
	public StudentDetails getStudent() {
		return student;
	}
	public void setStudent(StudentDetails student) {
		this.student = student;
	}
	public int getProgressReportId() {
		return progressReportId;
	}
	public void setProgressReportId(int progressReportId) {
		this.progressReportId = progressReportId;
	}
	public int getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}
	public String getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}
	public String getPresentForTest() {
		return presentForTest;
	}
	public void setPresentForTest(String presentForTest) {
		this.presentForTest = presentForTest;
	}
	public double getStudentPercentage() {
		return studentPercentage;
	}
	public void setStudentPercentage(double studentPercentage) {
		this.studentPercentage = studentPercentage;
	}
	public String getStudentResult() {
		return studentResult;
	}
	public void setStudentResult(String studentResult) {
		this.studentResult = studentResult;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public ProgressReport(int progressReportId, int studentMarks, String studentGrade, String presentForTest,
			double studentPercentage, String studentResult, Course course) {
		super();
		this.progressReportId = progressReportId;
		this.studentMarks = studentMarks;
		this.studentGrade = studentGrade;
		this.presentForTest = presentForTest;
		this.studentPercentage = studentPercentage;
		this.studentResult = studentResult;
		this.course = course;
	}
	public ProgressReport() {
		
	}
}
