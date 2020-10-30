package com.java.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class UserController {
	@Autowired
	private UserRepository ur;
	
	//all user API
		@GetMapping("user")
		public List<User> getAllUser()
		{
			return ur.findAll();
		}

		//Get api by user id
		@GetMapping("/user/{uid}")
		public Optional<User>getUserbyID(@PathVariable("uid")int id)
		{
			return ur.findById(id);
		}
		
		@GetMapping("/username/{username}")
		public List<User> getUserbyusername(@PathVariable("username")String username)
		{
			return ur.findByusername(username);
		}	
		
		//update all details 
		 @PutMapping("/user/{id}")
		 public User updateUser(@RequestBody User c)
		 {
			  ur.save(c); 
			  return c;
		 }	  
		 
		 //adding new user deatils
		@PostMapping("/user")
		public User addUser(@RequestBody User c) 
		{
			 ur.save(c); 
			 return c; 
		}
		
		@DeleteMapping("/deluser/{uid}") 
		 public String Delete(@PathVariable("uid")int uid)
		 { 
			 ur.deleteById(uid); 
			 return "delete"; 
		}
			
		//Login Api
			@PostMapping(path="/login")
			public String login(@RequestBody User c)
			{
				String username=c.getUsername();
				String password=c.getPassword();
				List<User> clist=ur.findByusername(username);
				for(User cl: clist)
				{
					if(cl.getUsername().equals(username) && cl.getPassword().equals(password))
					{
						return "Login Successful";
					}
				}
				return "Login Fail";
			}
			//LogOut Api
			@PostMapping(path="/logout")
			public String logout(HttpSession session)
			{
				session.invalidate();
				return "Logged out successfully";
			}
			//Email Check 
			@PostMapping("/emailcheck")
			public String Emailcheck(@RequestBody User c)
			{
				String username=c.getUsername();
				String email=c.getEmail();
				List<User> clist=ur.findByEmail(email);
				for(User cl:clist)
				{
					if(cl.getEmail().equals(email) && cl.getUsername().equals(username))
					{
						
						return "Email found";
					}
				}
				return "Email not found";	
			}
			
			//Change Password  
			@PatchMapping("/changepassword")
			public String Change(@RequestBody User c)
			{
				String username=c.getUsername();
				String password=c.getPassword();
				List<User> clist=ur.findByusername(username);
				for(User cl:clist)
				{
					if(cl.getUsername().equals(username))
					{
						cl.setPassword(password);
						ur.save(cl);	
					}
				}
				return "password Change";
			}
	}