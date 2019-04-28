package fr.formation.inti.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.entities.Comment;
import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IAmbientPowerDao;

@Controller
public class Presentationambientpower_Controller {
	
@Autowired
IAmbientPowerDao dao_ap;

@RequestMapping(value="/goto_ambienpower_presentation/{id}/formap_post_comment", method = RequestMethod.POST)
public String presentationprojet(Model model,  @ModelAttribute @Valid AmbientPower ambientpower, BindingResult bindingResult, @PathVariable Integer id, @RequestParam(name="comment_text") String commentText, HttpServletRequest request)
{	
	Comment comment = new Comment();
	comment.setDate(new Date());
	comment.setText(commentText);
	comment.setAmbientPower(ambientpower);
	comment.setUsers((Users) request.getSession().getAttribute("user"));
	
	model.addAttribute("ambientpower", ambientpower);
	return "/goto_ambienpower_presentation/"+ id;
	
}


}
