package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public void hello(ModelMap model) {
		model.addAttribute("message", "Hello world!");
	}
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public void hello2(ModelMap model){
        model.addAttribute("message","Hello Jinho!!");
    }
}