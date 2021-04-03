package com.cg.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.educationsystem.dao.IMessageRepository;
import com.cg.educationsystem.dto.MessageDto;
import com.cg.educationsystem.entity.Message;

@Service
@Transactional
public class MessageService implements IMessageService{
	@Autowired
	IMessageRepository messageRepository;
	
	@Override
	public void addMessage(MessageDto messageDto) {
		Message message = new Message();
		message.setMessageId(messageDto.getMessageId());
		message.setMessageDescription(messageDto.getMessageDescription());
		messageRepository.save(message);	
	}
	@Override
	public Message viewMessageById(int messageId) {
		return messageRepository.viewMessageById(messageId);
	}
}
