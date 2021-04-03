package com.cg.educationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IProgressReportRepository;
import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.ProgressReport;

@Service
@Transactional
public class ProgressReportService implements IProgressReportService {
	@Autowired
	IProgressReportRepository progressRepository;
	ICourseRepository courseRepository;

	@Override
	public String addProgressReport(ProgressReportDto progressreportdto) {
		ProgressReport report=new ProgressReport();
		report.setProgressReportId(progressreportdto.getProgressReportId());
		report.setStudentMarks(progressreportdto.getStudentMarks());
		report.setStudentGrade(progressreportdto.getStudentGrade());
		report.setPresentForTest(progressreportdto.getPresentForTest());
		report.setStudentPercentage(progressreportdto.getStudentPercentage());
		report.setStudentResult(progressreportdto.getStudentResult());
		
		Course course=courseRepository.findById(progressreportdto.getCourseId()).get();
		report.setCourse(course);
		progressRepository.save(report);
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
