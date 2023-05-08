package com.stockman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockman.model.CurrentUserSession;



public interface SessionDao extends JpaRepository<CurrentUserSession, Integer> {

	
	public  CurrentUserSession  findByUuid(String uuid);
}
