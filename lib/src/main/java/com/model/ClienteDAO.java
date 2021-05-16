package com.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente(nome, marca, modelo, país, email)" +
					"VALUES (?,?,?,?,?)";
		Object[] obj = new Object[5];
		obj[0] = cliente.getNome();
		obj[1] = cliente.getMarca();
		obj[2] = cliente.getModelo();
		obj[3] = cliente.getPaís();
		obj[4] = cliente.getEmail();
		jdbc.update(sql, obj);
		
	}

}
