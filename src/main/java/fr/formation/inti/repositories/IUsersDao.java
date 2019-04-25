package fr.formation.inti.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import fr.formation.inti.entities.Users;

public interface IUsersDao extends Repository<Users, Integer> {
	
	public Users findByMail(String mail);
	public Users findByIdusers(Integer i);
	public void save(Users usr);
	public List<Users> findAll();

}
