package com.cg.educationsystem.service;
import com.cg.educationsystem.dto.TrainerDto;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.entity.Trainer;

public interface ITrainerService {
	public String addTrainer(TrainerDto trainerdto);
	public String selectTrainer(TrainerDto trainerdto);
}
