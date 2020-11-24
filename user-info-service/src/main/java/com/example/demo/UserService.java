package com.example.demo;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Component
public class UserService {
	@Autowired
	UserRepository ur;
	public void saveUser(Users user) {
		ur.save(user);
	}
	public void addUser(Users c) 
	{
		ur.save(c);
	}
	public List<Users> displayUser()
	{
		return ur.findAll();
	}
	public Users getUser(int id)
	{
		return ur.findById(id).orElse(new Users());
	}
//	public List<Users> searchUsers(String username)
//	{
//		return ur.findByusername(username);
//	}

	public List<Users> searchUser(String email)
	{
		return ur.findByemail(email);	}
	
	
	public List<Users> updatePassword(String email)
	{
		return ur.findByemail(email);
	}
//	public List<Users> updatepassword(String username, User password) {
//		
//		return ur.findByusername(username);
//	}
	
	
	
	//----------------------------------for date-------------------------------------------------------
	/*
	 * public void date(String createat,String currentDate) { //LocalDateTime
	 * created_at=LocalDateTime.Create_at(); //LocalDate today=LocalDate.now();
	 * //Date now=today.toDate(); //Date seconddate=now; // //LocalDate
	 * now=LocalDate.now(); //org.jada
	 * 
	 * //String createat=new Date(); //java.util // String currentDate =new Date();
	 * //java.util SimpleDateFormat Date =new SimpleDateFormat("yyyy-MM-dd"); //long
	 * diff= currentDate.getTime() - c.getCreate_at(); // int diff=0; // String
	 * d1=null; // String d2=null; // System.out.println("Create_at date :"
	 * +c.getCreate_at()); // System.out.println("current Date : "+
	 * Date.format(currentDate)); // System.out.println("localdate: "+ now); try{
	 * Date d1=Date.parse(createat); Date d2=Date.parse(currentDate); long
	 * differenceInTime=d2.getTime()-d1.getTime();
	 * 
	 * long diffenenceInYears=(differenceInTime /(10001*60*60*24*365)); long
	 * diffenenceInDays=(differenceInTime /(1000*60*60*24))%365;
	 * System.out.println("Diff" + "between two dates is:");
	 * System.out.println(diffenenceInYears +"years" + differenceInTime +"Days");
	 * 
	 * // d1=Date.format(create_at); // d2=Date.format(currentDate); // l // long
	 * diffDays=diff/(24*60*60*10000); // //
	 * System.out.println(Days.daysBetween(c.getCreate_at(),
	 * currentDate.getDate())); // System.out.println(diffDays + "days"); //
	 * diff=currentDate.compareTo(c.getCreate_at()); // } } catch(Exception e) {
	 * System.out.println("exception" +e);
	 * 
	 * 
	 * // System.out.println(currentDate.compareTo(c.getCreate_at())); // Date
	 * daysBetween=(Date)(diff/(1000*60*60*24)); // long
	 * days=Period.between(cl.getCreate_at(), currentDate.getDate()).getDays(); //
	 * System.out.println(daysBetween);
	 * 
	 * } date(createat,currentDate); //System.out.println(); }
	 */
	

}
