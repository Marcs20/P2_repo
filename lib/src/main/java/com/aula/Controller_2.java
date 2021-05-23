package com.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_2 {
	
	//Pagina inicial do cadastro
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/prodhome")
	public String prodHome(Model model) {
		String nome = "Cadastro";
		model.addAttribute("nome",nome);
		return "prodhome";
		
	}
	

}
