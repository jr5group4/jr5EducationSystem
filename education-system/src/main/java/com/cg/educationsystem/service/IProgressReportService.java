package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.ProgressReport;

public interface IProgressReportService {
	//allows admin to add progress report of a student based on course
	public String addProgressReport(ProgressReportDto progressreportdto);
	//allows student/user to view progress reports of completed courses
	public List<ProgressReport> viewAllPreviousProgressReport();
	//allows student/user to view progress reports of ongoing courses
	public List<ProgressReport> viewAllCurrentProgressReport();
	//allows student/user to view perticular report based on course
	public ProgressReport viewProgressReportById(int progressId);
	//allows admin to delete progress report
	public int deleteReport(int reportId);
}
