package com.cg.educationsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.ProgressReport;

@Repository
public interface IProgressReportRepository extends JpaRepository<ProgressReport, Integer> {

}
