package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Livro;

public class AdicionaLivroAutor {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Autor a = new Autor();
		a.setNome("carlos felipe");
		
		Livro l = new Livro();
		l.setNome("JPA2");
		l.getAutores().add(a);
		
		manager.persist(a);
		manager.persist(l);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
