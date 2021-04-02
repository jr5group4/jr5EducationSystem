package com.cg.educationsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{

}
