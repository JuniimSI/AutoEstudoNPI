package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Emprestimo;
import com.example.model.Item;
import com.example.model.Usuario;
import com.example.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository repo;
	
	public Emprestimo salvarEmprestimo(Usuario origem, Usuario destino, Item item){
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDestino(destino);
		emprestimo.setOrigem(origem);
		emprestimo.setItens(item);
		repo.save(emprestimo);
		return emprestimo;
	}
	public List<Emprestimo> getTodosEmprestimos(){
		return repo.findAll();
	}

}
