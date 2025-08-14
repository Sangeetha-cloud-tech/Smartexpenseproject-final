package com.example.Expenses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ExpensesController 
{
	@Autowired
	ExpensesServices servi;
	@GetMapping("/public/register")
	public String register()
	{
	 return "register";
	}
	@GetMapping("/home")
	public String home()
	{
	 return "home";
	}
	@GetMapping("/public/forgotpassword")
	public String forgotPassword()
	{
	 return "forgotpassword";
	}
	@GetMapping("/public/registerdone")
	public String registerdone()
	{
	 return "registerdone";
	}
	@GetMapping("/public/passwordchanged")
	public String passwordchanged()
	{
	 return "passwordchanged";
	}
	@GetMapping("/public/registeruser")
	public String registerUser(@RequestParam("number") String number,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("mail") String mail)
{
		List<Users> result1;
		result1=servi.checkdetails(username);
		if(result1.isEmpty())
		{
	servi.registerUser(number,username,password,mail);
	return "registerdone";
		}
		else
		{
			return "alreadyuser";
		}
	}
	@GetMapping("/logout")
	public String logout()
	{
	 return "register";
	}
	@GetMapping("/accountdetails")
	public String accountDetails(@RequestParam("username")String username,Model model)
	{
		List<Users>result;
		result=servi.accountDetails(username);
		model.addAttribute("info",result);
		return "accountdetailsfetched";
	}
	@GetMapping("/insertitem")
	public String insertItem(@RequestParam("date") String date,@RequestParam("item") String item,@RequestParam("amount") String amount)
	{
		servi.inserItem(date,item,amount);
		return "submittedexpense";
	}
	@GetMapping("/fetchitem")
	public String fetchItem(@RequestParam("date") String date,Model model)
	{
		List<InsertItem>result;
		result=servi.fetchItem(date);
		model.addAttribute("info",result);
		return "fetchedexpense";
	}
	@GetMapping("/changenumber")
	public String changeNumber(@RequestParam("oldnumber")String oldnumber,@RequestParam("newnumber")String newnumber)
	{
		servi.changeNumber(oldnumber,newnumber);
		return "updated";
	}
	@GetMapping("/changemail")
	public String changeMail(@RequestParam("oldmail")String oldmail,@RequestParam("newmail")String newmail)
	{
		servi.changeMail(oldmail,newmail);
		return "updated";
	}
	@GetMapping("/public/changepassword")
	public String changePassword(@RequestParam("username")String username,@RequestParam("newpassword")String newpassword)
	{
		List<Users>result;
		result=servi.changePassword(username,newpassword);
		return "passwordchanged";
	}
	
}
