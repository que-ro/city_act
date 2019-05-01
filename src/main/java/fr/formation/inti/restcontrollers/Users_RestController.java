package fr.formation.inti.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.inti.entities.Users;
import fr.formation.inti.repositories.IUsersDao;

@RestController
@RequestMapping("/jsonUsers")
public class Users_RestController {
	
	Logger logger = LoggerFactory.getLogger(Users_RestController.class);
	
	@Autowired
	IUsersDao dao_usr;
	
	@RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> listAllUsers() {
		logger.info("fr.formation.inti.restcontrollers.Users_RestController.java - method /users/ (get users in json format)");
        List<Users> users = dao_usr.findAll();
        if (users.isEmpty()) {
        	
        	logger.info("fr.formation.inti.restcontrollers.Users_RestController.java - method /users/ (get users in json format) : no users were found in database");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        logger.info("fr.formation.inti.restcontrollers.Users_RestController.java - method /users/ (get users in json format) : users in json are sent");
        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }

}
