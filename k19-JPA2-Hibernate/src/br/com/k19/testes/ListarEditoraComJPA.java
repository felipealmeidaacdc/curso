package br.com.k19.testes;
import java.util.List;
import javax.persistence.Query;

import br.com.k19.modelo.Editora;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListarEditoraComJPA {

	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("livraria");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("SELECT e FROM Editora e");
		List<Editora> editoras = query.getResultList();
		
		for(Editora e : editoras){
			System.out.println("EDITORA:"+e.getNome()+"-"+e.getEmail());
		}
	}

}
