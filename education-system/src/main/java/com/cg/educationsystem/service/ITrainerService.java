package com.cg.educationsystem.service;
import java.util.List;

import com.cg.educationsystem.dto.TrainerDto;
import com.cg.educationsystem.entity.Trainer;

public interface ITrainerService {
	//allows admin to add trainer details
	public String addTrainer(TrainerDto trainerdto);
	//allows student/user to register trainer based on course
	public int selectTrainer(TrainerDto trainerdto);
	//allows admin to view all trainer details
	public List<Trainer> getAllTrainer();
	//allows admin to view individual trainer details
	public Trainer getTrainerById(int trainerId);
}
