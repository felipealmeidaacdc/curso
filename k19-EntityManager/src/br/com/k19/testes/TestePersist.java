package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TestePersist {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
		
		// abrindo a trasacao
		manager.getTransaction().begin();
		
		//objeto no estado new
		Pessoa p = new Pessoa();
		p.setNome("carlos felipe");
		
		//objeto no estado managed
		manager.persist(p);
		
		//sincronizando e cofirmando a trasaçao
		manager.getTransaction().commit();
		
		System.out.println("Pessoa id:"+p.getId());
		manager.close();
		factory.close();

	}

}
