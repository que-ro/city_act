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

@Controller
public class ControllerTest {

	Logger logger = LoggerFactory.getLogger(ControllerTest.class);
	

	@Autowired
	IUrbanPlanningDao dao_up;
	@Autowired
	ISignalementDao dao_sig;
	@Autowired
	IUsersDao dao_usr;
	@Autowired
	IAmbientPowerDao dao_ap;
	@Autowired
	ICommentDao dao_com;

	
	@RequestMapping("/anonono")
	public String anonono(Model model)
	{
		logger.info("fr.formation.inti.controllers.ControllerTest.java - method anonono");
		return "a_nonono";
	}
	
	
	@RequestMapping("/CityAct")
	public String CityAct(Model model)
	{	
		logger.info("fr.formation.inti.controllers.ControllerTest.java - method CityAct");
		return "CityAct";
	}
	
	@RequestMapping("/CityActConnectNavbar")
	public String CityActConnectNavbar(Model model)
	{	
		logger.info("fr.formation.inti.controllers.ControllerTest.java - method CityActConnectNavbar");
		return "CityActConnectNavbar";
	}
	

	@RequestMapping("/filterconnection")
	public String filterconnection(Model model)
	{	
		
		return "filterconnection";
	}
	


}
