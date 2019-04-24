package fr.formation.inti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/accueil")
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
	public String modifiermoncompte(Model model)
	{	
		return "modifiermoncompte";
	}
	
	@RequestMapping("/monprofil")
	public String monprofil(Model model)
	{	
		return "monprofil";
	}
	
	@RequestMapping("/Qui_sommes_nous")
	public String quisommesnous(Model model)
	{	
		return "Qui_sommes_nous";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{	
		return "signup";
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
