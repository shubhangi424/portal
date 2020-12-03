package com.example.demo;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailController {
	@Autowired 
	UserService service;
//	send email on emailId

		@Value("${gmail.username}")
		private String username;
		@Value("${gmail.password}")
		private String password;
	//	private Map<String,User>otp_email=new HashMap<>();
		
// 1.email sent message
		@RequestMapping(value="/send", method=RequestMethod.POST)
		public String sendEmail(@RequestBody User user) throws AddressException, MessagingException, IOException 
		{
			user.setOtp(String.valueOf(new Random().nextInt(95509)));
			user.setExpirytime(System.currentTimeMillis()+600000);
			otp_email.put("username", user);
			sendmail(user);
			return "Email sent successfully";
		}
		
// 2. otp verification
		@PutMapping("/verifyotp/{shubhangipbhise@gmail.com}")
		public String verifyEmail1(@PathVariable("shubhangipbhise@gmail.com")String username, @RequestBody User requestBodyOtpSystem ) {
			if(requestBodyOtpSystem.getOtp()==null || requestBodyOtpSystem.getOtp().trim().length()<=0)
			{
				return "enter otp";
			}
				if(otp_email.containsKey(username))
				{
					User c=otp_email.get(username);
				
					if(c!=null)
					{
						if(c.getExpirytime()>=System.currentTimeMillis())
						{
							if(requestBodyOtpSystem.getOtp().equals(c.getOtp()))
							{
								return "Otp is verified";
							}
							return "Invalid OTP";
						}
						return "OTP is Expired";
					}
					return "SomethingWentWrong";
				}
				return "Email not found";
	    }
		
		private Map<String,User>otp_email=new HashMap<>();
//		@RequestMapping(value="/verifyotp/{shubhangipbhise@gmail.com}" , method=RequestMethod.PUT)
//		public String verifyEmail(@RequestBody User requestBodyOtpSystem)  //@PathVariable("${gmail.username}")String username
//		{
//			if(requestBodyOtpSystem.getOtp()==null || requestBodyOtpSystem.getOtp().trim().length()<=0)
//			{
//				return "enter otp";
//			}
//				if(otp_email.containsKey(username))
//				{
//					User c=otp_email.get(username);
//				
//					if(c!=null)
//					{
//						if(c.getExpirytime()>=System.currentTimeMillis())
//						{
//							if(requestBodyOtpSystem.getOtp().equals(c.getOtp()))
//							{
//								return "Otp is verified";
//							}
//							return "Invalid OTP";
//						}
//						return "OTP is Expired";
//					}
//					return "SomethingWentWrong";
//				}
//				return "Email not found";
//	    }
//		
		private void sendmail(User user)throws AddressException, MessagingException, IOException 
		{
			Properties props=new Properties();
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host","smtp.gmail.com");
			props.put("mail.smtp.port","587");
			
			Session session=Session.getInstance(props,new javax.mail.Authenticator()
			{
				@Override
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication("shubhangipbhise@gmail.com", password);
				}
			});	
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("shubhangipbhise@gmail.com",false));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getTo_address()));
		msg.setSubject(user.getSubject());
		msg.setContent("Your one time OTP is "+user.getOtp(),"text/html");
		msg.setSentDate(new Date());
			Transport.send(msg);
		 
		
		}
}

		    
   