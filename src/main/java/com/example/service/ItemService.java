package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Item;
import com.example.model.Usuario;
import com.example.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository repo;
	
	public Item findByName(String name){
		return repo.findByName(name);
	}
	
	public Item salvarItem (String nome, String dono){
		System.out.println(nome+ " "+ dono);
		Item item = new Item();
		item.setName(nome);
		Usuario proprietario = new Usuario();
		proprietario.setId((long) 1);
		proprietario.setName(dono);
		proprietario.setActive(0);
		item.setProprietario(proprietario);
		repo.save(item);
		return item;		
	}
	
	public List<Item> getTodosItems(){
		return repo.findAll();
	}
	

	
}
