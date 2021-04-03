package com.cg.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.IMessageRepository;
import com.cg.educationsystem.entity.Message;

@Service
public class MessageService implements IMessageService{
	@Autowired
	IMessageRepository dao;
	
	@Override
	public void addMessage(Message message) {
		dao.save(message);
		
	}

	@Override
	public Message viewMessageById(int messageId) {
		return dao.viewMessageById(messageId);
	}
}
