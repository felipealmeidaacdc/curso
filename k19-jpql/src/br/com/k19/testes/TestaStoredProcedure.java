package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;



public class TestaStoredProcedure {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_jpql_pu");
		EntityManager manager = factory.createEntityManager();
	
		
		//StoredProcedureQuery query = manager.c
		
		

	}

}
