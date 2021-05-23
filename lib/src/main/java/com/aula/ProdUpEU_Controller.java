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
import com.model.ProdutoService2;
@Controller
public class ProdUpEU_Controller {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd2/{id}")
	public String updateForm2(@PathVariable("id") int id, Model model) {
		ProdutoService2 pdao = context.getBean(ProdutoService2.class);
		Map<String, Object> antigo = pdao.getProduto2(id);
		Produto prod = new Produto((String)antigo.get("marca"),(String)antigo.get("modelo"),
				(String)antigo.get("ano"),(String)antigo.get("país"));
		model.addAttribute("antigo", prod);
		model.addAttribute("id", id);
		return "formcarEUup";
	}
	
	@PostMapping("/upd2/{id}")
	public String update2(@PathVariable("id") int id, @ModelAttribute Produto prod, Model model) {
		ProdutoService2 pdao = context.getBean(ProdutoService2.class);
		pdao.updateProduto2(id, prod);
		return "redirect:/produtos2";
	}

}
