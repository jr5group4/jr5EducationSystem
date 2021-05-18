package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.ProgressReport;

public interface IProgressReportService {
	//allows admin to add progress report of a student based on course
	public List<ProgressReport> addProgressReport(ProgressReportDto progressreportdto);
	//allows student/user to view progress reports of completed courses
	public List<ProgressReport> viewAllPreviousProgressReport(int studentId);
	//allows student/user to view progress reports of ongoing courses
	public List<ProgressReport> viewAllCurrentProgressReport(int studentId);
	//allows student/user to view particular report based on course
	public ProgressReport viewProgressReportById(int studentId,int courseId);
	//allows admin to delete progress report
	public List<ProgressReport> deleteReport(int reportId);
	//allows student/user to view all progress reports
	public List<ProgressReport> viewAllProgressReport();
	//allows admin to update progress reports
	public List<ProgressReport> updateReport(ProgressReportDto reportDto);
}
