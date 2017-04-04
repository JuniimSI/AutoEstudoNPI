package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Item;
import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository repo;

	public Usuario findUsuarioByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Usuario findUsuarioByName(String nome){
		return repo.findByName(nome);
	}
	
	public void salvarUsuario(Usuario usuario) {
		repo.save(usuario);
	}
	
	public List<Usuario> getTodosUsuarios(){
		return repo.findAll();
	}
}
