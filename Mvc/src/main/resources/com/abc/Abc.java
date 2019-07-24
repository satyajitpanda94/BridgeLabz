package com.abc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Abc {
	
	@RequestMapping("/show")
	public void show() {
		System.out.println("Hello");
	}
}
