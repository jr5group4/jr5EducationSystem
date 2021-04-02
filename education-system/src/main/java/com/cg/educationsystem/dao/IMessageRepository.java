package com.cg.educationsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.Message;

@Repository
public interface IMessageRepository extends JpaRepository<Message, Integer>{
	@Query(value = "from message msg where msg.studentId=?1")
	public Message viewMessageById(int studentId);
}
