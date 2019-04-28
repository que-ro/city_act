//package fr.formation.inti.controllers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import fr.formation.inti.entities.AmbientPower;
//import fr.formation.inti.entities.IAllTypeEntities;
//import fr.formation.inti.entities.Signalement;
//import fr.formation.inti.entities.UrbanPlanning;
//import fr.formation.inti.repositories.IAmbientPowerDao;
//import fr.formation.inti.repositories.ISignalementDao;
//import fr.formation.inti.repositories.IUrbanPlanningDao;
//
//@Controller
//public class Map_Controller {
//	
//	@Autowired
//	IUrbanPlanningDao dao_up;
//	@Autowired
//	ISignalementDao dao_sig;
//	@Autowired
//	IAmbientPowerDao dao_ap;
//	
//	@RequestMapping("/map")
//	public String map_nv(Model model)
//	{	
//		List<UrbanPlanning> list_up = dao_up.findAll();
//		List<IAllTypeEntities> listAll = new ArrayList<IAllTypeEntities>();
//		for(UrbanPlanning up : list_up)
//		{
//			listAll.add((IAllTypeEntities) up) ;
//		}
//		List<Signalement> list_sig = dao_sig.findAll();
//		for(Signalement sig : list_sig) 
//		{
//			listAll.add((IAllTypeEntities) sig) ;
//		}
//		List<AmbientPower> list_ap = dao_ap.findAll();
//		for(AmbientPower ap : list_ap)
//		{
//			listAll.add((IAllTypeEntities) ap) ;
//		}
//		model.addAttribute("allProjects", listAll);
//		return "map_nvtodelete";
//	}
//	
//	@RequestMapping(value="/goto_ambienpower_presentation/{id}", method = RequestMethod.GET)
//
//	public String goto_ambienpower_presentation(Model model, @PathVariable Integer id)
//	{	
//		AmbientPower ap = dao_ap.findById(id);
//		model.addAttribute("ambientpower", ap);
//		return "presentationambientpower";
//		
//	}
//	
//	@RequestMapping(value="/goto_signalement_presentation/{id}", method = RequestMethod.GET)
//
//	public String goto_signalement_presentation(Model model, @PathVariable Integer id)
//	{	
//		Signalement sig = dao_sig.findById(id);
//		model.addAttribute("signalement", sig);
//		return "presentationsignalement";
//		
//	}
//	
//	@RequestMapping(value="/goto_projet_presentation/{id}", method = RequestMethod.GET)
//
//	public String goto_projet_presentation(Model model, @PathVariable Integer id)
//	{	
//		UrbanPlanning up = dao_up.findById(id);
//		model.addAttribute("projet", up);
//		return "presentationprojet";
//		
//	}
//
//}
