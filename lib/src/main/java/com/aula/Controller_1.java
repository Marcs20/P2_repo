package com.aula;

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

@Controller
@ComponentScan("com.model")
public class Controller_1 {
	
	@Autowired
	private ApplicationContext context;
	
	//home
	@GetMapping("/")
	public String indexPg() {
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
