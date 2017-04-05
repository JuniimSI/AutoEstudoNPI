package com.example.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> telefone;
	public static volatile SingularAttribute<Usuario, String> password;
	public static volatile ListAttribute<Usuario, Item> itens;
	public static volatile SingularAttribute<Usuario, String> endereco;
	public static volatile SingularAttribute<Usuario, String> data_nascimento;
	public static volatile SetAttribute<Usuario, Role> roles;
	public static volatile SingularAttribute<Usuario, String> name;
	public static volatile SingularAttribute<Usuario, Integer> active;
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, String> email;

}

