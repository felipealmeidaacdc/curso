package br.com.k19.testes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Estado;
import br.com.k19.modelo.Governador;

public class AdicionaEstadoGovernador {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();
		Scanner entrada = new Scanner(System.in);
		manager.getTransaction().begin();
		
		Governador g = new Governador();
		g.setNome(entrada.nextLine());
		
		
		Estado e = new Estado();
		e.setNome(entrada.nextLine());
		e.setGovernador(g);
		
		manager.persist(g);
		manager.persist(e);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();

	}

}
