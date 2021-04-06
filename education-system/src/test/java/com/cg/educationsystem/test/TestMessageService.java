package com.cg.educationsystem.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.educationsystem.dao.IMessageRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dto.MessageDto;
import com.cg.educationsystem.entity.Course;
import com.cg.educationsystem.entity.Message;
import com.cg.educationsystem.entity.Payment;
import com.cg.educationsystem.entity.StudentDetails;
import com.cg.educationsystem.service.MessageService;
import com.cg.educationsystem.service.StudentDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class TestMessageService {
	
	@InjectMocks
	MessageService messageService;
	
	@InjectMocks
	StudentDetailsService studentDetailsService;
	
	@Mock
	IMessageRepository messageDao;
	
	@Mock
	IStudentDetailsRepository studentDetailsDao;
	
	@Test
	public void testViewMessageById() {
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		Message message=new Message(1,"Welcome to the course",student);
		
		Mockito.when(messageDao.viewMessageById(1)).thenReturn(message);
		Message newMessage=messageService.viewMessageById(1);
		Mockito.verify(messageDao,Mockito.times(1)).viewMessageById(1);
	}
	
	@Test
	public void testViewAllMessages() {
		List<Message> messageList=new ArrayList<>();
		StudentDetails student=new StudentDetails(1,"Ajay","Kumar",987054321,"ajay1234@gmail.com",Date.valueOf("1995-01-01"));
		messageList.add(new Message(1,"Welcome to the course",student));

		Mockito.when(messageDao.findAll()).thenReturn(messageList);
	    List<Message> list=messageService.viewAllMessages();
		Assertions.assertEquals(1,list.size());
		Mockito.verify(messageDao,Mockito.times(1)).findAll();
	}
}
