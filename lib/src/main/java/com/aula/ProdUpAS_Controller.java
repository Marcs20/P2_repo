package com.aula;

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
public class ProdUpAS_Controller {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd3/{id}")
	public String updateForm3(@PathVariable("id") int id, Model model) {
		ProdutoService3 pdao = context.getBean(ProdutoService3.class);
		Map<String, Object> antigo = pdao.getProduto3(id);
		Produto prod = new Produto((String)antigo.get("marca"),(String)antigo.get("modelo"),
				(String)antigo.get("ano"),(String)antigo.get("país"));
		model.addAttribute("antigo", prod);
		model.addAttribute("id", id);
		return "formcarASup";
	}
	
	@PostMapping("/upd3/{id}")
	public String update3(@PathVariable("id") int id, @ModelAttribute Produto prod, Model model) {
		ProdutoService3 pdao = context.getBean(ProdutoService3.class);
		pdao.updateProduto3(id, prod);
		return "redirect:/produtos3";
	}

}
