package fr.formation.inti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.formation.inti.repositories.IUsersDao;

@Controller
public class Modifiermoncompte_Controller {

	@Autowired
	IUsersDao dao_usr;
}
