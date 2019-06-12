package com.codinsaint.tutorial.spring.userservice.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {
	
	@GetMapping({"index","welcome"})
	public String index() {
		return "index";
	}

}
