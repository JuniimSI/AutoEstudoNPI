package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Usuario;
import com.example.service.UsuarioService;

@Controller
@RequestMapping(path="/usuarios/")
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("usuarios");
		List<Usuario> usuarios = service.getTodosUsuarios();
		model.addObject("usuarios", usuarios);
		
		return model;
	}
	
	/*@RequestMapping(path="/{id}")
	public String detalhes(){
		return "detalhes_usuarios";
	}*/
	
	@RequestMapping(path="/cadastro")
	public String irParaCadastro(){
		return "cadastroUsuario";
	}
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarItem(@RequestParam String nameUsuario, @RequestParam String telefoneUsuario, @RequestParam String senhaUsuario, @RequestParam String emailUsuario, @RequestParam String enderecoUsuario, @RequestParam String dataUsuario){
		System.out.println(emailUsuario + " + " + nameUsuario);
		Usuario u = new Usuario();
		
		u.setName(nameUsuario);
		u.setData_nascimento(dataUsuario);
		u.setEmail(emailUsuario);
		u.setEndereco(enderecoUsuario);
		u.setPassword(senhaUsuario);
		u.setTelefone(telefoneUsuario);
		u.setActive(0);
		service.salvarUsuario(u);
		return "redirect:/";
	}
	
}
