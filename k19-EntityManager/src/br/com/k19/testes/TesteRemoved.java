package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteRemoved {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		//objeto no estado managed
		Pessoa p = manager.find(Pessoa.class, 1L);
		
		//objeto no estado removed
		manager.remove(p);

		//sincronizando e confirmando a transacao
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

}
