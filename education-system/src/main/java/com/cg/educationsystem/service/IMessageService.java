package com.cg.educationsystem.service;

import java.util.List;

import com.cg.educationsystem.dto.MessageDto;
import com.cg.educationsystem.entity.Message;

public interface IMessageService {
	//allows admin to send message to student
	public void addMessage(MessageDto messageDto);
	//allows student/user to view message
	public Message viewMessageById(int messageId);
	//allows admin and student to view all messages
	public List<Message> viewAllMessages();
	
	public List<Message> deleteMessage(int messageId);
	
	public List<Message> updateMessage(MessageDto messageDto);
}
