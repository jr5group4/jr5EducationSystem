package com.cg.educationsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {

}
