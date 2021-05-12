package com.cg.educationsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.ProgressReport;

@Repository
public interface IProgressReportRepository extends JpaRepository<ProgressReport, Integer> {
	@Query(value = "from ProgressReport report where report.course.endDate<current_date and report.student.studentId=?1")
	public List<ProgressReport> viewAllPreviousReport(int studentId);
	@Query(value = "from ProgressReport report where report.course.endDate>current_date and report.student.studentId=?1")
	public List<ProgressReport> viewAllCurrentReport(int studentId);
	@Query(value = "from ProgressReport report where report.progressReportId=?1")
	public ProgressReport viewReportById(int progressId);
}
