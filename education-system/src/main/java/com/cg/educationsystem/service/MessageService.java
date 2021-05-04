package com.cg.educationsystem.service;

import java.util.List;
import java.util.Optional;

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
		Optional<StudentDetails> studentOptional=studentRepository.findById(messageDto.getStudentId());
		Message message = new Message();
		if(studentOptional.isPresent()) {
			message.setMessageId(messageDto.getMessageId());
			message.setMessageDescription(messageDto.getMessageDescription());
			StudentDetails student=studentOptional.get();
			message.setStudentDetails(student);
			messageRepository.save(message);
		}	
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
		if(messageRepository.existsById(messageId)) {
			messageRepository.deleteById(messageId);
			return messageRepository.findAll();
		}
		return null;
	}
	@Override
	public List<Message> updateMessage(MessageDto messageDto) {
		Message message = messageRepository.viewMessageById(messageDto.getMessageId());
		StudentDetails studentDetails = studentRepository.getStudentDetailsById(messageDto.getStudentId());
		if(message!=null && studentDetails!=null) {
			message.setMessageDescription(messageDto.getMessageDescription());
			message.setStudentDetails(studentDetails);
			return messageRepository.findAll();
		}
		return null;
	}
}
