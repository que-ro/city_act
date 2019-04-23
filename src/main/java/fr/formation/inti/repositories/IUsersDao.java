package fr.formation.inti.repositories;

import org.springframework.data.repository.Repository;

import fr.formation.inti.entities.Users;

public interface IUsersDao extends Repository<Users, Integer> {
	
	public Users findByMail(String mail);
	public void save(Users usr);

}
