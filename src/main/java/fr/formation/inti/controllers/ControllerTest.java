package fr.formation.inti.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IUsersDao;
import fr.formation.inti.utils.Login_Utils;

@Controller
public class ControllerTest {
	
	@Autowired
	IUsersDao dao_usr;
	
	@RequestMapping("/test")
	public String test(Model model, HttpServletRequest request)
	{	
		Users user = dao_usr.findByMail("qszd");
		Users usr = new Users();
		usr.setMail("lala@mail.com");
		usr.setPassword(Login_Utils.hashPassword("test"));
		dao_usr.save(usr);
		System.out.println(user.getCity());
		return "test";
	}
	
	@RequestMapping("/accueil")
	public String accueil(Model model, HttpServletRequest request)
	{	
		return "accueil";
	}
	
	@RequestMapping("/faq")
	public String faq(Model model)
	{	
		return "faq";
	}
	
	@RequestMapping("/forgottenpsd")
	public String forgottenpsd(Model model)
	{	
		return "forgottenpsd";
	}
	
	@RequestMapping("/map")
	public String map(Model model)
	{	
		return "map";
	}
	
	@RequestMapping("/mesalertes")
	public String mesalertes(Model model)
	{	
		return "mesalertes";
	}
	
	@RequestMapping("/modifiermoncompte")
	public String modifiermoncompte(Model model)
	{	
		return "modifiermoncompte";
	}
	
	@RequestMapping("/monprofil")
	public String monprofil(Model model)
	{	
		return "monprofil";
	}
	
	@RequestMapping("/quisommesnous")
	public String quisommesnous(Model model)
	{	
		return "Qui_sommes_nous";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{	
		return "signup";
	}
	
	@RequestMapping("/signup_nv")
	public String signup_nv(Model model)
	{	
		return "signup_nv";
	}

}
