package com.cg.educationsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.Trainer;

@Repository
public interface ITrainerRepository extends JpaRepository<Trainer,Integer>{
}
