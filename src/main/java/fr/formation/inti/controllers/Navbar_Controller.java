package fr.formation.inti.controllers;

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

import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IUsersDao;
import fr.formation.inti.utils.Login_Utils;

@Controller
public class Navbar_Controller {
	
	Logger logger = LoggerFactory.getLogger(Navbar_Controller.class);
	
	@Autowired
	IUsersDao dao_usr;
	
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

}
