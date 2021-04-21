package com.cg.educationsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.educationsystem.entity.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login,Integer> {
	@Query(value="from Login login where login.userId=?1 and login.userPassword=?2")
	public Login validate(String userId,String userPassword);
}
