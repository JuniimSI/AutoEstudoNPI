package com.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Usuario destino;
	
	@OneToOne
	private Usuario origem;

	@OneToOne
	private Item item;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Emprestimo(Usuario destino, Usuario origem, Item itens) {
		super();
		this.destino = destino;
		this.origem = origem;
		this.item = itens;
	}
	public Usuario getDestino() {
		return destino;
	}
	public void setDestino(Usuario destino) {
		this.destino = destino;
	}
	public Usuario getOrigem() {
		return origem;
	}
	public void setOrigem(Usuario origem) {
		this.origem = origem;
	}
	
	public Item getItens() {
		return item;
	}
	public void setItens(Item itens) {
		this.item = itens;
	}
	public Emprestimo() {
		super();
	}
	
	
	
			
}
