package fr.formation.inti.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Comment;
import fr.formation.inti.entities.UrbanPlanning;
import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.ICommentDao;
import fr.formation.inti.repositories.IUsersDao;

@Controller
public class Presentationprojetammenagement_Controller {
	
	Logger logger = LoggerFactory.getLogger(Presentationprojetammenagement_Controller.class);
	
	@Autowired
	ICommentDao dao_com;
	@Autowired
	IUsersDao dao_usr;
	
	@RequestMapping(value="/goto_projet_presentation/{id}/formap_post_comment", method = RequestMethod.POST)
	public void presentationprojet(HttpServletResponse response, Model model,  @ModelAttribute @Valid UrbanPlanning projet, BindingResult bindingResult, @PathVariable Integer id, @RequestParam(name="comment_text") String commentText, HttpServletRequest request) throws IOException
	{	
		logger.info("fr.formation.inti.controllers.Presentationprojetammenagement_Controller.java - method /goto_projet_presentation/{"+id+"}/formap_post_comment");
		Comment comment = new Comment();
		comment.setDate(new Date());
		comment.setText(commentText);
		comment.setUrbanPlanning(projet);
		comment.setUsers(dao_usr.findByIdusers(((Users) request.getSession().getAttribute("user")).getIdusers()));
		dao_com.save(comment);
		logger.info("fr.formation.inti.controllers.Presentationprojetammenagement_Controller.java - method /goto_projet_presentation/{"+id+"}/formap_post_comment\" : comment: " + comment.getIdComment() + " saved for urban planning: " + id);
		model.addAttribute("projet", projet);
		response.sendRedirect("/goto_projet_presentation/"+ id);
		
	}

}
