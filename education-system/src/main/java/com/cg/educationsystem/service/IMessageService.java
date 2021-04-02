package com.cg.educationsystem.service;

import com.cg.educationsystem.entity.Message;

public interface IMessageService {
	public String addMessage(Message message);
	public Message viewMessageById(int messageId);
}
