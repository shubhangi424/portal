package com.java.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class UserService  {
	@Autowired
	UserRepository ur;
	public void addUser(User c) 
	{
		ur.save(c);
	}
	public void updateUser(User c)
	{
		ur.save(c);
	}
	public void deleteUser(int id)
	{
		ur.deleteById(id);
	}
	public List<User> displayUser()
	{
		return (List<User>) ur.findAll();
	}
	public User getUser(int id)
	{
		return ur.findById(id).orElse(new User());
	}
	

}



