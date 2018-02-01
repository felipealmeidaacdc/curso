package br.com.k19.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Candidato;
import br.com.k19.modelo.Endereco;

public class AdicionaCandidatoEndereco {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Endereco e = new Endereco();
		e.setEstado("S�o Paulo");
		e.setCidade("S�o Paulo");
		e.setLogradouro("Av. Brigadeiro Faria Lima");
		e.setNumero(1571);
		
		Candidato p = new Candidato();
		p.setNome("felipe");
		p.setNascimento(new GregorianCalendar(1984,10,30));
		p.setEndereco(e);
		
		manager.persist(p);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}

}
