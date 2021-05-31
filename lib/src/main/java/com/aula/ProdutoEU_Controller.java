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
import com.model.ProdutoService2;

@Controller
public class ProdutoEU_Controller {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/produto2")
	public String cadastrar2(Model model) {
		model.addAttribute("prod", new Produto());
		return "formcarEU";
	}
	
	@PostMapping("/produto2")
	public String acao2(@ModelAttribute Produto prod, Model model) {
		model.addAttribute("prod",prod);
		ProdutoService2 pdao1 = context.getBean(ProdutoService2.class);
		pdao1.insert2(prod);
		return "carsucessoEU";		
	}
	
	@GetMapping("descr2/{id}")
	public String read2(@PathVariable("id") int id, Model model) {
		ProdutoService2 pdao1 = context.getBean(ProdutoService2.class);
		Map<String, Object> produto = pdao1.getProduto2(id);
		Produto prod = new Produto((String)produto.get("marca"),(String)produto.get("modelo"),
				(String)produto.get("ano"),(String)produto.get("país"));
		model.addAttribute("prod", prod);
		return "carsucessoEU";
	}
	
	@GetMapping("/produtos2")
	public String listar2(Model model) {
		ProdutoService2 pdao11 = context.getBean(ProdutoService2.class);
		List<Map<String,Object>> produtos2 = pdao11.getProdutos2();
		model.addAttribute("produtos2",produtos2);
		return "carrosEU";		
	}
	
	@PostMapping("/apagar2/{id}")
	public String deletar2(@PathVariable("id") int id,Model model) {
		ProdutoService2 pdao1 = context.getBean(ProdutoService2.class);
		pdao1.deleteProduto2(id);
		return "redirect:/produtos2";
	}
	

}
