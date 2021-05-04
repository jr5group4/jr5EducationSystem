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
	public String addProgressReport(ProgressReportDto progressreportdto) {
		Optional<Course> courseOptional=courseRepository.findById(progressreportdto.getCourseId());
		if(courseOptional.isPresent()) {
			ProgressReport report=new ProgressReport();
			report.setProgressReportId(progressreportdto.getProgressReportId());
			report.setStudentMarks(progressreportdto.getStudentMarks());
			report.setStudentGrade(progressreportdto.getStudentGrade());
			report.setPresentForTest(progressreportdto.getPresentForTest());
			report.setStudentPercentage(progressreportdto.getStudentPercentage());
			report.setStudentResult(progressreportdto.getStudentResult());
			
			Course course=courseOptional.get();
			report.setCourse(course);
			progressRepository.save(report);
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
	public int deleteReport(int reportId) {
		if(progressRepository.existsById(reportId)) {
			progressRepository.deleteById(reportId);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateReport(ProgressReportDto reportDto) {
		ProgressReport progressReport=progressRepository.viewReportById(reportDto.getProgressReportId());
		Course course=courseRepository.getCourseById(reportDto.getCourseId());
		if(progressReport!=null&&course!=null) {
			progressReport.setStudentMarks(reportDto.getStudentMarks());
			progressReport.setStudentGrade(reportDto.getStudentGrade());
			progressReport.setPresentForTest(reportDto.getPresentForTest());
			progressReport.setStudentPercentage(reportDto.getStudentPercentage());
			progressReport.setStudentResult(reportDto.getStudentResult());
			progressReport.setCourse(course);
			return 1;
		}
		return 0;
	}
}
