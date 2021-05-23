package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO2 {	
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insert2(Produto prod) {
		String sql = "INSERT INTO carros_eu " +
	"(marca, modelo, ano, pais) VALUES (?,?,?,?)" ;
		jdbc.update(sql, new Object[] {
				prod.getMarca(), prod.getModelo(), prod.getAno(), prod.getPais()
		});
	}
	
	public Map<String, Object> getProduto2(int id) {
		String sql = "SELECT * FROM carros_eu WHERE carros_eu.id = ?";
		return jdbc.queryForMap(sql, new Object[] {id});
	}
	
	public List<Map<String, Object>> getProdutos2(){
		String sql = "SELECT * FROM carros_eu";
		List<Map<String, Object>> produtos = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return produtos;
	}
	
	public void deleteProduto2(int id) {
		String sql = "DELETE FROM carros_eu WHERE id = ?";
		jdbc.update(sql, new Object[] {id});
	}
	
	public void updateProduto2(int id,Produto prod) {
		String sql = "UPDATE carros_eu SET marca = ?, modelo = ?, ano = ?, pais = ? WHERE id = ?";
		jdbc.update(sql, new Object[] {
				prod.getMarca(), prod.getModelo(), prod.getAno(), prod.getPais(),id
		});
	}	
}
