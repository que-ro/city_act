package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import fr.formation.inti.entities.Users; 

@Service
public class NotificationService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javamailSender) {
		this.javaMailSender = javamailSender;
	}
	
	public void sendNotification(Users usr1) throws MailException{
		//send email
		
		SimpleMailMessage mail= new SimpleMailMessage ();
		mail.setTo(usr1.getMail());
		mail.setFrom("cityactfrance@gmail.com");
		mail.setSubject("Lien de réinitialisation de mot de passe");
		mail.setText("Pour réinitialiser votre mot de passe veuillez cliquez sur ce "
				+ "lien à usage unique qui vous redirigera vers un formulaire de mise à jour.");
	
		javaMailSender.send(mail);
	
	}
}
