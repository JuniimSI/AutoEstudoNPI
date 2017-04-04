package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Null;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "usuario", referencedColumnName = "id")
	public Usuario usuario;
	private String name;

	@ManyToOne(optional = true)
	@JoinColumn(name = "id_emp", referencedColumnName = "id")
	private Emprestimo emp;
	
	
	public Item() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Emprestimo getEmp() {
		return emp;
	}

	public void setEmp(Emprestimo emp) {
		this.emp = emp;
	}

	public Item(Usuario proprietario, String name) {
		super();
		this.usuario = proprietario;
		this.name = name;
	}

	public Usuario getProprietario() {
		return usuario;
	}

	public void setProprietario(Usuario proprietario) {
		this.usuario = proprietario;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
