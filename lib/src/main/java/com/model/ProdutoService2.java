package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService2 {
	
	@Autowired
	ProdutoDAO2 pdao1;
	
	public void insert2(Produto prod) {
		pdao1.insert2(prod);
	}
	
	public Map<String, Object> getProduto2(int id){
		return pdao1.getProduto2(id);
	}
	
	public List<Map<String, Object>> getProdutos2(){
		return pdao1.getProdutos2();
	}
	
	public void deleteProduto2(int id) {
		pdao1.deleteProduto2(id);
	}
	
	public void updateProduto2(int id, Produto prod) {
		pdao1.updateProduto2(id, prod);
	}
}
