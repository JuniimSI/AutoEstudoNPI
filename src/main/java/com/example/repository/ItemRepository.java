package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Item;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Integer>{

	Item findByName(String nome);
	
}
