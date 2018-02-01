package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Departamento;
import br.com.k19.modelo.Funcionario;

public class AdicionaDepartamentoFuncionario {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();
		
		
		manager.getTransaction().begin();
		
		Funcionario  f  = new Funcionario();
		f.setNome("felipe");
		
		Departamento d = new Departamento();
		d.setNome("finaneiro");
		d.getFuncionarios().add(f);
		
		manager.persist(f);
		manager.persist(d);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		

	}

}