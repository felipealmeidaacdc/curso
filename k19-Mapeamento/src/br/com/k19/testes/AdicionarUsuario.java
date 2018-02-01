package br.com.k19.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Usuario;

public class AdicionarUsuario {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		
		EntityManager manager  = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Usuario usuario = new Usuario();
		usuario.setEmail("conta@k19.com.br");
		usuario.setDataDeCadastro(Calendar.getInstance());
		
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
		factory.close();

	}

}
