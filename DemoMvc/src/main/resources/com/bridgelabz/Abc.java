package com.bridgelabz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Abc {
	@RequestMapping("/show")
	 public String display()  
	    {  
	        return "index";  
	    }     
}
