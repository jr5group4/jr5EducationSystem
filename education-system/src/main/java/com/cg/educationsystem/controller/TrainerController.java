package com.cg.educationsystem.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	@Autowired
	TrainerService trainerService;
	
	@PostMapping("/addtrainer")
	public ResponseEntity<String> addTrainer(@RequestBody TrainerDto trainerdto){
		String string=trainerService.addTrainer(trainerdto);
		return new ResponseEntity<String>("Trainer details added",HttpStatus.OK);
	}
	
	@PutMapping("/selecttrainer")
	public ResponseEntity<String> selectTrainer(@RequestBody TrainerDto trainerdto){
		String string=trainerService.selectTrainer(trainerdto);
		return new ResponseEntity<String>("Trainer Selected",HttpStatus.OK);
	}
	
	@GetMapping("/alltrainer")
	public ResponseEntity<List<Trainer>> getAllTrainer(){
		List<Trainer> trainerList=trainerService.getAllTrainer();
		return new ResponseEntity<List<Trainer>>(trainerList,HttpStatus.OK);
	}
	
	@GetMapping("/gettrainer/{trainerId}")
	public ResponseEntity<Trainer> getTrainerById(@PathVariable int trainerId){
		Trainer trainer=trainerService.getTrainerById(trainerId);
		return new ResponseEntity<Trainer>(trainer,HttpStatus.OK);
	}
}
