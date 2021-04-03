package com.cg.educationsystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.educationsystem.dao.ITrainerRepository;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.entity.Trainer;

@Service
@Transactional
public class TrainerService implements ITrainerService{
	@Autowired
	ITrainerRepository trainerRepository;
	
	@Override
	public String addTrainer(Trainer trainer) {
		trainerRepository.save(trainer);
		return null;
	}

	@Override
	public String selectTrainer(Trainer trainer,StudentDetails student) {
		if(trainerRepository.existsById(trainer.getTrainerId())) {
			Trainer newTrainer=trainerRepository.findById(trainer.getTrainerId()).get();
			newTrainer.setStudentdetails(student);
			trainerRepository.save(newTrainer);
		}
		return null;
	}
}
