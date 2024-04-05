package com.example.M10batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Control {
	
	@Autowired
	Serv serv;
	
	@GetMapping("/home")
	public String home()
	{
		return "homepage";
	}

	@GetMapping("/adduser")
	public String adduser(Student s)
	{
		serv.add(s);
		return "added";
	}
	
	@GetMapping("/getuser")
	public ModelAndView getuser( int id)
	{
		ModelAndView m = new ModelAndView("userdata");
		Student obj = serv.getuser(id);
		m.addObject("user",obj);
		return m;
	}
	
	@GetMapping("/updateuser")
	@ResponseBody
	public String updateuser(Integer id,Student s)
	{
		boolean b = serv.update(id,s);
		if(b == true)
		{
			return "<h1>Updated</h1>";
		}
		else
		{
			return "<h1>Not Updated</h1>";
		}
	}
	
	@GetMapping("/deleteuser")
	@ResponseBody
	public String deleteuser(Integer id)
	{
		serv.delete(id);
		return "<h1>Deleted</h1>";
	}
}
