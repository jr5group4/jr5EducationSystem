package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.TrainerDto;
import com.cg.educationsystem.entity.Trainer;
import com.cg.educationsystem.service.TrainerService;
import com.cg.educationsystem.utils.TrainerNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/trainer")
public class TrainerController {
	@Autowired
	TrainerService trainerService;
	
	@PostMapping("/add")
	public ResponseEntity<List<Trainer>> addTrainer(@RequestBody TrainerDto trainerdto){
		List<Trainer> trainer=trainerService.addTrainer(trainerdto);
		if(trainer.isEmpty()) {
			throw new TrainerNotFoundException("Trainer not available for Id: "+trainerdto.getTrainerId());
		}
		return new ResponseEntity<>(trainer,HttpStatus.OK);
	}
	
	@PutMapping("/register/{trainerId}/{studentId}")
	public ResponseEntity<List<Trainer>> selectTrainer(@PathVariable int trainerId,@PathVariable int studentId){
		List<Trainer> trainer=trainerService.selectTrainer(trainerId,studentId);
		if(trainer.isEmpty()) {
			throw new TrainerNotFoundException("No Trainer found for trainer Id : "+trainerId);
		}
		return new ResponseEntity<>(trainer,HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Trainer>> getAllTrainer(){
		List<Trainer> trainerList=trainerService.getAllTrainer();
		if(trainerList.isEmpty()) {
			throw new TrainerNotFoundException("No Trainer found ");
		}
		return new ResponseEntity<>(trainerList,HttpStatus.OK);
	}
	@GetMapping("/getbycourse/{courseId}")
	public ResponseEntity<List<Trainer>> getTrainerByCourse(@PathVariable int courseId){
		List<Trainer> trainerList=trainerService.getTrainerByCourse(courseId);
		if(trainerList.isEmpty()) {
			throw new TrainerNotFoundException("No Trainer found ");
		}
		return new ResponseEntity<>(trainerList,HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{trainerId}")
	public ResponseEntity<Trainer> getTrainerById(@PathVariable("trainerId") int trainerId){
		Trainer trainer=trainerService.getTrainerById(trainerId);
		if(trainer==null) {
			throw new TrainerNotFoundException("No Trainer found for trainer Id : "+trainerId);
		}
		return new ResponseEntity<>(trainer,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{trainerId}")
	public ResponseEntity<List<Trainer>> deleteTrainer(@PathVariable int trainerId){
		List<Trainer> trainer=trainerService.deleteTrainer(trainerId);
		if(trainer.isEmpty()) {
			throw new TrainerNotFoundException("No trainer found with the specified trainer id "+trainerId);
		}
		return new ResponseEntity<>(trainer,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<List<Trainer>> updateTrainer(@RequestBody TrainerDto trainerDto){
		List<Trainer> trainer=trainerService.updateTrainer(trainerDto);
		if(trainer.isEmpty()) {
			throw new TrainerNotFoundException("No Trainer Found for Trainer Id : "+trainerDto.getTrainerId());
		}
		return new ResponseEntity<>(trainer,HttpStatus.OK);
	}
}
