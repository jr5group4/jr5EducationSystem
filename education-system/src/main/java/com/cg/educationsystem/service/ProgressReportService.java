package com.cg.educationsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IProgressReportRepository;
import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.ProgressReport;

@Service
public class ProgressReportService implements IProgressReportService {
	@Autowired
	IProgressReportRepository progressRepository;
	@Autowired
	ICourseRepository courseRepository;

	@Override
	public List<ProgressReport> addProgressReport(ProgressReportDto progressreportdto) {
		Course course=courseRepository.getCourseById(progressreportdto.getCourseId());
		if(course!=null) {
			ProgressReport report=new ProgressReport();
			report.setProgressReportId(progressreportdto.getProgressReportId());
			report.setStudentMarks(progressreportdto.getStudentMarks());
			report.setStudentGrade(progressreportdto.getStudentGrade());
			report.setPresentForTest(progressreportdto.getPresentForTest());
			report.setStudentPercentage(progressreportdto.getStudentPercentage());
			report.setStudentResult(progressreportdto.getStudentResult());
			
			report.setCourse(course);
			progressRepository.save(report);
			return progressRepository.findAll();
		}
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

	@Override
	public List<ProgressReport> deleteReport(int reportId) {
		ProgressReport report=progressRepository.viewReportById(reportId);
		if(report!=null) {
			report.setCourse(null);
			progressRepository.save(report);
			progressRepository.deleteById(reportId);
			return progressRepository.findAll();
		}
		return null;
	}

	@Override
	public List<ProgressReport> updateReport(ProgressReportDto reportDto) {
		ProgressReport progressReport=progressRepository.viewReportById(reportDto.getProgressReportId());
		Course course=courseRepository.getCourseById(reportDto.getCourseId());
		if(progressReport!=null&&course!=null) {
			progressReport.setStudentMarks(reportDto.getStudentMarks());
			progressReport.setStudentGrade(reportDto.getStudentGrade());
			progressReport.setPresentForTest(reportDto.getPresentForTest());
			progressReport.setStudentPercentage(reportDto.getStudentPercentage());
			progressReport.setStudentResult(reportDto.getStudentResult());
			progressReport.setCourse(course);
			progressRepository.save(progressReport);
			return progressRepository.findAll();
		}
		return null;
	}

	@Override
	public List<ProgressReport> viewAllProgressReport() {
		return progressRepository.findAll();
	}
}
