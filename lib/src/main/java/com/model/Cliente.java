package com.model;

public class Cliente {

	private int id;
	private String nome, marca, modelo, pa�s, email;
	
	public Cliente(){
		
	}

	public Cliente(int id, String nome, String marca, 
			String modelo, String pa�s, String email) {
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.pa�s = pa�s;
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

	public String getPa�s() {
		return pa�s;
	}

	public void setPa�s(String pa�s) {
		this.pa�s = pa�s;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
		
}
