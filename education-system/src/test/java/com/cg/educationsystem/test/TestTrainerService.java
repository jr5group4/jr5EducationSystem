package com.cg.educationsystem.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.educationsystem.dao.ICourseRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dao.ITrainerRepository;
import com.cg.educationsystem.dto.TrainerDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.Payment;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.entity.Trainer;
import com.cg.educationsystem.service.TrainerService;

@RunWith(MockitoJUnitRunner.class)
public class TestTrainerService {
	@InjectMocks
	TrainerService trainerService;
	
	@Mock
	ITrainerRepository trainerDao;
	
	@Mock
	IStudentDetailsRepository studentDao;
	
	@Mock
	ICourseRepository courseDao;
	
	@Before
	public void init() {
		System.out.println("** before method ***");
		//MockitoAnnotations.initMocks(this); 
	}
	
	TrainerDto trainerDto=new TrainerDto(1, "Kumar", 9875642315l, 5, "kumar@gmail.com",1,1);
	StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
	Course course=new Course(1,"Java",3,Date.valueOf("2021-01-02"),Date.valueOf("2021-04-02"),student);
	Trainer trainer=new Trainer(1, "Kumar", 9875642315l, 5, "kumar@gmail.com", student, course);
	
	@Test
	public void testSelectTrainer() {
		Mockito.when(trainerDao.getTrainerById(trainerDto.getTrainerId())).thenReturn(trainer);
		Mockito.when(studentDao.getStudentDetailsById(trainerDto.getStudentId())).thenReturn(student);
		trainerService.selectTrainer(trainerDto);
		Mockito.verify(trainerDao,Mockito.times(1)).save(trainer);
	}
	@Test
	public void testDeleteTrainer() {
		Mockito.when(trainerDao.getTrainerById(1)).thenReturn(trainer);
		trainerService.deleteTrainer(1);
		Mockito.verify(trainerDao,Mockito.times(1)).deleteById(1);
	}
	
	@Test
	public void testGetAllTrainer() {
		List<Trainer> trainerList=new ArrayList<>();
		trainerList.add(new Trainer(1, "Kumar", 9875642315l, 5, "kumar@gmail.com", student, course));
		
		Mockito.when(trainerDao.findAll()).thenReturn(trainerList);
	    List<Trainer> list=trainerService.getAllTrainer();
		Assertions.assertEquals(1,list.size());
		Mockito.verify(trainerDao,Mockito.times(1)).findAll();
	}
	@Test
	public void testGetTrainerById() {
		Mockito.when(trainerDao.getTrainerById(1)).thenReturn(trainer);
		trainerService.getTrainerById(1);
		Mockito.verify(trainerDao,Mockito.times(1)).getTrainerById(1);
	}
	
	@Test
	public void testUpdateTrainer() {
		Mockito.when(courseDao.getCourseById(trainerDto.getCourseId())).thenReturn(course);
		Mockito.when(trainerDao.getTrainerById(trainerDto.getTrainerId())).thenReturn(trainer);
		Mockito.when(studentDao.getStudentDetailsById(trainerDto.getStudentId())).thenReturn(student);
		trainerService.updateTrainer(trainerDto);
		Mockito.verify(trainerDao,Mockito.times(1)).save(trainer);
	}
}
