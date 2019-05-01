package fr.formation.inti.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.formation.inti.restcontrollers.Users_RestController;

public class Login_Utils {
	
	static Logger logger = LoggerFactory.getLogger(Login_Utils.class);
	
	public static String hashPassword(String password) {
		
		logger.info("fr.formation.inti.utils.Login_Utils.java - method hashPassword");
		int workload = 12;
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password, salt);
		return(hashed_password);
	}
	
	public static boolean checkPassword(String password, String stored_hash) {
		logger.info("fr.formation.inti.utils.Login_Utils.java - method checkPassword");
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password, stored_hash);

		return(password_verified);
	}

}
