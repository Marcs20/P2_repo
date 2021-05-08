package com.aula;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_1 {
	
	@GetMapping("/")
	public String indexPg() {
		return "index";
	}
	
	@GetMapping("/link_1")
	public String link1() {
		return "link_1";
	}
	
	@GetMapping("/link_2")
	public String link2() {
		return "link_2";
	}
	
	@GetMapping("link_3")
	public String link3() {
		return "link_3";
	}

}
