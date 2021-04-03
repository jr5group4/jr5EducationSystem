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

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageService messageService;
	@PostMapping
	public ResponseEntity<String> addMessage(@RequestBody MessageDto message){
		messageService.addMessage(message);
		return new ResponseEntity<String>("Message added", HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<Message>> viewAllMessage(){
		List<Message> messageList = messageService.viewAllMessages();
		return new ResponseEntity<List<Message>>(messageList, HttpStatus.OK);
	}
	/*@GetMapping("/viewmessagebyid")
	public ResponseEntity<Message> viewMessageById(@RequestBody int messageId){
		Message messageList = messageService.viewMessageById(messageId);
		return new ResponseEntity<Message>(, HttpStatus.OK);
		
	}*/

}
