package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Emprestimo;
import com.example.model.Item;
import com.example.model.Usuario;
import com.example.service.EmprestimoService;
import com.example.service.ItemService;
import com.example.service.UsuarioService;

@Controller
@RequestMapping(path="/emprestimos/")
public class EmprestimoController {

	
	@Autowired
	EmprestimoService service;
	
	@Autowired
	UsuarioService serviceUsuario;
	
	@Autowired
	ItemService serviceItem;
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("emprestimos");
		List<Emprestimo> emprestimos = service.getTodosEmprestimos();
		model.addObject("emprestimos", emprestimos);
		return model;
	}
	
	@RequestMapping(path="/cadastro")
	public String irParaCadastro(){
		return "cadastroEmprestimo";
	}
	
	
	/*@RequestMapping(path="/{id}")
	public String detalhes(){
		return "detalhes_emprestimos";
	}*/
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarEmprestimo(@RequestParam String origem, @RequestParam String destino, @RequestParam String item ){
		System.out.println(origem + " " + destino);
		Usuario usuarioOrigem = serviceUsuario.findUsuarioByName(origem);
		Usuario usuarioDestino = serviceUsuario.findUsuarioByName(destino);
		Item itemz = serviceItem.findByName(item);
		service.salvarEmprestimo(usuarioOrigem, usuarioDestino, itemz);
		
		return "redirect:/";
	}

	
}
