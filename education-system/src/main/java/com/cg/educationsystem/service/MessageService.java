package com.cg.educationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.educationsystem.dao.IMessageRepository;
import com.cg.educationsystem.entity.Message;

@Service
public class MessageService {
	@Autowired
	IMessageRepository dao;
	public void addMessage(Message message) {
		dao.save(message);
	}
	public Message viewMessageById(int studentId) {
		return dao.viewMessageById(studentId);
	}
}
