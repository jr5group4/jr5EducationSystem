package com.cg.educationsystem.service;

import com.cg.educationsystem.entity.ProgressReport;

public interface IProgressReportService {
	public String addProgressReport(ProgressReport progressreport);
	public ProgressReport viewPreviousProgressReport(int studentId);
	public ProgressReport viewCurrentProgressReport(int studentId);
}
