package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;

public class TestePersistenceContext {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("----PRIMEIRO FIND--------");
		Estado estado = manager.find(Estado.class, 1L);
		System.out.println("----SGUNDO FIND----------");
		estado = manager.find(Estado.class, 1L);
	}

}
