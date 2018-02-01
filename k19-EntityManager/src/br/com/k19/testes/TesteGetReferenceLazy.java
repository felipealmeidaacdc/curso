package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteGetReferenceLazy {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		EntityManager em;
		emf = Persistence.createEntityManagerFactory("k21_entity_manager_pu");
		em = emf.createEntityManager();
		
		System.out.println("-----CHAMANDO O GETREFERENCE------");
		Pessoa p = em.getReference(Pessoa.class, 1L);
		System.out.println("------NAO FEZ O SELECT------------");
		
		em.close();
		emf.close();
		

	}

}
