package com.cg.educationsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{
	@Query(value = "from Payment payment where payment.student.studentId=?1 and payment.course.courseId=?2")
	public List<Payment> getPaymentById(int studentId,int courseId);
}
