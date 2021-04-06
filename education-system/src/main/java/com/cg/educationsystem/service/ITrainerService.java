package com.cg.educationsystem.service;
import java.util.List;

import com.cg.educationsystem.dto.TrainerDto;
import com.cg.educationsystem.entity.Trainer;

public interface ITrainerService {
	public String addTrainer(TrainerDto trainerdto);
	public int selectTrainer(TrainerDto trainerdto);
	public List<Trainer> getAllTrainer();
	public Trainer getTrainerById(int trainerId);
}
