package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO1 {	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insert(Produto prod) {
		String sql = "INSERT INTO carros_br " +
	"(marca, modelo, ano, pais) VALUES (?,?,?,?)" ;
		jdbc.update(sql, new Object[] {
				prod.getMarca(), prod.getModelo(), prod.getAno(), prod.getPais()
		});
	}
	
	public Map<String, Object> getProduto(int id) {
		String sql = "SELECT * FROM carros_br WHERE carros_br.id = ?";
		return jdbc.queryForMap(sql, new Object[] {id});
	}
	
	public List<Map<String, Object>> getProdutos(){
		String sql = "SELECT * FROM carros_br";
		List<Map<String, Object>> produtos = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return produtos;
	}
	
	public void deleteProduto(int id) {
		String sql = "DELETE FROM carros_br WHERE id = ?";
		jdbc.update(sql, new Object[] {id});
	}
	
	public void updateProduto(int id,Produto prod) {
		String sql = "UPDATE carros_br SET marca = ?, modelo = ?, ano = ?, pais = ? WHERE id = ?";
		jdbc.update(sql, new Object[] {
				prod.getMarca(), prod.getModelo(), prod.getAno(), prod.getPais(),id
		});
	}	
}
