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
import com.model.ProdutoService1;
@Controller
public class ProdUpBR_Controller {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		ProdutoService1 pdao = context.getBean(ProdutoService1.class);
		Map<String, Object> antigo = pdao.getProduto(id);
		Produto prod = new Produto((String)antigo.get("marca"),(String)antigo.get("modelo"),
				(String)antigo.get("ano"),(String)antigo.get("país"));
		model.addAttribute("antigo", prod);
		model.addAttribute("id", id);
		return "formcarBRup";
	}
	
	@PostMapping("/upd/{id}")
	public String update(@PathVariable("id") int id, @ModelAttribute Produto prod, Model model) {
		ProdutoService1 pdao = context.getBean(ProdutoService1.class);
		pdao.updateProduto(id, prod);
		return "redirect:/produtos";
	}

}
