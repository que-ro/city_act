package fr.formation.inti.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.entities.Comment;
import fr.formation.inti.entities.IAllTypeEntities;
import fr.formation.inti.entities.Signalement;
import fr.formation.inti.entities.UrbanPlanning;
import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IAmbientPowerDao;
import fr.formation.inti.repositories.ICommentDao;

import fr.formation.inti.repositories.ISignalementDao;
import fr.formation.inti.repositories.IUrbanPlanningDao;
import fr.formation.inti.repositories.IUsersDao;

@Controller
public class ControllerTest {
	
	@RequestMapping("/testflip")
	public String testflip(Model model)
	{	
		return "testflip";
	}
	
	@Autowired
	IUrbanPlanningDao dao_up;
	@RequestMapping("/presentationprojet")
	public String presentationprojet(Model model)
	{	UrbanPlanning up = dao_up.findById(11);
	model.addAttribute("idprojet", up);
		return "presentationprojet";
	}
	

	@RequestMapping("/presentationambientpower")
	public String presentationambientpower(Model model, HttpServletRequest request)
	{	
//		AmbientPower ap =(AmbientPower) request.getAttribute("idambientpower");
//
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
	
	@Autowired
	IAmbientPowerDao dao_ap;
	@Autowired
	ICommentDao dao_com;
	
	@RequestMapping("/monprofil")
	public String monprofil(Model model, HttpServletRequest request)

	{	
		Users usr = dao_usr.findByIdusers(((Users) request.getSession().getAttribute("user")).getIdusers());
		
		List<IAllTypeEntities> listAll = new ArrayList<IAllTypeEntities>();
		
		Set<AmbientPower> list_ap = usr.getAmbientPowers();
		Set<Signalement> list_sig = usr.getSignalements();
		Set<UrbanPlanning> list_up = usr.getUrbanPlannings();
		
		for(UrbanPlanning up : list_up)
		{
			listAll.add((IAllTypeEntities) up) ;
		}
		for(Signalement sig : list_sig) 
		{
			listAll.add((IAllTypeEntities) sig) ;
		}
		for(AmbientPower ap : list_ap)
		{
			listAll.add((IAllTypeEntities) ap) ;
		}
		
		List<Comment> comments = dao_com.findByUsers(usr);
		
		System.out.println(comments.size() + "----------------------------------------------------");
		model.addAttribute("comments", comments);
		model.addAttribute("usr_projects", listAll);
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
