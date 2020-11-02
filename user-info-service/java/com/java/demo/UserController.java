package com.java.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/registration")
public class UserController {
	@Autowired
	private UserRepository ur;
	@Autowired
    UserService service;

    //1. Save User
			@PostMapping("/user")
			public User addUser(@RequestBody User c) 
			{
				 ur.save(c); 
				 return c; 
			}
	
	//2. Delete User
			@DeleteMapping("/deluser/{uid}") 
			 public String Delete(@PathVariable("uid")int uid)
			 { 
				 ur.deleteById(uid); 
				 return "delete"; 
			}
	
	
	//3. Login Api	
			
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
			
	//4. Password Change 
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
			
	// 5.update User 
			 @PutMapping("/user/{id}")
			 public User updateUser(@RequestBody User c)
			 {
				  ur.save(c); 
				  return c;
			 }	
			 
	// 6.Email Check 
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
				
			 
	//7. Get AllUsers
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
		
	
	    //OTP Generation and verification api
	    private Map<String,User>otp_data=new HashMap<>();
	    private final static String ACCOUNT_SID ="AC7f474e58336ea4d6b756e2117cb38771";

	    private final static String AUTH_TOKEN = "53adbe67025fc1b25579cfb56522aa87";

	    static
	    {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    
	    	
	    }
	    // 8. OTP SENT
	    @RequestMapping(value = "/{mobileno}/otp", method = RequestMethod.POST)
	    		
	    public ResponseEntity<Object> sendOtp(@PathVariable("mobileno")String mobileno){
	    	User c=new User();
	    	c.setMobileno(mobileno);
	    	c.setOtp(String.valueOf(new Random().nextInt(95509)));
	    	c.setExpirytime(System.currentTimeMillis()+60000);
	    
	    	otp_data.put(mobileno, c);
	    	Message.creator(new PhoneNumber("+918766953491"),
					new PhoneNumber("+12055510983"),
					c.getOtp()+" is Your OTP to proceed on OnlineTrainingPortal.It is valied for 10 minutes . PLease  Dont Share Your OTP with Anyone").create();
	    	return new ResponseEntity<>("OTP is Sent Successfully",HttpStatus.OK);
	    }
	    
	    
	    
	    // 9. OTP VARIFICATION
	    @RequestMapping(value = "/{mobileno}/otp", method = RequestMethod.PUT)
	    public ResponseEntity<Object> verifyOtp(@PathVariable("mobileno")String mobileno, @RequestBody User requestBodyOtpSystem)
	    {
	    	if(requestBodyOtpSystem.getOtp()==null || requestBodyOtpSystem.getOtp().trim().length()<=0)
	    	{
	    		return new ResponseEntity<>("Please provide OTP",HttpStatus.BAD_REQUEST);
	    		
	    	}
	    	if(otp_data.containsKey(mobileno))
	    	{
	    		User c=otp_data.get(mobileno);
	    		if(c!=null)
	    		{
	    			if(c.getExpirytime()>=System.currentTimeMillis()) 
	    			{
	    				if(requestBodyOtpSystem.getOtp().equals(c.getOtp()))
	    				{
	    					return new ResponseEntity<>("OTP is Verified Successfully",HttpStatus.OK);
	    				}
	    				return new  ResponseEntity<>("Invalid OTP",HttpStatus.BAD_REQUEST);
	    			}
	    			return new  ResponseEntity<>("OTP is Expired",HttpStatus.BAD_REQUEST);
	    		}
	    		return new  ResponseEntity<>("SomethingWentWrong",HttpStatus.BAD_REQUEST);
	    	}
			return new ResponseEntity<>("Mobile No not found",HttpStatus.BAD_REQUEST);
	  	
	    }
	}