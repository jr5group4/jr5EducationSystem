package com.cg.educationsystem.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
		List<Course> courseList=new ArrayList<Course>();
		List<Integer> courseIdList=trainerdto.getCourseIdList();
		for(Integer courseId:courseIdList) {
			Course course=courseRepository.findById(courseId).get();
			courseList.add(course);
		}
		trainer.setCourseList(courseList);
		trainerRepository.save(trainer);
		return null;
	}

	@Override
	public String selectTrainer(TrainerDto trainerdto) {
		if(trainerRepository.existsById(trainerdto.getTrainerId())) {
			Trainer trainer=trainerRepository.findById(trainerdto.getTrainerId()).get();
			StudentDetails student=studentRepository.findById(trainerdto.getStudentId()).get();
			trainer.setStudentdetails(student);
			
			trainerRepository.save(trainer);
		}
		return null;
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
