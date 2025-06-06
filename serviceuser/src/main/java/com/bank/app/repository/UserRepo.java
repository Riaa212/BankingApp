package com.bank.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.app.domain.UserEntity;

import jakarta.transaction.Transactional;

public interface UserRepo extends JpaRepository<UserEntity,Integer>
{

	@Transactional
	Optional<UserEntity> findByEmail(String email);
	
	@Query(value="select a from UserEntity a where a.requestToAcc=true")
	List<UserEntity> findUserTocreateAcc();
	
//	@Query(value="select a from UserEntity a ORDER BY a limit 5")
//	List<UserEntity> findAll();
	
	
}
