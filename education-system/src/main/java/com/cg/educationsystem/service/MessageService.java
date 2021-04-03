package com.cg.educationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.educationsystem.dao.IMessageRepository;
import com.cg.educationsystem.dao.IStudentDetailsRepository;
import com.cg.educationsystem.dto.MessageDto;
import com.cg.educationsystem.entity.Message;
import com.cg.educationsystem.entity.StudentDetails;

@Service
@Transactional
public class MessageService implements IMessageService{
	@Autowired
	IMessageRepository messageRepository;
	@Autowired
	IStudentDetailsRepository studentRepository;
	
	@Override
	public void addMessage(MessageDto messageDto) {
		Message message = new Message();
		message.setMessageId(messageDto.getMessageId());
		message.setMessageDescription(messageDto.getMessageDescription());
		StudentDetails student=studentRepository.findById(messageDto.getStudentId()).get();
		message.setStudentDetails(student);
		messageRepository.save(message);	
	}
	@Override
	public Message viewMessageById(int messageId) {
		return messageRepository.viewMessageById(messageId);
	}
	@Override
	public List<Message> viewAllMessages() {
		return messageRepository.findAll();
	}
}
