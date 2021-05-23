package com.model;

public class Produto {
	
	private int id;
	private String marca;
	private String modelo;
	private String ano;
	private String pais;
	
	public Produto() {}
	
	public Produto(String marca, String modelo, String ano, String pais) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.pais = pais;
	}



	public Produto(int id, String marca, String modelo, String ano, String pais) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.pais = pais;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getAno() {
		return ano;
	}



	public void setAno(String ano) {
		this.ano = ano;
	}



	public String getPais() {
		return pais;
	}



	public void setpais(String pais) {
		this.pais = pais;
	}
	
	
}
