package com.abhinav.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helloWorld")
@SessionAttributes

public class HelloWorldController {
	
	@Autowired
	org.springframework.context.ApplicationContext applicationContext;
	
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")
							Contact contact, BindingResult result) {
		
		System.out.println("First Name:" + contact.getFirstname() + 
					"Last Name:" + contact.getLastname());
		
		
		return "redirect:contacts.html";
	}
	
	@RequestMapping("/hello.html")
	public ModelAndView showContacts() {
		
		return new ModelAndView("contact", "command", new Contact());
	}
	
    public ModelAndView helloWorld() {
		BeanTest bt=(BeanTest)applicationContext.getBean("test");
		System.out.println("message the bean name will be "+bt.getName());
        String message = "Hello World, Spring.0!";
        return new ModelAndView("contact", "message", message);
    }	
	
	
	
	/*@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")
							Contact contact, BindingResult result) {
		
		System.out.println("First Name:" + contact.getFirstname() + 
					"Last Name:" + contact.getLastname());
		
		
		return "redirect:contacts.html";
	}
	
	@RequestMapping("/contacts")
	public ModelAndView showContacts() {
		String message = "Hello World, Spring 3.0!";
		
		return new ModelAndView("contact", "message", new Contact());*/
	//}
}
