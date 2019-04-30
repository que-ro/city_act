package fr.formation.inti.dao;

import org.springframework.stereotype.Component;

@Component
public class ExampleDao2 implements IExampleDao {

	@Override
	public void afficher() {
		System.out.println("afficher message Dao2");
	}

	@Override
	public String[] getAll() {
		String[] str= {"Henry","Nico","Quentin"};
		return str;
	}

}
