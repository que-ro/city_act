package fr.formation.inti.restcontrollers;

import java.util.ArrayList;
import java.util.Map;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IUsersDao;
import fr.formation.inti.services.NotificationService;
import fr.formation.inti.utils.Login_Utils;
@Controller
public class ResetPsd {
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	IUsersDao dao_usr;
	
	
		@RequestMapping(value="/mailcheck", method = RequestMethod.POST )
		public String mailcheck(Model model, HttpServletRequest request,  @RequestParam(name="mail")String mail)
		{	
			ArrayList<String> listErrors = new ArrayList<String>();
			if(dao_usr.findByMail(mail) == null)
				

			{
				listErrors.add("Le mail renseigné n'est pas enregistré dans notre base de données");
				System.out.println("Mail inexistant, veuillez recommencer");
				model.addAttribute("errors", listErrors);
				return "forgottenpsd";
			}
			
		else {  
				
				try { 
					// Generate random 36-character string token for reset password 
					Users usr = dao_usr.findByMail(mail);
					usr.setResetToken(UUID.randomUUID().toString()); //rajouter token dans entities
					// Save token to database
					dao_usr.save(usr);

					//String appUrl = request.getScheme() + "://" + request.getServerName() + "://" + request.getServerPort();
					String appUrl = request.getScheme() +"://localhost:8080";
							
					notificationService.sendNotification(dao_usr.findByMail(mail));
					
			}catch (MailException e) {
				//catch error
				System.out.println("Error sending email" + e.getMessage());

				// Add success message to view
				 model.addAttribute("successMessage", "Un lien de réinitialisation vient de vous être envoyer " + dao_usr.findByMail(mail));
		}
}
			return"Accueil";
		}
		

		// Display form to reset password
		@RequestMapping(value = "/resetmp", method = RequestMethod.GET)
		public String displayResetmp(Model model, @RequestParam("token") String token) {
			
			Users user = dao_usr.findUserByResetToken(token);

			if (user!= null) { // Token found in DB
				model.addAttribute("resetToken", token);
			} else { // Token not found in DB
				System.out.println("Oops!  Ce lien de réinitialisation est invalide.");
				model.addAttribute("errorMessage", "Oops!  Ce lien de réinitialisation est invalide.");
			}

						return "resetmp";
		}

		// Process reset password form
		@RequestMapping(value = "/resetmp", method = RequestMethod.POST)
		public String setNewPassword(Model model,@RequestParam(name="pwd") String pwd, @RequestParam(name="token") String token, @RequestParam(name="repeated_pwd") String repeated_pwd, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
			ArrayList<String> listErrors = new ArrayList<String>();
			// Find the user associated with the reset token
			Users user = dao_usr.findUserByResetToken(token);
			//((Users)request.getSession().getAttribute("user")).getIdusers()
			
			System.out.println(pwd + " == " + repeated_pwd+ "    " + pwd.equals(repeated_pwd) + " users = "+ user + " token = "+ token);

			// This should always be non-null but we check just in case
			if (user!= null) { System.out.println("je suis là");
				
				Users resetUserpwd = user; //resetuserpdw devient le user findbyresettoken
	            
				if(!pwd.equals(repeated_pwd))
				{
					System.out.println("Le password et le password de confirmation ne corresponde pas");
					listErrors.add("Le password et le password de confirmation ne corresponde pas");
					model.addAttribute("errors", listErrors);
					return "resetmp";
				}
				 if(pwd.equals(repeated_pwd)) {
				
				// Set new password    
	           	resetUserpwd.setPassword(Login_Utils.hashPassword(pwd));
								
				// Set the reset token to null so it cannot be used again
				resetUserpwd.setResetToken(null);

				// Save user
				dao_usr.save(resetUserpwd);

				// In order to set a model attribute on a redirect, we must use
				// RedirectAttributes
				redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");
				System.out.println("BRAVO");
				return "accueil";
				 }
			} else {System.out.println("PROBLEME");
				model.addAttribute("errorMessage", "Oops!  This is an invalid password reset link.");
				
			}
			System.out.println("Fin méthode post, retour à l'accueil");
			return "accueil";
	   }
	   
	    // Going to reset page without a token redirects to login page
		@ExceptionHandler(MissingServletRequestParameterException.class)
		public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
			return new ModelAndView("redirect:forgottenpsd");
		}


}

//Resolved [org.springframework.web.bind.MissingServletRequestParameterException: Required String parameter 'pwd' is not present]s
		


