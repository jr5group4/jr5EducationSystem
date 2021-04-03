package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.MessageDto;
import com.cg.educationsystem.entity.Message;

public interface IMessageService {
	public void addMessage(MessageDto messageDto);
	public Message viewMessageById(int messageId);
	public List<Message> viewAllMessages();
}
