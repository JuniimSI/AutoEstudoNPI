package com.example.service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Item;
import com.example.model.Role;
import com.example.model.Usuario;
import com.example.repository.RoleRepository;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Usuario findUsuarioByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Usuario findUsuarioByName(String nome){
		return repo.findByName(nome);
	}
	
	public void salvarUsuario(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		usuario.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		usuario.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		repo.save(usuario);
	}
	
	public List<Usuario> getTodosUsuarios(){
		return repo.findAll();
	}
}
