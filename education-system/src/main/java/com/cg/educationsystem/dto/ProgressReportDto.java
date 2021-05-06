package com.cg.educationsystem.dto;

public class ProgressReportDto {
	private int progressReportId;
	private int studentMarks;
	private String studentGrade;
	private String presentForTest;
	private double studentPercentage;
	private String studentResult;
	private int courseId;
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public ProgressReportDto(int progressReportId, int studentMarks, String studentGrade, String presentForTest,
			double studentPercentage, String studentResult, int courseId) {
		super();
		this.progressReportId = progressReportId;
		this.studentMarks = studentMarks;
		this.studentGrade = studentGrade;
		this.presentForTest = presentForTest;
		this.studentPercentage = studentPercentage;
		this.studentResult = studentResult;
		this.courseId = courseId;
	}
	
}
