package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.ProgressReport;

public interface IProgressReportService {
	public String addProgressReport(ProgressReportDto progressreportdto);
	public List<ProgressReport> viewAllPreviousProgressReport();
	public List<ProgressReport> viewAllCurrentProgressReport();
	public ProgressReport viewProgressReportById(int progressId);
}
