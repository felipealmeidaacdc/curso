package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.solr.client.solrj.beans.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
public class Pessoa {
@Id
@GeneratedValue
private Long id;

@Field
private String nome;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}


}
