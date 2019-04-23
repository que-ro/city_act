package fr.formation.inti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.dao.IUsersDao;
import fr.formation.inti.entities.Users;

@Controller
public class ControllerHenry {
	
	@Autowired
	IUsersDao dao;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(Model model,@RequestParam(name="name",required=false,defaultValue="Henry") String age)
	{	
		
		List<Users> list = dao.findAll();
		
		for(Users u : list)
			System.out.println(u.getMail()+" "+u.getPassword());;
		return "accueil";
	}
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public String test2(Model model)
	{	
		return "accueil";
	}

}
