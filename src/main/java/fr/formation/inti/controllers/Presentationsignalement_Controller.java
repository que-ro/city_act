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
import fr.formation.inti.entities.Signalement;
import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.ICommentDao;
import fr.formation.inti.repositories.ISignalementDao;
import fr.formation.inti.repositories.IUsersDao;

@Controller
public class Presentationsignalement_Controller {
	
	Logger logger = LoggerFactory.getLogger(Presentationsignalement_Controller.class);
	
	@Autowired
	ISignalementDao sig;
	@Autowired
	ICommentDao dao_com;
	@Autowired
	IUsersDao dao_usr;
	
	
	@RequestMapping(value="/goto_signalement_presentation/{id}/formap_post_comment", method = RequestMethod.POST)
	public void presentationprojet(HttpServletResponse response, Model model,  @ModelAttribute @Valid Signalement signalement, BindingResult bindingResult, @PathVariable Integer id, @RequestParam(name="comment_text") String commentText, HttpServletRequest request) throws IOException
	{	
		logger.info("fr.formation.inti.controllers.Presentationsignalement_Controller.java - method /goto_signalement_presentation/{"+id+"}/formap_post_comment");
		Comment comment = new Comment();
		comment.setDate(new Date());
		comment.setText(commentText);
		comment.setSignalement(signalement);
		comment.setUsers(dao_usr.findByIdusers(((Users) request.getSession().getAttribute("user")).getIdusers()));
		dao_com.save(comment);
		logger.info("fr.formation.inti.controllers.Presentationsignalement_Controller.java - method /goto_signalement_presentation/{"+id+"}/formap_post_comment : comment: " + comment.getIdComment() + " saved for signalement: " + id);
		model.addAttribute("signalement", signalement);
		response.sendRedirect("/goto_signalement_presentation/"+ id);
		
	}

}
