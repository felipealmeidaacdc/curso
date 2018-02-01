package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteLazyIntialization {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_entity_manager_pu");
		EntityManager manager = factory.createEntityManager();
		
		//Objeto carredo em modo lazy
		Pessoa p = manager.getReference(Pessoa.class, 1L);
		manager.close();
		factory.close();
		
		//tenta usar um dado do objeto
		System.out.println(p.getNome());

	}

}
