package testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.search.SearchFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import modelo.Pessoa;

public class Busca {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();
		
		FullTextEntityManager fullTextManager = Search.getFullTextEntityManager(manager);
		SearchFactory searchFactory = fullTextManager.getSearchFactory();
		QueryBuilder pessoaQueryBuilder = 
				searchFactory.buildQueryBuilder().forEntity(Pessoa.class).get();
		
		org.apache.lucene.search.Query luceneQuery
		= pessoaQueryBuilder.keyword().onField("nome").matching("Rafael Cosentino").createQuery();
		
		javax.persistence.Query jpaQuery =
				fullTextManager.createFullTextQuery(luceneQuery, Pessoa.class);
		
		List<Pessoa> pessoas = jpaQuery.getResultList();
		
		for (Pessoa p : pessoas) {
			System.out.println(p.getNome());
		}
		manager.close();
		factory.close();
	}

}
