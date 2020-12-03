package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
@Transactional
@Component
public class UserService {
	@Autowired
	UserRepository userrepository;
	
	
	public String hello()
	{
		return "Hello world";
	}
	public void saveUser(Users user) 
	{
		userrepository.save(user);
	}
	
	public List<Users> displayUser()
	{
		return userrepository.findAll();
	}
	
	public List<Users> searchUser(String email)
	{
		return userrepository.findByemail(email);
	}
	public List<Users> updatePassword(String email)
	{
		return userrepository.findByemail(email);
	}
	public Users getUser(int id)
	{
		return userrepository.findById(id).orElse(new Users());
	}
	public List<Users> searchUsers(String email)
	{
		return userrepository.findByemail(email);
	}
	public List<Users> updatepassword(String email, User password) {
		
		return userrepository.findByemail(email);
	}
	public List<Users> findAll() 
	{
		return userrepository.findAll();
	}
	public Optional<Users> findById(int uid)
	{
		return userrepository.findById(uid);
	}
	public Users save(Users user)
	{
			return userrepository.save(user);
	}
	public void addUser(Users user) 
	{
		userrepository.save(user);
	}
	public void deleteById(int id)
	{
		userrepository.deleteById(id);	
	}
}
