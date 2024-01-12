package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UserRepository;

@Service
public class UsersServiceImpl implements UsersService
{
	@Autowired
	UserRepository userRepo;
	
	@Override
	public String addUser(Users user)
	{
		userRepo.save(user);
		return "User Added Successfully!";
	}

	@Override
	public boolean emailExists(String email) 
	{
		if(userRepo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
		return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user = userRepo.findByEmail(email);
		String db_email=user.getEmail();
		String db_pass = user.getPassword();
		if(password.equals(db_pass) && email.equals(db_email))
		{
			return true;
		}
		else 
		{
		return false;
		}
	}

	@Override
	public String getRole(String email) 
	{
		Users user = userRepo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public Users getUser(String email) 
	{
		return userRepo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		userRepo.save(user);
		
	}
}
