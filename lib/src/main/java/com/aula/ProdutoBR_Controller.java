package com.aula;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Produto;
import com.model.ProdutoService1;

@Controller
public class ProdutoBR_Controller {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/produto")
	public String cadastrar(Model model) {
		model.addAttribute("prod", new Produto());
		return "formcarBR";
	}
	
	@PostMapping("/produto")
	public String acao(@ModelAttribute Produto prod, Model model) {
		model.addAttribute("prod",prod);
		ProdutoService1 pdao = context.getBean(ProdutoService1.class);
		pdao.insert(prod);
		return "carsucessoBR";		
	}
	
	@GetMapping("descr/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		ProdutoService1 pdao = context.getBean(ProdutoService1.class);
		Map<String, Object> produto = pdao.getProduto(id);
		Produto prod = new Produto((String)produto.get("marca"),(String)produto.get("modelo"),
				(String)produto.get("ano"),(String)produto.get("país"));
		model.addAttribute("prod", prod);
		return "carsucessoBR";
	}
	
	@GetMapping("/produtos")
	public String listar(Model model) {
		ProdutoService1 pdao = context.getBean(ProdutoService1.class);
		List<Map<String,Object>> produtos = pdao.getProdutos();
		model.addAttribute("produtos",produtos);
		return "carrosBR";		
	}
	
	@PostMapping("/apagar/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		ProdutoService1 pdao = context.getBean(ProdutoService1.class);
		pdao.deleteProduto(id);
		return "redirect:/produtos";
	}
	

}
