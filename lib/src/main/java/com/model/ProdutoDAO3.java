package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO3 {	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void insert3(Produto prod) {
		String sql = "INSERT INTO carros_as " +
	"(marca, modelo, ano, pais) VALUES (?,?,?,?)" ;
		jdbc.update(sql, new Object[] {
				prod.getMarca(), prod.getModelo(), prod.getAno(), prod.getPais()
		});
	}
	
	public Map<String, Object> getProduto3(int id) {
		String sql = "SELECT * FROM carros_as WHERE carros_as.id = ?";
		return jdbc.queryForMap(sql, new Object[] {id});
	}
	
	public List<Map<String, Object>> getProdutos3(){
		String sql = "SELECT * FROM carros_as";
		List<Map<String, Object>> produtos = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return produtos;
	}
	
	public void deleteProduto3(int id) {
		String sql = "DELETE FROM carros_as WHERE id = ?";
		jdbc.update(sql, new Object[] {id});
	}
	
	public void updateProduto3(int id,Produto prod) {
		String sql = "UPDATE carros_as SET marca = ?, modelo = ?, ano = ?, pais = ? WHERE id = ?";
		jdbc.update(sql, new Object[] {
				prod.getMarca(), prod.getModelo(), prod.getAno(), prod.getPais(),id
		});
	}	
}
