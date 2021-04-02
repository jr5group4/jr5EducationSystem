package com.cg.educationsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer> {
	
}
