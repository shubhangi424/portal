package com.java.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(path="/user",produces= {"application/xml"})
	public List<User> getAllUser(){
		return ur.findAll();
	}
	
	@GetMapping("/user/{uid}")
	public Optional<User>getUserbyID(@PathVariable("uid")int id)
	{
		return ur.findById(id);
	}
	 @PostMapping("/user")
	 public User addUser(@RequestBody User c)
	 {
		 ur.save(c);
		 return c;
	 }
	 @PutMapping("/user")
	 public User updateUser(@RequestBody User c)
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
}



