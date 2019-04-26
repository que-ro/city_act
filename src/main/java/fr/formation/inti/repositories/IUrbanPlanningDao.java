package fr.formation.inti.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import fr.formation.inti.entities.UrbanPlanning;

public interface IUrbanPlanningDao extends Repository<UrbanPlanning, Integer>  {
	public UrbanPlanning findByIdplanningproposal(Integer i);

	public void save(UrbanPlanning up);

	public List<UrbanPlanning> findAll();

}
