package fr.formation.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import fr.formation.inti.entities.AmbientPower;

public interface IAmbientPowerDao extends Repository<AmbientPower, Integer> {

	public AmbientPower findById(Integer i);

	public void save(AmbientPower ap);

	public List<AmbientPower> findAll();
	
	@Query("SELECT max(ap.id) FROM AmbientPower ap")
	Integer getMaxId();
}
