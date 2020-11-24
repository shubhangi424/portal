package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{

//	List<Users> findByEmail(String email);
	
	
	//List<User> findByusername(String username);
	
	List<Users> findByemail(String email);
	
//	List<User> findByemail(String email);
	//void save(Users c);
	
//-----------------------------for Date--------------------------------------------------------------	
//	public static long diff(Date created_at,Date currentDate)
//	{
//		long diff=currentDate.getTime()-created_at.getTime();
//		
//		return diff;
//		
//	}
//	-----------------------------------------------------------------------------------------------------
	

}
