package fr.formation.inti.controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.entities.Comment;
import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IAmbientPowerDao;
import fr.formation.inti.repositories.ICommentDao;
import fr.formation.inti.repositories.IUsersDao;

@Controller
public class Presentationambientpower_Controller {
	
@Autowired
IAmbientPowerDao dao_ap;
@Autowired
ICommentDao dao_com;
@Autowired
IUsersDao dao_usr;


@RequestMapping(value="/goto_ambienpower_presentation/{id}/formap_post_comment", method = RequestMethod.POST)
public void presentationprojet(HttpServletResponse response, Model model,  @ModelAttribute @Valid AmbientPower ambientpower, BindingResult bindingResult, @PathVariable Integer id, @RequestParam(name="comment_text") String commentText, HttpServletRequest request) throws IOException
{	
	Comment comment = new Comment();
	comment.setDate(new Date());
	comment.setText(commentText);
	comment.setAmbientPower(ambientpower);
	comment.setUsers(dao_usr.findByIdusers(((Users) request.getSession().getAttribute("user")).getIdusers()));
	dao_com.save(comment);
	
	model.addAttribute("ambientpower", ambientpower);
	response.sendRedirect("/goto_ambienpower_presentation/"+ id);
	
}


}
