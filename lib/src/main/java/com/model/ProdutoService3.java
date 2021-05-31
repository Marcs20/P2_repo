package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService3 {
	
	@Autowired
	ProdutoDAO3 pdao2;
	
	public void insert3(Produto prod) {
		pdao2.insert3(prod);
	}
	
	public Map<String, Object> getProduto3(int id){
		return pdao2.getProduto3(id);
	}
	
	public List<Map<String, Object>> getProdutos3(){
		return pdao2.getProdutos3();
	}
	
	public void deleteProduto3(int id) {
		pdao2.deleteProduto3(id);
	}
	
	public void updateProduto3(int id, Produto prod) {
		pdao2.updateProduto3(id, prod);
	}
}
