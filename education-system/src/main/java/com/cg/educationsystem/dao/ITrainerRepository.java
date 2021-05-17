package com.cg.educationsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.Trainer;

@Repository
public interface ITrainerRepository extends JpaRepository<Trainer,Integer>{
	@Query(value = "from Trainer trainer where trainer.trainerId=?1")
	public Trainer getTrainerById(int trainerId);
	@Query(value = "from Trainer trainer where trainer.course.courseId=?1 and trainer.student=null")
	public List<Trainer> getTrainerByCourse(int courseId);
}
