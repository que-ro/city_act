package fr.formation.inti.controllers;

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

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.repositories.IAmbientPowerDao;

@Controller
public class Presentationambientpower_Controller {
	
@Autowired
IAmbientPowerDao dao_ap;

@RequestMapping(value="/presentationambientpower_method", method = RequestMethod.GET)

public String presentationprojet(Model model,  @ModelAttribute @Valid AmbientPower ambientPower, BindingResult bindingResult)
{	AmbientPower ap = dao_ap.findByIdambientpower(32);

model.addAttribute("idambientpower", ap);

return "presentationambientpower";
	
}

}
