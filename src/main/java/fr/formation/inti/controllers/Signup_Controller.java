package fr.formation.inti.controllers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IUsersDao;
import fr.formation.inti.utils.Login_Utils;


@Controller
public class Signup_Controller {
	
	Logger logger = LoggerFactory.getLogger(Signup_Controller.class);

	@Autowired
	IUsersDao dao_usr;

	@RequestMapping(value = "/register_method", method = RequestMethod.POST)
	public String register_method(Model model, HttpServletRequest request, @ModelAttribute @Valid Users usr, BindingResult bindingResult, 
			
			@RequestParam(name="firstname") String firstname, @RequestParam(name="lastname") String lastname, 
			@RequestParam(name="pseudo") String pseudo, @RequestParam(name="mail") String mail, @RequestParam(name="birthdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthdate,
			@RequestParam(name="password") String password, @RequestParam(name="repeated_pwd") String repeated_pwd, @RequestParam(name="street") String street,
			@RequestParam(name="city") String city, @RequestParam(name="zipcode") String zipcode, @RequestParam(name="country") String country)
	{	
		
		logger.info("fr.formation.inti.controllers.Signup_Controller.java - method register_method");
		ArrayList<String> listErrors = new ArrayList<String>();
		
		if(bindingResult.hasErrors())
		{
			logger.info("fr.formation.inti.controllers.Signup_Controller.java - method register_method: binding results contain errors");
			return "signup_nv";
			
		}
		if(dao_usr.findByMail(mail) != null)
		{
			logger.info("fr.formation.inti.controllers.Signup_Controller.java - mail is already registered for mail: "+mail);
			listErrors.add("Le mail est déjà enregistré dans notre base de données");
			System.out.println("Ce mail est déjà utilisé, il faut en prendre un autre");
			model.addAttribute("errors", listErrors);
			return "signup_nv";
		}
		else
		{
			if(!password.equals(repeated_pwd))
			{
				logger.info("fr.formation.inti.controllers.Signup_Controller.java - method register_method: password don't correspond to repeated");
				listErrors.add("Le password et le password de confirmation ne corresponde pas");
				model.addAttribute("errors", listErrors);
				return "signup_nv";
			}
			else
			{
//				Users usr = new Users();
				usr.setBirthdate(birthdate);
				usr.setCity(city);
				usr.setCountry(country);
				usr.setFirstname(firstname);
				usr.setLastname(lastname);
				usr.setPseudo(pseudo);
				usr.setPassword(Login_Utils.hashPassword(password));
				usr.setMail(mail);
				usr.setStreet(street);
				usr.setZipcode(Integer.parseInt(zipcode));
				dao_usr.save(usr);
				logger.info("fr.formation.inti.controllers.Signup_Controller.java - method register_method: new user saved with the id: " + usr.getIdusers());
				return "registration_success";
			}
			
		}

	}


}