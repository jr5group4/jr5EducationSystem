package com.cg.educationsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.StudentDetails;

@Repository
public interface IStudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {
	@Query(value = "from studentdetails std where std.studentId=?1")
	public StudentDetails getStudentDetailsById(int studentId);

}

