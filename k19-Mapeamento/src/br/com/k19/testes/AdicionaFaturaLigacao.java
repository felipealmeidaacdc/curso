package br.com.k19.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Fatura;
import br.com.k19.modelo.Ligacao;

public class AdicionaFaturaLigacao {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Ligacao  ligacao1 = new Ligacao();
		ligacao1.setDuracao(162);
		
		Ligacao  ligacao2 = new Ligacao();
		ligacao2.setDuracao(324);
		
		Fatura fatura = new Fatura();
		fatura.setVecimento(new GregorianCalendar(2012,11,20));
		
		fatura.getLigacoes().add(ligacao1);
		fatura.getLigacoes().add(ligacao2);
		
		ligacao1.setFatura(fatura);
		ligacao2.setFatura(fatura);
		
		manager.persist(fatura);
		manager.persist(ligacao1);
		manager.persist(ligacao2);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		

	}

}
