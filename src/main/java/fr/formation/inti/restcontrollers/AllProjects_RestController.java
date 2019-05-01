package fr.formation.inti.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.entities.IAllTypeEntities;
import fr.formation.inti.entities.Signalement;
import fr.formation.inti.entities.UrbanPlanning;
import fr.formation.inti.repositories.IAmbientPowerDao;
import fr.formation.inti.repositories.ISignalementDao;
import fr.formation.inti.repositories.IUrbanPlanningDao;

@RestController
@RequestMapping("/jsonAllProjects")
public class AllProjects_RestController {
	
	@Autowired
	IUrbanPlanningDao dao_up;
	@Autowired
	ISignalementDao dao_sig;
	@Autowired
	IAmbientPowerDao dao_ap;
	
	//Je sais c'est dégueu mais là y'a plus le choix
	@RequestMapping(value = "/projects/", method = RequestMethod.GET)
    public ResponseEntity<List<IAllTypeEntities>> listAllProjects() {
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
		if (listAll.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<IAllTypeEntities>>(listAll, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/projects/sig", method = RequestMethod.GET)
    public ResponseEntity<List<IAllTypeEntities>> listSigProjects() {
		List<IAllTypeEntities> listAll = new ArrayList<IAllTypeEntities>();
		List<Signalement> list_sig = dao_sig.findAll();
		for(Signalement sig : list_sig) 
		{
			listAll.add((IAllTypeEntities) sig) ;
		}
		if (listAll.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<IAllTypeEntities>>(listAll, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/projects/ap", method = RequestMethod.GET)
    public ResponseEntity<List<IAllTypeEntities>> listApProjects() {

		List<IAllTypeEntities> listAll = new ArrayList<IAllTypeEntities>();
		List<AmbientPower> list_ap = dao_ap.findAll();
		for(AmbientPower ap : list_ap)
		{
			listAll.add((IAllTypeEntities) ap) ;
		}
		if (listAll.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<IAllTypeEntities>>(listAll, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/projects/up", method = RequestMethod.GET)
    public ResponseEntity<List<IAllTypeEntities>> listUpProjects() {
		List<UrbanPlanning> list_up = dao_up.findAll();
		List<IAllTypeEntities> listAll = new ArrayList<IAllTypeEntities>();
		for(UrbanPlanning up : list_up)
		{
			listAll.add((IAllTypeEntities) up) ;
		}
		if (listAll.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<IAllTypeEntities>>(listAll, HttpStatus.OK);
    }

}

