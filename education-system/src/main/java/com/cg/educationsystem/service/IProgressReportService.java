package com.cg.educationsystem.service;

import java.util.List;
import com.cg.educationsystem.entity.ProgressReport;

public interface IProgressReportService {
	public String addProgressReport(ProgressReport progressreport);
	public List<ProgressReport> viewAllPreviousProgressReport();
	public List<ProgressReport> viewAllCurrentProgressReport();
	public ProgressReport viewProgressReportById(int progressId);
}
