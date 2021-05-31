package com.aula;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Cliente;
import com.model.ClienteService;
import com.model.ProdutoService1;
import com.model.ProdutoService2;
import com.model.ProdutoService3;

@Controller
@ComponentScan("com.model")
public class Controller_1 {
	
	@Autowired
	private ApplicationContext context;
	
	//home
	@GetMapping("/")
	public String indexPg(Model model) {
		ProdutoService1 pdao = context.getBean(ProdutoService1.class);
		List<Map<String,Object>> produtos = pdao.getProdutos();
		model.addAttribute("produtos",produtos);
		
		ProdutoService2 pdao1 = context.getBean(ProdutoService2.class);
		List<Map<String,Object>> produtos2 = pdao1.getProdutos2();
		model.addAttribute("produtos2",produtos2);
		
		ProdutoService3 pdao2 = context.getBean(ProdutoService3.class);
		List<Map<String,Object>> produtos3 = pdao2.getProdutos3();
		model.addAttribute("produtos3",produtos3);
		
		return "index";
	}
	
	
	//formulário	
	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
	
	@GetMapping("/cliente")
	public String formCliente(Model model) {
		model.addAttribute("Cliente", new Cliente());
		return "formcliente";
	}
		
	@PostMapping("/cliente")
	public String postCliente(@ModelAttribute Cliente cli, Model model) {
		ClienteService cs = context.getBean(ClienteService.class);
		cs.inserirCliente(cli);
		return "enviado";
	}
	

}
