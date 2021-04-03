package com.cg.educationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.educationsystem.dao.IProgressReportRepository;
import com.cg.educationsystem.entity.ProgressReport;

@Service
@Transactional
public class ProgressReportService implements IProgressReportService {
	@Autowired
	IProgressReportRepository progressRepository;

	@Override
	public String addProgressReport(ProgressReport progressreport) {
		progressRepository.save(progressreport);
		return null;
	}

	@Override
	public List<ProgressReport> viewAllPreviousProgressReport() {
		return progressRepository.viewAllPreviousReport();
	}

	@Override
	public List<ProgressReport> viewAllCurrentProgressReport() {
		return progressRepository.viewAllCurrentReport();
	}

	@Override
	public ProgressReport viewProgressReportById(int progressId) {
		return progressRepository.viewReportById(progressId);
	}
}
