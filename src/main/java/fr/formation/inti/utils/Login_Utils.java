package fr.formation.inti.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Login_Utils {
	
	public static String hashPassword(String password) {
		int workload = 12;
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password, salt);
		return(hashed_password);
	}
	
	public static boolean checkPassword(String password, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password, stored_hash);

		return(password_verified);
	}

}
