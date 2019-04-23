package fr.formation.inti.dao;

import org.springframework.stereotype.Component;

@Component
public class ExampleDao implements IExampleDao {

	@Override
	public void afficher() {
		System.out.println("afficher message Dao");
	}

	@Override
	public String[] getAll() {
		String[] str= {"Henry","Nico","Quentin"};
		return str;
	}

}
