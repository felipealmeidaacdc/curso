package br.com.k19.testes;

import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Editora;

public class InserirEditoraComJPA {

	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("livraria");
		
		EntityManager manager = factory.createEntityManager();
		
		Editora novaEditora = new Editora();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite o nome da Editora:");
		novaEditora.setNome(entrada.nextLine());
		
		System.out.println("Digite o email da Editora:");
		novaEditora.setEmail(entrada.nextLine());
		
		
		entrada.close();
		
		manager.persist(novaEditora);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		factory.close();

	}

}
