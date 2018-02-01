package br.com.k19.testes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Autor;

public class InserirAutoresComJPA {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");

		EntityManager manager = factory.createEntityManager();

		Autor novoAutor = new Autor();
		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o nome do Autor:");
		novoAutor.setNome(entrada.nextLine());

		entrada.close();

		manager.persist(novoAutor);
		manager.getTransaction().begin();
		manager.getTransaction().commit();

		factory.close();
	}

}
