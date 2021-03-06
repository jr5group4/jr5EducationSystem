package com.cg.educationsystem.service;
import java.util.Collections;
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
	public List<Trainer> addTrainer(Trainer trainer) {
			trainerRepository.save(trainer);
			return trainerRepository.findAll();
	}

	@Override
	public List<Trainer> selectTrainer(int trainerId,int studentId) {
		Trainer trainer=trainerRepository.getTrainerById(trainerId);
		StudentDetails student=studentRepository.getStudentDetailsById(studentId);
		if(trainer!=null&&student!=null) {
			trainer.setStudent(student);
			trainerRepository.save(trainer);
			return trainerRepository.findAll();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Trainer> getAllTrainer() {
		return trainerRepository.findAll();
	}

	@Override
	public Trainer getTrainerById(int trainerId) {
		return trainerRepository.getTrainerById(trainerId);
	}

	@Override
	public List<Trainer> deleteTrainer(int trainerId) {
		Trainer trainer=trainerRepository.getTrainerById(trainerId);
		if(trainer!=null) {
			trainer.setCourse(null);
			trainer.setStudent(null);
			trainerRepository.save(trainer);
			trainerRepository.deleteById(trainerId);
			return trainerRepository.findAll();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Trainer> updateTrainer(TrainerDto trainerDto) {
		Trainer trainer=trainerRepository.getTrainerById(trainerDto.getTrainerId());
		StudentDetails studentDetails=studentRepository.getStudentDetailsById(trainerDto.getStudentId());
		Course course=courseRepository.getCourseById(trainerDto.getCourseId());
		if(trainer!=null) {
			trainer.setTrainerName(trainerDto.getTrainerName());
			trainer.setPhoneNumber(trainerDto.getPhoneNumber());
			trainer.setTrainerExperience(trainerDto.getTrainerExperience());
			trainer.setTrainerEmailId(trainerDto.getTrainerEmailId());
			trainer.setStudent(studentDetails);
			trainer.setCourse(course);
			trainerRepository.save(trainer);
			return trainerRepository.findAll();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Trainer> getTrainerByCourse(int courseId) {
		List<Trainer> trainerList= trainerRepository.getTrainerByCourse(courseId);
		/*for(Trainer trainer:trainerList) {
			if(trainer.getStudent()!=null)
				return Collections.emptyList();
		}*/
		return trainerList;
	}

	@Override
	public List<Trainer> getAvailableTrainers() {
		return trainerRepository.getAvailableTrainers();
	}
}
