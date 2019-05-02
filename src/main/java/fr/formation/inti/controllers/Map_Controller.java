
package fr.formation.inti.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.entities.Comment;
import fr.formation.inti.entities.IAllTypeEntities;
import fr.formation.inti.entities.Signalement;
import fr.formation.inti.entities.UrbanPlanning;
import fr.formation.inti.repositories.IAmbientPowerDao;
import fr.formation.inti.repositories.ICommentDao;
import fr.formation.inti.repositories.ISignalementDao;
import fr.formation.inti.repositories.IUrbanPlanningDao;

@Controller
public class Map_Controller {
	
	Logger logger = LoggerFactory.getLogger(Map_Controller.class);
	
	@Autowired
	IUrbanPlanningDao dao_up;
	@Autowired
	ISignalementDao dao_sig;
	@Autowired
	IAmbientPowerDao dao_ap;
	@Autowired
	ICommentDao dao_com;
	
	@RequestMapping("/map")
	public String map_nv(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Map_Controller.java - method map");
		List<UrbanPlanning> list_up = dao_up.findAll();
		List<IAllTypeEntities> listAll = new ArrayList<IAllTypeEntities>();
		for(UrbanPlanning up : list_up)
		{
			listAll.add((IAllTypeEntities) up) ;
		}
		List<Signalement> list_sig = dao_sig.findAll();
		for(Signalement sig : list_sig) 
		{
			listAll.add((IAllTypeEntities) sig) ;
		}
		List<AmbientPower> list_ap = dao_ap.findAll();
		for(AmbientPower ap : list_ap)
		{
			listAll.add((IAllTypeEntities) ap) ;
		}
		model.addAttribute("allProjects", listAll);
		return "map_nvtodelete";
	}
	
	@RequestMapping(value="/goto_ambienpower_presentation/{id}", method = RequestMethod.GET)

	public String goto_ambienpower_presentation(Model model, @PathVariable Integer id)
	{	
		logger.info("fr.formation.inti.controllers.Map_Controller.java - method /goto_ambienpower_presentation/{"+id+"}");
		AmbientPower ap = dao_ap.findById(id);
		model.addAttribute("ambientpower", ap);
		List<Comment> comments = dao_com.findByAmbientPower(ap);
		for(Comment comment: comments)
		{
			comment.getUsers();
		}
		model.addAttribute("comments", comments);
		return "presentationambientpower";
		
	}
	
	@RequestMapping(value="/goto_signalement_presentation/{id}", method = RequestMethod.GET)

	public String goto_signalement_presentation(Model model, @PathVariable Integer id)
	{	
		logger.info("fr.formation.inti.controllers.Map_Controller.java - method /goto_signalement_presentation/{"+id+"}");
		Signalement sig = dao_sig.findById(id);
		model.addAttribute("signalement", sig);
		List<Comment> comments = dao_com.findBySignalement(sig);
		for(Comment comment: comments)
		{
			comment.getUsers();
		}
		model.addAttribute("comments", comments);
		return "presentationsignalement";
		
	}
	
	@RequestMapping(value="/goto_projet_presentation/{id}", method = RequestMethod.GET)

	public String goto_projet_presentation(Model model, @PathVariable Integer id)
	{	
		logger.info("fr.formation.inti.controllers.Map_Controller.java - method /goto_projet_presentation/{"+id+"}");
		UrbanPlanning up = dao_up.findById(id);
		model.addAttribute("projet", up);
		List<Comment> comments = dao_com.findByUrbanPlanning(up);
		for(Comment comment: comments)
		{
			comment.getUsers();
		}
		model.addAttribute("comments", comments);
		return "presentationprojet";
		
	}
	
	@RequestMapping(value="/filter_map", method = RequestMethod.POST)
	public String filter_map(Model model, @RequestParam(name="checkbox_filtersig", defaultValue="false") Boolean checkbox_filtersig, @RequestParam(name="checkbox_filterap", defaultValue="false") Boolean checkbox_filterap, @RequestParam(name="checkbox_filterup", defaultValue="false") Boolean checkbox_filterup)
	{	
		logger.info("fr.formation.inti.controllers.Map_Controller.java - method filter_map");
		List<IAllTypeEntities> listAll = new ArrayList<IAllTypeEntities>();
		
		if(checkbox_filterup) {
			List<UrbanPlanning> list_up = dao_up.findAll();
			for(UrbanPlanning up : list_up)
			{
				listAll.add((IAllTypeEntities) up) ;
			}
		}
		if(checkbox_filtersig) {
			List<Signalement> list_sig = dao_sig.findAll();
			for(Signalement sig : list_sig) 
			{
				listAll.add((IAllTypeEntities) sig) ;
			}
		}
		if(checkbox_filterap) {
			List<AmbientPower> list_ap = dao_ap.findAll();
			for(AmbientPower ap : list_ap)
			{
				listAll.add((IAllTypeEntities) ap) ;
			}
		}	
		model.addAttribute("allProjects", listAll);
		
		model.addAttribute("checkbox_filtersig", checkbox_filtersig);
		model.addAttribute("checkbox_filterap", checkbox_filterap);
		model.addAttribute("checkbox_filterup", checkbox_filterup);
		return "map_nvtodelete";
		
	}
	
	@RequestMapping("/formprojets")
	public String formprojets(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Map_Controller.java - method formprojets");
		model.addAttribute("urbanPlanning", new UrbanPlanning());
		return "formprojets";
	}
	
	@RequestMapping("/formambientpower")
	public String formambientpower(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Map_Controller.java - method formambientpower");
		model.addAttribute("ambientPower", new AmbientPower());

		return "formambientpower";
	}

	@RequestMapping("/formsignalement")
	public String formsignalement(Model model)
	{	
		logger.info("fr.formation.inti.controllers.Map_Controller.java - method formsignalement");
		model.addAttribute("signalement", new Signalement());
		return "formsignalement";
	}

}
