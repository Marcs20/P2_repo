package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService3 {
	
	@Autowired
	ProdutoDAO3 pdao;
	
	public void insert3(Produto prod) {
		pdao.insert3(prod);
	}
	
	public Map<String, Object> getProduto3(int id){
		return pdao.getProduto3(id);
	}
	
	public List<Map<String, Object>> getProdutos3(){
		return pdao.getProdutos3();
	}
	
	public void deleteProduto3(int id) {
		pdao.deleteProduto3(id);
	}
	
	public void updateProduto3(int id, Produto prod) {
		pdao.updateProduto3(id, prod);
	}
}
