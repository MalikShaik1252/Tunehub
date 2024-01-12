package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController 
{
	@Autowired
	UsersService userService;

	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user)
	{
		boolean userStatus = userService.emailExists(user.getEmail());
		if(userStatus == false)
		{
			userService.addUser(user);
			System.out.println("User added successfully");
		}
		else
		{
			System.out.println("User already Exists");
		}
		return "home";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session) 
	{
		if(userService.validateUser(email,password)== true)
		{
			session.setAttribute("email", email);
			if(userService.getRole(email).equalsIgnoreCase("Admin"))
			{
				return "adminHome";
			}
			else
			{
				return "customerHome";
			}
		}
		else
		{
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) 
	{
		session.invalidate();
		return "login";
	}
	


}
