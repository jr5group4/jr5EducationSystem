package com.cg.educationsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.StudentDetails;

@Repository
public interface IStudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {
	public StudentDetails getStudentDetailsById(int id);

}
