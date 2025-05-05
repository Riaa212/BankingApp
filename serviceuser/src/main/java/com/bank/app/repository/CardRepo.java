package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.domain.Card;

public interface CardRepo extends JpaRepository<Card,Integer>
{

}
