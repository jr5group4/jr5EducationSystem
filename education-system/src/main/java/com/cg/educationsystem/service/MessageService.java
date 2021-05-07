package com.cg.educationsystem.service;

import java.util.Collections;
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
	public List<Message> addMessage(MessageDto messageDto) {
		StudentDetails studentDetails = studentRepository.getStudentDetailsById(messageDto.getStudentId());
		if(studentDetails!=null) {
			Message message = new Message();
			message.setMessageId(messageDto.getMessageId());
			message.setMessageDescription(messageDto.getMessageDescription());
			message.setStudentDetails(studentDetails);
			messageRepository.save(message);
			return messageRepository.findAll();
		}
		return Collections.emptyList();
	}
	@Override
	public Message viewMessageById(int messageId) {
		return messageRepository.viewMessageById(messageId);
	}
	@Override
	public List<Message> viewAllMessages() {
		return messageRepository.findAll();
	}
	@Override
	public List<Message> deleteMessage(int messageId) {
		Message message=messageRepository.viewMessageById(messageId);
		if(message!=null) {
			message.setStudentDetails(null);
			messageRepository.save(message);
			messageRepository.deleteById(messageId);
			return messageRepository.findAll();
		}
		return Collections.emptyList();
	}
	@Override
	public List<Message> updateMessage(MessageDto messageDto) {
		Message message = messageRepository.viewMessageById(messageDto.getMessageId());
		StudentDetails studentDetails = studentRepository.getStudentDetailsById(messageDto.getStudentId());
		if(message!=null && studentDetails!=null) {
			message.setMessageDescription(messageDto.getMessageDescription());
			message.setStudentDetails(studentDetails);
			messageRepository.save(message);
			return messageRepository.findAll();
		}
		return Collections.emptyList();
	}
}
