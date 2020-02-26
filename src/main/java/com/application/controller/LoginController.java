package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.application.entity.User;
import com.application.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error, 
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        String successMessge = null; 
        System.out.println("Error : "+ error);
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if(logout != null) {
        	successMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        model.addAttribute("successMessge", successMessge);
        model.addAttribute("user", new User());
        return "login";
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/dashboard.html")
	public String login(Model model)
	{
		model.addAttribute("home");
		return "dashboard";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addUser.htm")
	public String newUser(@ModelAttribute("user") User user, RedirectAttributes ra) {
		userService.saveUser(user);
		ra.addFlashAttribute("successMessge", "Thanks! your account has been successfully created.");
		return "redirect:/login";
	}
}
