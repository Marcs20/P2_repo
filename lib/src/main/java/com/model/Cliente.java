package com.model;

public class Cliente {

	private int id;
	private String nome, marca, modelo, país, email;
	
	public Cliente(){
		
	}

	public Cliente(int id, String nome, String marca, 
			String modelo, String país, String email) {
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.país = país;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPaís() {
		return país;
	}

	public void setPaís(String país) {
		this.país = país;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
		
}
