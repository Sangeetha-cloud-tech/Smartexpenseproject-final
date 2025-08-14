package com.example.Expenses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;



@Service
public class ExpensesServices 
{
	@Autowired
	UserDetailsRepo repo1;
	@Autowired 
	InsertItemRepo repo2;

	BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
	public void registerUser(String number,String username,String password,String mail) 
	{
		Users user=new Users(number,username,password,mail);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo1.save(user);
		// TODO Auto-generated method stub
		
	}
public List<Users> checkdetails(String username) {
		
		List<Users> result;// TODO Auto-generated method stub
	result= repo1.filter(username);
	return result;
	 }
public List<Users> accountDetails(String username) {
	List<Users> result1;
	result1=repo1.filter(username);
	return result1;
		
}
public void inserItem(String date, String item, String amount) 
{
	InsertItem insert=new InsertItem(date,item,amount);
	repo2.save(insert);
	// TODO Auto-generated method stub
	
}
public List<InsertItem> fetchItem(String date) 
{
	List<InsertItem> result1;
	result1=repo2.filter(date);
	return result1;
}
@Transactional
public List<Users> changeNumber(String oldnumber, String newnumber) {
	
	repo1.update(oldnumber,newnumber);
	return null;
}
@Transactional
public List<Users> changeMail(String oldmail, String newmail) {
	repo1.update1(oldmail,newmail);// TODO Auto-generated method stub
	return null;
}
@Transactional
public List<Users> changePassword(String username, String newpassword) {
	String newpassword1 = new String();
	newpassword1=passwordEncoder.encode(newpassword);
	repo1.update2(username,newpassword1);
	return null;
}
}
