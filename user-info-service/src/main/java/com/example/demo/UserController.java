package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/registration")
public class UserController {
	@Autowired
	private UserRepository ur;
	
// 1. all user API
		@GetMapping("user")
		public List<Users> getAllUser()
		{
			return ur.findAll();
		}
//
//// 2. Get api by user id
//		@GetMapping("/user/{uid}")
//		public Optional<User>getUserbyID(@PathVariable("uid")int id)
//		{
//			return ur.findById(id);
//		}
//		
//		@GetMapping("/username/{username}")
//		public List<Users> getUserbyusername(@PathVariable("username")String username)
//		{
//			return ur.findByusername(username);
//		}	
//		
//// 3. update all details 
		 @PutMapping("/user/{id}")
		 public Users updateUser(@RequestBody Users c)
		 {
			  ur.save(c); 
			  return c;
		 }	  
		
//// 4. adding new user deatils
		@PostMapping("/user")
		public Users addUser(@RequestBody Users c) 
		{
			 ur.save(c); 
			 return c; 
		}
		
//// 5. Delete User by ID		
//		@DeleteMapping("/deluser/{uid}") 
//		 public String Delete(@PathVariable("uid")int uid)
//		 { 
//			 ur.deleteById(uid); 
//			 return "delete"; 
//		}
//	------------------------------------------Date Check-----------------------------------------------------
		//------------------------code for review-------------------------------------------------------
//// 6. Login Api using gmail (users)
		@PostMapping(path="/login")
		public String login(@RequestBody Users c)
		{
			String email=c.getEmail();
		String password=c.getPassword();
		Date create_at=c.getCreate_at(); //java.util
		Date currentDate =new Date();  //java.util 
		DateFormat Date =new SimpleDateFormat("yyyy-MM-dd");
	int diff=0;
			List<Users> clist=ur.findByemail(email);
			for(Users cl: clist)
			{
				if(cl.getEmail().equals(email) && cl.getPassword().equals(password))//&& cl.getCreated_at().before(null)
				{						
					System.out.println("Create_at date :" +cl.getCreate_at());
					System.out.println("current Date : "+ Date.format(currentDate));
				try{
						long diffDays=diff/(24*60*60*10000);
						System.out.println(diffDays + "days");
						diff=currentDate.compareTo(c.getCreate_at());	
					}
					catch(Exception e)
					{
						System.out.println("exception" +e);	
					}
			System.out.println(diff);
			return "Login Successful";
				}
			}
			return "Login Fail";
		}
		
//			@PostMapping(path="/login")
//			public String login(@RequestBody User c)
//			{
//				String username=c.getUsername();
//				String password=c.getPassword();
//				List<User> clist=ur.findByusername(username);
//				for(User cl: clist)
//				{
//					if(cl.getUsername().equals(username) && cl.getPassword().equals(password))
//					{
//						return "Login Successful";
//					}
//				}
//				return "Login Fail";
//			}
			
//// 7.LogOut Api
//			@PostMapping(path="/logout")
//			public String logout(HttpSession session)
//			{
//				session.invalidate();
//				return "Logged out successfully";
//			}
//			
//// 8.Email Check 
//			@PostMapping("/emailcheck")
//			public String Emailcheck(@RequestBody User c)
//			{
//				String username=c.getUsername();
//				String email=c.getEmail();
//				List<User> clist=ur.findByEmail(email);
//				for(User cl:clist)
//				{
//					if(cl.getEmail().equals(email) && cl.getUsername().equals(username))
//					{
//						return "Email found";
//					}
//				}
//				return "Email not found";	
//			}
//		
		// 9.Change Password  
					@PatchMapping("/changepassword")
					public String Change(@RequestBody Users c)
					{
						String email=c.getEmail();
						String password=c.getPassword();
						List<Users> clist=ur.findByemail(email);
						for(Users cl:clist)
						{
							if(cl.getEmail().equals(email))
							{
								cl.setPassword(password);
								ur.save(cl);	
							}
						}
						return "password Change";
					}
					
//					@PatchMapping("/changepassword")
//					public String Change(@RequestBody Users c)
//					{
//						String email=c.getEmail();
//						String password=c.getPassword();
//						List<Users> clist=ur.findByEmail(email);
//						for(Users cl:clist)
//						{
//							if(cl.getEmail().equals(email))
//							{
//								cl.setPassword(password);
//								ur.save(cl);	
//							}
//						}
//						return "password Change";
//					}
//					
				
					
// 9.Change Password  
//			@PatchMapping("/changepassword")
//			public String Change(@RequestBody User c)
//			{
//				String username=c.getUsername();
//				String password=c.getPassword();
//				List<User> clist=ur.findByusername(username);
//				for(User cl:clist)
//				{
//					if(cl.getUsername().equals(username))
//					{
//						cl.setPassword(password);
//						ur.save(cl);	
//					}
//				}
//				return "password Change";
//			}
//// 10.otp generation and verification api
//			private Map<String,User>otp_data=new HashMap<>();
//			    private final static String ACCOUNT_SID ="AC7f474e58336ea4d6b756e2117cb38771";
//			    private final static String AUTH_TOKEN = "408b858ad1573c82572bcf9159de686b";
//			    static
//			    {
//			    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//			    }
//			   
//// 11. OTP SENT By Mobileno
//			    @RequestMapping(value = "/{mobileno}/otp", method = RequestMethod.POST)
//			    public ResponseEntity<Object> sendOtp(@PathVariable("mobileno")String mobileno){
//			    	User c=new User();
//			    	c.setMobileno(mobileno);
//			    	c.setOtp(String.valueOf(new Random().nextInt(95509)));
//			    	c.setExpirytime(System.currentTimeMillis()+60000);
//
//			    	otp_data.put(mobileno, c);
//			    	Message.creator(new PhoneNumber("+918766953491"),
//							new PhoneNumber("+12055510983"),
//							c.getOtp()+" is Your OTP to proceed on OnlineTrainingPortal.It is valied for 10 minutes . PLease  Dont Share Your OTP with Anyone").create();
//			    	return new ResponseEntity<>("OTP is Sent Successfully",HttpStatus.OK);
//			    }
//			    
//// 12. OTP VARIFICATION
//			    @RequestMapping(value = "/{mobileno}/otp", method = RequestMethod.PUT)
//			    public ResponseEntity<Object> verifyOtp(@PathVariable("mobileno")String mobileno, @RequestBody User requestBodyOtpSystem)
//			    {
//			    	if(requestBodyOtpSystem.getOtp()==null || requestBodyOtpSystem.getOtp().trim().length()<=0)
//			    	{
//			    		return new ResponseEntity<>("Please provide OTP",HttpStatus.BAD_REQUEST);
//			    	}
//			    	if(otp_data.containsKey(mobileno))
//			    	{
//			    		User c=otp_data.get(mobileno);
//			    		if(c!=null)
//			    		{
//			    			if(c.getExpirytime()>=System.currentTimeMillis()) 
//			    			{
//			    				if(requestBodyOtpSystem.getOtp().equals(c.getOtp()))
//			    				{
//			    					return new ResponseEntity<>("OTP is Verified Successfully",HttpStatus.OK);
//			    				}
//			    				return new  ResponseEntity<>("Invalid OTP",HttpStatus.BAD_REQUEST);
//			    			}
//			    			return new  ResponseEntity<>("OTP is Expired",HttpStatus.BAD_REQUEST);
//			    		}
//			    		return new  ResponseEntity<>("SomethingWentWrong",HttpStatus.BAD_REQUEST);
//			    	}
//					return new ResponseEntity<>("Mobile No not found",HttpStatus.BAD_REQUEST);
//			    }
//
// 13. For testing only
			    @GetMapping("/hello")
				public String getString()
				{
					return "hello";
				} 
			
//----------------------------------------------------------------------------------------------------
//---------------------------------------------------for Date----------------------------------------
//			    6. Login Api using gmail (users)
//				@PostMapping(path="/login")
//				public String login(@RequestBody Users c)
//				{
//					String email=c.getEmail();
//					String password=c.getPassword();
//					//LocalDateTime created_at=LocalDateTime.Create_at();
//					//LocalDate today=LocalDate.now();
//					//Date now=today.toDate();
//					//Date seconddate=now;
//					//LocalDate now=LocalDate.now(); //org.jada
//					public static long diff(Date created_at,Date currentDate)
//					{
//						long diff=currentDate.getTime()-created_at.getTime();
//						
//						return diff;
//						
//					}
//					ur.getClass();
//				Date create_at=c.getCreate_at(); //java.util
//				
//				Date currentDate =new Date();  //java.util 
//					DateFormat Date =new SimpleDateFormat("yyyy-MM-dd");
//			long diff= currentDate.getTime() - c.getCreate_at();
//					//int diff=0;
//					
//					List<Users> clist=ur.findByemail(email);
//					for(Users cl: clist)
//					{
//						if(cl.getEmail().equals(email) && cl.getPassword().equals(password))//&& cl.getCreated_at().before(null)
//						{						
//							System.out.println("Create_at date :" +cl.getCreate_at());
//							System.out.println("current Date : "+ Date.format(currentDate));
//						//	System.out.println("localdate: "+ now);
//							try{
//								Date d1=create_at;
//								Date d2=currentDate;
//								long diff1=d2.getTime();
//								long diff2=d1.getTime();
//								
//								long diff=diff2-diff1;
//								//int diff=currentDate.getTime()-c.getCreate_at();
//							long diffDays=diff/(24*60*60*10000);
//							System.out.println(diffDays + "days");
//							//	System.out.println(Days.daysBetween(c.getCreate_at(), currentDate.getDate()));
//								
//								diff=currentDate.compareTo(c.getCreate_at());	}
//							catch(Exception e)
//							{
//								System.out.println("exception" +e);
//								
//								/*
//								 * // System.out.println(currentDate.compareTo(c.getCreate_at())); // Date
//								 * daysBetween=(Date)(diff/(1000*60*60*24)); // long
//								 * days=Period.between(cl.getCreate_at(), currentDate.getDate()).getDays(); //
//								 * System.out.println(daysBetween);
//								 */				
//							}
//				//	System.out.println(diff);
//					return "Login Successful";
//					
//						}
//					}
//					return "Login Fail";
//				}
//------------------------------------------------------------------------------------------------------------------------				
			    
			    
			    
}		   
