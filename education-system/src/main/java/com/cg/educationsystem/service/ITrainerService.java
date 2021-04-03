package com.cg.educationsystem.service;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.entity.Trainer;

public interface ITrainerService {
	public String addTrainer(Trainer trainer);
	public String selectTrainer(Trainer trainer,StudentDetails student);
}
