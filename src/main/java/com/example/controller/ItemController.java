package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Item;
import com.example.service.ItemService;

@Controller
@RequestMapping(path="/itens/")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		System.out.println("ENTROU NO ITENS");
		ModelAndView model = new ModelAndView("itens");
		List<Item> itens = service.getTodosItems();
		model.addObject("itens", itens);
		
		return model;
				
	}
	
	@RequestMapping(path="/cadastro")
	public String irParaCadastro(){
		return "cadastroItem";
	}
	
	/*@RequestMapping(path="/{id}")
	public String detalhes(){
		return "detalhes_itens";
	}*/
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarItem(@RequestParam String nameItem, @RequestParam String nameUsuario ){
		System.out.println(nameItem + " + " + nameUsuario);
		service.salvarItem(nameItem,nameUsuario);
		
		return "redirect:/itens/";
	}

}
