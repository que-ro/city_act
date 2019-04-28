package fr.formation.inti.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import fr.formation.inti.entities.AmbientPower;
import fr.formation.inti.entities.Comment;

public interface ICommentDao extends Repository<Comment, Integer> {

	public Comment findByIdComment(Integer i);

	public void save(Comment com);

	public List<Comment> findAll();
	
	public List<Comment> findByAmbientPower(AmbientPower ap);
}
