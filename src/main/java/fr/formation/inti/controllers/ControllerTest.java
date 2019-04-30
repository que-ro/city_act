package fr.formation.inti.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IUsersDao;

@Controller
public class ControllerTest {
	@RequestMapping("/mesprojetstest")
	public String mesprojetstest(Model model)
	{	
		return "mesprojetstest";
	}
	
	@RequestMapping("/CityAct")
	public String CityAct(Model model)
	{	
		return "CityAct";
	}
	
	@RequestMapping("/CityActConnectNavbar")
	public String CityActConnectNavbar(Model model)
	{	
		return "CityActConnectNavbar";
	}
	
	@Autowired
	IUsersDao dao_usr;
	
	@RequestMapping("/test")
	public String test(Model model, HttpServletRequest request)
	{	
		return "test";
	}
	

	@RequestMapping({"/","/accueil"})
	public String accueil(Model model)

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
	public String modifiermoncompte(Model model, HttpServletRequest request)
	{	
		Users usr = (Users) request.getSession().getAttribute("user");
		model.addAttribute("users", usr);
		return "modifiermoncompte";
	}
	
	@RequestMapping("/monprofil")
	public String monprofil(Model model, HttpServletRequest request)
	{	
		Users usr = (Users) request.getSession().getAttribute("user");
		model.addAttribute("users", usr);
		return "monprofil";
	}
	
	@RequestMapping("/Qui_sommes_nous")
	public String quisommesnous(Model model)
	{	
		model.addAttribute("titre", "example Spring Boot");
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
		model.addAttribute("users", new Users());
		return "signup_nv";
	}


	@RequestMapping("/filterconnection")
	public String filterconnection(Model model)
	{	
		return "filterconnection";
	}
	
	@RequestMapping("/formprojets")
	public String formprojets(Model model)
	{	
		return "formprojets";
	}
	
	@RequestMapping("/formambientpower")
	public String formambientpower(Model model)
	{	
		model.addAttribute("ambientPower", new AmbientPower());
		return "formambientpower";
	}

	@RequestMapping("/formsignalement")
	public String formsignalement(Model model)
	{	
		return "formsignalement";
	}
	
	@RequestMapping("/falselogin")
	public String falselogin(Model model)
	{	
		return "falselogin";
	}
	
		
}
