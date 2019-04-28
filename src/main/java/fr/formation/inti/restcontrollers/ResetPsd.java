package fr.formation.inti.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.inti.entities.Users;
import fr.formation.inti.services.NotificationService;
@RestController
public class ResetPsd {
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/forgottenpsd")
	public String mpf() {
	return"Mot de passe oublié";
}
	
		@RequestMapping("/resetmp")
			public String resetmp_form() {
			Users usr1= new Users();
			usr1.setFirstname("Jeanne");
			usr1.setLastname("Ty");
			usr1.setMail("bmargaux135@gmail.com");
			
			try {
			notificationService.sendNotification(usr1);
			} catch (MailException e) {
				//catch error
				System.out.println("Error sending email" + e.getMessage());
			}
			return"votre demande à bien été prise en compte";
		}
}
		
