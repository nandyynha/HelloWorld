package br.com.apihelloworld.ws.model;

import java.io.Serializable;

public class User implements Serializable{

	private String id;
	private String nome;
	
	
	
	public User(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public User(String name) {
		this.nome=name;
	}
	public User() {
		User usuario = new User();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
