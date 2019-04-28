package fr.formation.inti.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.entities.Signalement;
import fr.formation.inti.entities.UrbanPlanning;
import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IAmbientPowerDao;
//import fr.formation.inti.repositories.ICommentDao;
import fr.formation.inti.repositories.ISignalementDao;
import fr.formation.inti.repositories.IUrbanPlanningDao;
import fr.formation.inti.repositories.IUsersDao;

@Controller
public class ControllerTest {
	
	@Autowired
	IUrbanPlanningDao dao_up;
	@RequestMapping("/presentationprojet")
	public String presentationprojet(Model model)
	{	UrbanPlanning up = dao_up.findById(11);
	model.addAttribute("idprojet", up);
		return "presentationprojet";
	}
	
//	@Autowired
//	IAmbientPowerDao dao_ap;
	@RequestMapping("/presentationambientpower")
	public String presentationambientpower(Model model, HttpServletRequest request)
	{	
//		AmbientPower ap = dao_ap.findByIdambientpower(32);
//		System.out.println(" ///////////////////////////////");
//		System.out.println(ap.getDatecreation());
//		model.addAttribute("idambientpower", ap);
		
		return "presentationambientpower";
	}
	
	@Autowired
	ISignalementDao dao_sig;
	@RequestMapping("/presentationsignalement")
	public String presentationsignalement(Model model)
	{	Signalement sig = dao_sig.findById(21);
	model.addAttribute("idsignalement", sig);
			return "presentationsignalement";
	}
	
	@RequestMapping("/map_nv")
	public String map_nv(Model model)
	{	
		return "map_nv";
	}
	
	@RequestMapping("/map_nvtodelete")
	public String map_nvtodelete(Model model)
	{	
		return "map_nvtodelete";
	}
	
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


	@RequestMapping("/filterconnection")
	public String filterconnection(Model model)
	{	
		return "filterconnection";
	}
	
	@RequestMapping("/formprojets")
	public String formprojets(Model model)
	{	
		model.addAttribute("urbanPlanning", new UrbanPlanning());
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
		model.addAttribute("signalement", new Signalement());
		return "formsignalement";
	}
	
	@RequestMapping("/falselogin")
	public String falselogin(Model model)
	{	
		return "falselogin";
	}
	
//	@Autowired
//	ICommentDao dao_com;
//	@RequestMapping("/formcomment")
//	
//	public String formcomment(Model model)
//	{	Signalement com = dao_sig.findByIdsignalement(21);
//	model.addAttribute("idcomment", com);
//	return "formcomment";}
}
