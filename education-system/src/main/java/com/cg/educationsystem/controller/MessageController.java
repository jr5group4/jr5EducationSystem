package com.cg.educationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.educationsystem.dto.MessageDto;
import com.cg.educationsystem.entity.Message;
import com.cg.educationsystem.service.MessageService;
import com.cg.educationsystem.utils.MessageNotFoundException;
import com.cg.educationsystem.utils.StudentDetailsNotFoundException;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageService messageService;
	
	@PostMapping("/add")
	public ResponseEntity<List<Message>> addMessage(@RequestBody MessageDto message){
		List<Message> messageList = messageService.addMessage(message);
		if(messageList==null) {
			throw new StudentDetailsNotFoundException("No student available for id: "+message.getStudentId());
		}
		return new ResponseEntity<>(messageList, HttpStatus.OK);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Message>> viewAllMessage(){
		List<Message> messageList = messageService.viewAllMessages();
		if(messageList.isEmpty()) {
			throw new MessageNotFoundException("No message available");
		}
		return new ResponseEntity<>(messageList, HttpStatus.OK);
	}
	@GetMapping("/getbyid/{messageId}")
	public ResponseEntity<Message> viewMessageById(@PathVariable int messageId){
		Message message = messageService.viewMessageById(messageId);
		if(message==null) {
			throw new MessageNotFoundException("No message found for message id: "+messageId);
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{messageId}")
	public ResponseEntity<List<Message>> deleteMessage(@PathVariable int messageId){
		List<Message> message = messageService.deleteMessage(messageId);
		if(message==null) {
			throw new MessageNotFoundException("No message found for message id: "+messageId);
		}
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<List<Message>> updateMessage(@RequestBody MessageDto message){
		List<Message> messageList = messageService.updateMessage(message);
		if(messageList==null) {
			throw new MessageNotFoundException("No message found for message id: "+message.getMessageId());
		}
		return new ResponseEntity<>(messageList, HttpStatus.OK);
	}
}
