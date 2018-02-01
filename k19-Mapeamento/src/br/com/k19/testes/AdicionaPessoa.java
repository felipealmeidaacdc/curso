package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;
import br.com.k19.modelo.PessoaFisica;
import br.com.k19.modelo.PessoaJuridica;

public class AdicionaPessoa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Felipe");
		
		PessoaFisica p2 = new PessoaFisica();
		p2.setNome("Felipe");
		p2.setCpf("1234");
		
		PessoaJuridica p3 = new PessoaJuridica();
		p3.setNome("K19");
		p3.setCnpj("567788");
		
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();

	}

}
