package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import fr.formation.inti.entities.Users;

public interface IUsersDao extends Repository<Users, Integer>{
	
	public List<Users> findAll();

}
