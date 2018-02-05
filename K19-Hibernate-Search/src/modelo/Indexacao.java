package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;



public class Indexacao {

	public static void main(String[] args) throws InterruptedException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();
		
		FullTextEntityManager  fullTextManager = Search.getFullTextEntityManager(manager);
		fullTextManager.createIndexer().startAndWait();
		
		manager.close();
		factory.close();

	}

}
