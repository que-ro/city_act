package fr.formation.inti.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.repositories.IUsersDao;
@Controller
public class Resetmp_Controller {
	
	@Autowired
	IUsersDao dao_usr;
	
//	@RequestMapping("/resetmp")
//	public String resetmp(Model model, HttpServletRequest request,  @RequestParam(name="mail")String mail, @RequestParam(name="pwd") String pwd, @RequestParam(name="repeated_pwd") String repeated_pwd)
//	{	
//		ArrayList<String> listErrors = new ArrayList<String>();
//		if(dao_usr.findByMail(mail) == null)
//		{
//			listErrors.add("Le mail renseigné n'est pas enregistré dans notre base de données");
//			System.out.println("Mail inexistant, veuillez recommencer");
//			model.addAttribute("errors", listErrors);
//			return "resetmp";
//		}
//		
//		else { 
//			//JavaMailSender
//		}
//		return "resetmp";
		
		/**on click (button) la methode va passer par ce controller: une fois mail vérifié s'il existe on va entrer dans la prochaine iteration qui va envoyer un formulaire à l'adresse mail renseignée.
		 * L'utilisateur va recevoir dans sa boite mail un lien qui va le renvoiyer vers une page html qui va lui permettre de reset le mp (autre methode dans autre controller - cette methode va checker si les 2 mp sont égaux et va injecter le nouveau mp hashé 
		 * dans la base de donnée et dans la ligne correspond à l'id de l'utilisateur. If mp not equals, la page retournée sera la même (ou peut etre ici mettre un validator qui check onlive si mp correspondent) 
		 * Si toutes les étapes sont dûment remplies, iduser get update et on invite l'utilisateur à ce log in grâce à un bouton qui renvoie à la methode post de login.
		 * **/
//		else
//		{
//			if(!pwd.equals(repeated_pwd))
//			{
//				System.out.println("Le password et le password de confirmation ne corresponde pas");
//				listErrors.add("Le password et le password de confirmation ne corresponde pas");
//				model.addAttribute("errors", listErrors);
//				return "resetmp";
//			}
//			else
//			{
//		return "resetmp";
//	}
}
//	}

