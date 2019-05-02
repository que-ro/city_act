package fr.formation.inti.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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
import fr.formation.inti.utils.Login_Utils;

@Controller
public class Navbar_Controller {
	
	Logger logger = LoggerFactory.getLogger(Navbar_Controller.class);
	
	@Autowired
	IUsersDao dao_usr;
	@Autowired
	IUrbanPlanningDao dao_up;
	@Autowired
	ISignalementDao dao_sig;
	@Autowired
	IAmbientPowerDao dao_ap;
	@Autowired
	ICommentDao dao_com;
	
	@RequestMapping("/logout")
	public RedirectView logout(Model model, HttpServletRequest request)
	{
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method logout");
		request.getSession().invalidate();
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method logout: session is invalidated");
		return new RedirectView("accueil");
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RedirectView login(Model model, HttpServletRequest request, @RequestParam(name="mail") String mail, @RequestParam(name="pwd") String pwd)
	{
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method login");
		Users usr = dao_usr.findByMail(mail);
		if(usr == null)
		{
			logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method login: no user found for mail = "+mail);
			return new RedirectView("falselogin");   ///Changer sur la page de failed login
		}
		if(Login_Utils.checkPassword(pwd, usr.getPassword()))
		{
			logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method login: password matches, user" + usr.getIdusers() + "is set in session");
			request.getSession().setAttribute("user", usr);
			return new RedirectView("accueil");
		}
		else
		{
			logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method login: wrong password");
			return new RedirectView("falselogin");
		}
		
	}
	
	@RequestMapping("/accueil")
	public String accueil(Model model, HttpServletRequest request)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method accueil");
		return "accueil";
	}
	
	@RequestMapping("/faq")
	public String faq(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method faq");
		return "faq";
	}
	
	@RequestMapping("/forgottenpsd")
	public String forgottenpsd(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method forgottenpsd");
		return "forgottenpsd";
	}
	

	
	@RequestMapping("/mesalertes")
	public String mesalertes(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method mesalertes");
		return "mesalertes";
	}
	
	@RequestMapping("/modifiermoncompte")
	public String modifiermoncompte(Model model, HttpServletRequest request)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method modifiermoncompte");
		Users usr = (Users) request.getSession().getAttribute("user");
		model.addAttribute("users", usr);
		return "modifiermoncompte";
	}
	

	
	@RequestMapping("/monprofilnv")
	public String monprofilnv(Model model, HttpServletRequest request)

	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method monprofil");
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
		
		model.addAttribute("comments", comments);
		model.addAttribute("usr_projects", listAll);
		model.addAttribute("users", usr);

		return "monprofilnv";
	}
	
	@RequestMapping("/Qui_sommes_nous")
	public String quisommesnous(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method Qui_sommes_nous");
		return "Qui_sommes_nous";
	}
	
	@RequestMapping("/registration_success")
	public String registration_success(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method registration_success");
		return "registration_success";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method signup");
		return "signup";
	}
	

	@RequestMapping("/signup_nv")
	public String signup_nv(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method signup_nv");
		model.addAttribute("users", new Users());
		return "signup_nv";
	}
	
	@RequestMapping("/falselogin")
	public String falselogin(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Navbar_Controller.java - method falselogin");
		return "falselogin";
	}

}
