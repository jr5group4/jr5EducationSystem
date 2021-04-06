package com.cg.educationsystem.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dao.ITrainerRepository;
import com.cg.educationsystem.dto.TrainerDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.entity.Trainer;

@Service
public class TrainerService implements ITrainerService{
	@Autowired
	ITrainerRepository trainerRepository;
	@Autowired
	ICourseRepository courseRepository;
	@Autowired
	IStudentDetailsRepository studentRepository;
	
	@Override
	public String addTrainer(TrainerDto trainerdto) {
		Trainer trainer=new Trainer();
		trainer.setTrainerId(trainerdto.getTrainerId());
		trainer.setTrainerName(trainerdto.getTrainerName());
		trainer.setTrainerEmailId(trainerdto.getTrainerEmailId());
		trainer.setPhoneNumber(trainerdto.getPhoneNumber());
		trainer.setTrainerExperience(trainerdto.getTrainerExperience());
		
		Course course=courseRepository.getCourseById(trainerdto.getCourseId());
		trainer.setCourse(course);
		trainerRepository.save(trainer);
		return null;
	}

	@Override
	public int selectTrainer(TrainerDto trainerdto) {
		if(trainerRepository.existsById(trainerdto.getTrainerId())) {
			Trainer trainer=trainerRepository.findById(trainerdto.getTrainerId()).get();
			StudentDetails student=studentRepository.getStudentDetailsById(trainerdto.getStudentId());
			trainer.setStudent(student);
			
			trainerRepository.save(trainer);
			return 1;
		}
		return 0;
	}

	@Override
	public List<Trainer> getAllTrainer() {
		return trainerRepository.findAll();
	}

	@Override
	public Trainer getTrainerById(int trainerId) {
		return trainerRepository.getTrainerById(trainerId);
	}
}
