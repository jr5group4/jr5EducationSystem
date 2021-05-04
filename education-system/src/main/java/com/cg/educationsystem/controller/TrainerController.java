package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.CourseDto;
import com.cg.educationsystem.dto.TrainerDto;
import com.cg.educationsystem.entity.Trainer;
import com.cg.educationsystem.service.TrainerService;
import com.cg.educationsystem.utils.CourseNotFoundException;
import com.cg.educationsystem.utils.TrainerNotFoundException;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	@Autowired
	TrainerService trainerService;
	
	@PostMapping("/addtrainer")
	public ResponseEntity<String> addTrainer(@RequestBody TrainerDto trainerdto){
		trainerService.addTrainer(trainerdto);
		return new ResponseEntity<>("Trainer details added",HttpStatus.OK);
	}
	
	@PutMapping("/selecttrainer")
	public ResponseEntity<String> selectTrainer(@RequestBody TrainerDto trainerdto){
		int number=trainerService.selectTrainer(trainerdto);
		if(number==0) {
			throw new TrainerNotFoundException("No Trainer found for trainer Id : "+trainerdto.getTrainerId());
		}
		return new ResponseEntity<>("Trainer Selected",HttpStatus.OK);
	}
	
	@GetMapping("/getalltrainers")
	public ResponseEntity<List<Trainer>> getAllTrainer(){
		List<Trainer> trainerList=trainerService.getAllTrainer();
		if(trainerList.isEmpty()) {
			throw new TrainerNotFoundException("No Trainer found ");
		}
		return new ResponseEntity<>(trainerList,HttpStatus.OK);
	}
	
	@GetMapping("/gettrainerbyid/{trainerId}")
	public ResponseEntity<Trainer> getTrainerById(@PathVariable int trainerId){
		Trainer trainer=trainerService.getTrainerById(trainerId);
		if(trainer==null) {
			throw new TrainerNotFoundException("No Trainer found for trainer Id : "+trainerId);
		}
		return new ResponseEntity<>(trainer,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletetrainer/{trainerId}")
	public ResponseEntity<String> deleteTrainer(@PathVariable int trainerId){
		int number=trainerService.deleteTrainer(trainerId);
		if(number==0) {
			throw new TrainerNotFoundException("No trainer found with the specified trainer id "+trainerId);
		}
		return new ResponseEntity<>("Trainer deleted",HttpStatus.OK);
	}
	
	@PutMapping("/updatetrainer")
	public ResponseEntity<String> updateTrainer(@RequestBody TrainerDto trainerDto){
		int number=trainerService.updateTrainer(trainerDto);
		if(number==0) {
			throw new TrainerNotFoundException("No Trainer Found for Trainer Id : "+trainerDto.getTrainerId());
		}
		return new ResponseEntity<>("Trainer Updated",HttpStatus.OK);
	}
}
