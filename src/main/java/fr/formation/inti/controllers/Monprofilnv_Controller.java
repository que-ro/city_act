package fr.formation.inti.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import fr.formation.inti.repositories.IUsersDao;

public class Monprofilnv_Controller {

	
	@Autowired
	IUsersDao dao_usr;
	
	@Autowired
	IAmbientPowerDao dao_ap;
	@Autowired
	ICommentDao dao_com;
	
	@RequestMapping("/monprofilnv")
	public String monprofilnv(Model model, HttpServletRequest request)

	{	
		Users usr = dao_usr.findByIdusers(((Users) request.getSession().getAttribute("user")).getIdusers());
		
		List<IAllTypeEntities> listAll = new ArrayList<IAllTypeEntities>();
		
		Set<AmbientPower> list_ap = usr.getAmbientPowers();
		Set<Signalement> list_sig = usr.getSignalements();
		Set<UrbanPlanning> list_up = usr.getUrbanPlannings();
		
		for(UrbanPlanning up : list_up)
		{
			listAll.add((IAllTypeEntities) up) ;
		}
		for(Signalement sig : list_sig) 
		{
			listAll.add((IAllTypeEntities) sig) ;
		}
		for(AmbientPower ap : list_ap)
		{
			listAll.add((IAllTypeEntities) ap) ;
		}
		
		List<Comment> comments = dao_com.findByUsers(usr);
		
		System.out.println(comments.size() + "----------------------------------------------------");
		model.addAttribute("comments", comments);
		model.addAttribute("usr_projects", listAll);
		model.addAttribute("users", usr);

		return "monprofilnv";
	}	}

