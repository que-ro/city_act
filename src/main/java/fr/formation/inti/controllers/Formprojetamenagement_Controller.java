package fr.formation.inti.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.formation.inti.entities.UrbanPlanning;
import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IUrbanPlanningDao;

@Controller
public class Formprojetamenagement_Controller {
	
	private static String EXTERNAL_FOLDER = "C:/cityact_externalfolder/pictures/";
	
	@Autowired
	IUrbanPlanningDao dao_up;
	
	@RequestMapping(value = "/projetamenagementform_method", method = RequestMethod.POST)
	public String projetamenagementform_method(@RequestParam("picture") MultipartFile picture, HttpServletRequest request, Model model, @ModelAttribute @Valid UrbanPlanning urbanPlanning, BindingResult bindingResult) throws IOException
	{	
		if(bindingResult.hasErrors())
		{
			return "formurbanPlanning";
		}
		urbanPlanning.setDatecreation(new Date());
		Integer maxId = dao_up.getMaxId();
		if(maxId != null)
		{
			//En base de donnée un trigger mets un 1 devant les projets ambient power à des fins de reconnaissance
			//Pour donc mettre le bon id la procédure suivante cherche le max id, enlève son 1, l'incrémente
			//et l'associe au nouvel objet Ambient Power.
			Integer newId = Integer.parseInt(((maxId.toString()).substring(1))) + 1;
			urbanPlanning.setId(newId);
		}
		else
		{
			urbanPlanning.setId(1);
		}
		//Maintenant on enregistre l'image dans C/ext_folder/pictures en prenant le nom origin du fichier avec l'id du projet
		//On enregistre ensuite le path de l'image dans l'objet urbanPlanning
		if (picture.isEmpty()) {
            return "a_nonono";
        }
		else
		{
			//Le 1 va être ajouté par le trigger de la bdd, pour différencier les trois types de projet, il faut donc l'ajouter dans le nom
//			String path = EXTERNAL_FOLDER + "1" + urbanPlanning.getId()+ "_" + picture.getOriginalFilename();
//			File upl = new File(path);
//		    upl.createNewFile();
//		    FileOutputStream fout = new FileOutputStream(upl);
//		    fout.write(picture.getBytes());
//		    fout.close();
//		    urbanPlanning.setPhotopath(path);
		    
		    String path ="src/main/resources/static/pictures/projects/" + "1" + urbanPlanning.getId()+ "_" + picture.getOriginalFilename();
		    File upl = new File(path);
			upl.createNewFile();
			FileOutputStream fout = new FileOutputStream(upl);
		    fout.write(picture.getBytes());
		    fout.close();
		    urbanPlanning.setPhotopath("/pictures/projects/" + "1" + urbanPlanning.getId()+ "_" + picture.getOriginalFilename());
		    
		}
		Users user = (Users) request.getSession().getAttribute("user");
		urbanPlanning.setUsers(user);
		dao_up.save(urbanPlanning);
		
		return "redirect:/map";
	}

}
