package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.MessageDto;
import com.cg.educationsystem.entity.Message;
import com.cg.educationsystem.service.MessageService;
import com.cg.educationsystem.utils.MessageNotFoundException;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageService messageService;
	
	@PostMapping("/addmessage")
	public ResponseEntity<String> addMessage(@RequestBody MessageDto message){
		messageService.addMessage(message);
		return new ResponseEntity<String>("Message added", HttpStatus.OK);
	}
	@GetMapping("/viewallmessage")
	public ResponseEntity<List<Message>> viewAllMessage(){
		List<Message> messageList = messageService.viewAllMessages();
		if(messageList.isEmpty()) {
			throw new MessageNotFoundException("No message available");
		}
		return new ResponseEntity<List<Message>>(messageList, HttpStatus.OK);
	}
	@GetMapping("/viewmessagebyid/messageId}")
	public ResponseEntity<Message> viewMessageById(@PathVariable int messageId){
		Message message = messageService.viewMessageById(messageId);
		if(message==null) {
			throw new MessageNotFoundException("No message found for message id: "+messageId);
		}
		return new ResponseEntity<Message>(message, HttpStatus.OK);
		
	}

}
