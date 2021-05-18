package com.cg.educationsystem.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IProgressReportRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dto.ProgressReportDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.ProgressReport;
import com.cg.educationsystem.entity.StudentDetails;

@Service
public class ProgressReportService implements IProgressReportService {
	@Autowired
	IProgressReportRepository progressRepository;
	@Autowired
	ICourseRepository courseRepository;
	@Autowired
	IStudentDetailsRepository studentRepository;
	
	@Override
	public List<ProgressReport> addProgressReport(ProgressReportDto progressreportdto) {
		Course course=courseRepository.getCourseById(progressreportdto.getCourseId());
		StudentDetails student=studentRepository.getStudentDetailsById(progressreportdto.getStudentId());
		if(course!=null&&student!=null) {
			ProgressReport report=new ProgressReport();
			report.setProgressReportId(progressreportdto.getProgressReportId());
			report.setStudentMarks(progressreportdto.getStudentMarks());
			report.setStudentGrade(progressreportdto.getStudentGrade());
			report.setPresentForTest(progressreportdto.getPresentForTest());
			report.setStudentPercentage(progressreportdto.getStudentPercentage());
			report.setStudentResult(progressreportdto.getStudentResult());
			
			report.setCourse(course);
			report.setStudent(student);
			progressRepository.save(report);
			return progressRepository.findAll();
		}
		return Collections.emptyList();
	}

	@Override
	public List<ProgressReport> viewAllPreviousProgressReport(int studentId) {
		return progressRepository.viewAllPreviousReport(studentId);
	}

	@Override
	public List<ProgressReport> viewAllCurrentProgressReport(int studentId) {
		return progressRepository.viewAllCurrentReport(studentId);
	}

	@Override
	public ProgressReport viewProgressReportById(int studentId,int courseId) {
		return progressRepository.viewReportById(studentId,courseId);
	}

	@Override
	public List<ProgressReport> deleteReport(int reportId) {
		ProgressReport report=progressRepository.findById(reportId).get();
		if(report!=null) {
			report.setCourse(null);
			report.setStudent(null);
			progressRepository.save(report);
			progressRepository.deleteById(reportId);
			return progressRepository.findAll();
		}
		return Collections.emptyList();
	}

	@Override
	public List<ProgressReport> updateReport(ProgressReportDto reportDto) {
		ProgressReport progressReport=progressRepository.findById(reportDto.getProgressReportId()).get();
		Course course=courseRepository.getCourseById(reportDto.getCourseId());
		StudentDetails student=studentRepository.getStudentDetailsById(reportDto.getStudentId());
		if(progressReport!=null&&course!=null&&student!=null) {
			progressReport.setStudentMarks(reportDto.getStudentMarks());
			progressReport.setStudentGrade(reportDto.getStudentGrade());
			progressReport.setPresentForTest(reportDto.getPresentForTest());
			progressReport.setStudentPercentage(reportDto.getStudentPercentage());
			progressReport.setStudentResult(reportDto.getStudentResult());
			
			progressReport.setCourse(course);
			progressReport.setStudent(student);
			progressRepository.save(progressReport);
			return progressRepository.findAll();
		}
		return Collections.emptyList();
	}

	@Override
	public List<ProgressReport> viewAllProgressReport() {
		return progressRepository.findAll();
	}
}
