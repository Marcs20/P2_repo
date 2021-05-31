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
import com.model.ProdutoService3;

@Controller
public class ProdutoAS_Controller {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/produto3")
	public String cadastrar3(Model model) {
		model.addAttribute("prod", new Produto());
		return "formcarAS";
	}
	
	@PostMapping("/produto3")
	public String acao3(@ModelAttribute Produto prod, Model model) {
		model.addAttribute("prod",prod);
		ProdutoService3 pdao2 = context.getBean(ProdutoService3.class);
		pdao2.insert3(prod);
		return "carsucessoAS";		
	}
	
	@GetMapping("descr3/{id}")
	public String read3(@PathVariable("id") int id, Model model) {
		ProdutoService3 pdao2 = context.getBean(ProdutoService3.class);
		Map<String, Object> produto = pdao2.getProduto3(id);
		Produto prod = new Produto((String)produto.get("marca"),(String)produto.get("modelo"),
				(String)produto.get("ano"),(String)produto.get("país"));
		model.addAttribute("prod", prod);
		return "carsucessoAS";
	}
	
	@GetMapping("/produtos3")
	public String listar3(Model model) {
		ProdutoService3 pdao22 = context.getBean(ProdutoService3.class);
		List<Map<String,Object>> produtos3 = pdao22.getProdutos3();
		model.addAttribute("produtos3",produtos3);
		return "carrosAS";		
	}
	
	@PostMapping("/apagar3/{id}")
	public String deletar3(@PathVariable("id") int id,Model model) {
		ProdutoService3 pdao2 = context.getBean(ProdutoService3.class);
		pdao2.deleteProduto3(id);
		return "redirect:/produtos3";
	}
	

}
