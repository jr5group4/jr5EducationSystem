package com.cg.educationsystem.service;
import java.util.List;

import com.cg.educationsystem.dto.TrainerDto;
import com.cg.educationsystem.entity.Trainer;

public interface ITrainerService {
	//allows admin to add trainer details
	public List<Trainer> addTrainer(TrainerDto trainerdto);
	//allows student/user to register trainer based on course
	public List<Trainer> selectTrainer(int trainerId,int studentId);
	//allows admin to view all trainer details
	public List<Trainer> getAllTrainer();
	
	public List<Trainer> getTrainerByCourse(int courseId);
	//allows admin to view individual trainer details
	public Trainer getTrainerById(int trainerId);
	//allows admin to delete trainer details
	public List<Trainer> deleteTrainer(int trainerId);
	//allows admin to update trainer details
	public List<Trainer> updateTrainer(TrainerDto trainerDto);
}
