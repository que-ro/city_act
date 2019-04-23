package fr.formation.inti.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IUsersDao;
import fr.formation.inti.utils.Login_Utils;


@Controller
public class Signup_Controller {

	@Autowired
	IUsersDao dao_usr;

	@RequestMapping(value = "/register_method", method = RequestMethod.POST)
	public String register_method(Model model, HttpServletRequest request, @RequestParam(name="firstname") String firstname, @RequestParam(name="lastname") String lastname, 
			@RequestParam(name="pseudo") String pseudo, @RequestParam(name="mail") String mail, @RequestParam(name="birthdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthdate,
			@RequestParam(name="pwd") String pwd, @RequestParam(name="repeated_pwd") String repeated_pwd, @RequestParam(name="adress") String adress,
			@RequestParam(name="city") String city, @RequestParam(name="postal_code") String zipcode, @RequestParam(name="country") String country)
	{	
		
		System.out.println(pwd + " == " + repeated_pwd);
		ArrayList<String> listErrors = new ArrayList<String>();
		if(dao_usr.findByMail(mail) != null)
		{
			listErrors.add("Le mail est déjà enregistré dans notre base de données");
			System.out.println("Ce mail est déjà utilisé, il faut en prendre un autre");
			model.addAttribute("errors", listErrors);
			return "signup_nv";
		}
		else
		{
			if(!pwd.equals(repeated_pwd))
			{
				System.out.println("Le password et le password de confirmation ne corresponde pas");
				listErrors.add("Le password et le password de confirmation ne corresponde pas");
				model.addAttribute("errors", listErrors);
				return "signup_nv";
			}
			else
			{
				Users usr = new Users();
				usr.setBirthdate(birthdate);
				usr.setCity(city);
				usr.setCountry(country);
				usr.setFirstname(firstname);
				usr.setLastname(lastname);
				usr.setPseudo(pseudo);
				usr.setPassword(Login_Utils.hashPassword(pwd));
				usr.setMail(mail);
				usr.setStreet(adress);
				usr.setZipcode(Integer.parseInt(zipcode));
				dao_usr.save(usr);
				return "accueil";
			}
			
		}

	}


}
