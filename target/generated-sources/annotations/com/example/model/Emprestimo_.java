package com.example.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Emprestimo.class)
public abstract class Emprestimo_ {

	public static volatile SingularAttribute<Emprestimo, Item> item;
	public static volatile SingularAttribute<Emprestimo, Usuario> origem;
	public static volatile SingularAttribute<Emprestimo, Long> id;
	public static volatile SingularAttribute<Emprestimo, Usuario> destino;

}

