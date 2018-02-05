package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.k19.modelo.Autor;


public class TesteCriteriaAutor {

	public static void main(String[] args) {
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("k21_criteria_pu");
		EntityManager manager = factory.createEntityManager();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Autor> c = cb.createQuery(Autor.class);
		Root<Autor> l = c.from(Autor.class);
		c.select(l);
		
		TypedQuery<Autor> query = manager.createQuery(c);
		List<Autor> autores = query.getResultList();
		
		for(Autor autor: autores){
			System.out.println(autor.getNome());
		}
	}


	}


