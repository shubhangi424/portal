package com.example.demo;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Transactional
@Component
public class UserService  {
	@Autowired
	UserRepository ur;
	public void saveUser(User user) {
		ur.save(user);
	}
	public void addUser(User c) 
	{
		ur.save(c);
	}
	public List<User> displayUser()
	{
		return (List<User>) ur.findAll();
	}
	public User getUser(int id)
	{
		return ur.findById(id).orElse(new User());
	}
	public List<User> searchUsers(String username)
	{
		return ur.findByusername(username);
	}
	public List<User> searchUser(String email)
	{
		return ur.findByEmail(email);
	}
	public List<User> updatePassword(String email)
	{
		return ur.findByemail(email);
	}
	public List<User> updatepassword(String username, User password) {
		
		return ur.findByusername(username);
	}
}

