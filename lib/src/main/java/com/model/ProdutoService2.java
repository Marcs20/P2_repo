package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService2 {
	
	@Autowired
	ProdutoDAO2 pdao;
	
	public void insert2(Produto prod) {
		pdao.insert2(prod);
	}
	
	public Map<String, Object> getProduto2(int id){
		return pdao.getProduto2(id);
	}
	
	public List<Map<String, Object>> getProdutos2(){
		return pdao.getProdutos2();
	}
	
	public void deleteProduto2(int id) {
		pdao.deleteProduto2(id);
	}
	
	public void updateProduto2(int id, Produto prod) {
		pdao.updateProduto2(id, prod);
	}
}
