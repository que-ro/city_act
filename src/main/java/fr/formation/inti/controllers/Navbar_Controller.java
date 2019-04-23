package fr.formation.inti.controllers;

import javax.servlet.http.HttpServletRequest;

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
	
	@Autowired
	IUsersDao dao_usr;
	
	@RequestMapping("/logout")
	public RedirectView logout(Model model, HttpServletRequest request)
	{
		request.getSession().invalidate();
		return new RedirectView("accueil");
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RedirectView login(Model model, HttpServletRequest request, @RequestParam(name="mail") String mail, @RequestParam(name="pwd") String pwd)
	{
		Users usr = dao_usr.findByMail(mail);
		if(Login_Utils.checkPassword(pwd, usr.getPassword()))
		{
			request.getSession().setAttribute("user", usr);
			return new RedirectView("accueil");
		}
		else
		{
			//REDIRECT VERS PAGE WRONG PASSWORD
			System.out.println("NEIN NCH DIE GUT PASSWORD");
			return new RedirectView("accueil");
		}
		
	}

}
