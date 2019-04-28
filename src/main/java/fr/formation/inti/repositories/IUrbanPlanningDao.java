package fr.formation.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import fr.formation.inti.entities.UrbanPlanning;

public interface IUrbanPlanningDao extends Repository<UrbanPlanning, Integer>  {
	public UrbanPlanning findById(Integer i);

	public void save(UrbanPlanning up);

	public List<UrbanPlanning> findAll();
	
	@Query("SELECT max(up.id) FROM UrbanPlanning up")
	Integer getMaxId();

}
