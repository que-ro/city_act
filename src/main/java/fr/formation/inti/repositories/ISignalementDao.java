package fr.formation.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import fr.formation.inti.entities.Signalement;

public interface ISignalementDao extends Repository<Signalement, Integer>  {

	public Signalement findById(Integer i);

	public void save(Signalement sig);

	public List<Signalement> findAll();
	
	@Query("SELECT max(s.id) FROM Signalement s")
	Integer getMaxId();
}
