package com.cg.educationsystem.service;

import com.cg.educationsystem.entity.Message;

public interface IMessageService {
	public void addMessage(Message message);
	public Message viewMessageById(int studentId);
}
