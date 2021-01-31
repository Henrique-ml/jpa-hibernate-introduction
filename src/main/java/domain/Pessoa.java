package domain;

import java.io.Serializable;

// � sempre bom manter o pacote java.persistence para garantir que o programa est� atendendo perfeitamente a especifica��o do JPA e n�o outra coisa
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// - @Entity: indicar que essa classe Pessoa � uma entidade de dom�nio que corresponde a uma tabela 
@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	// - @GeneratedValue: mapeamento indicando que a chave de Id vai ser gerada automaticamente pelo banco de dados
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;

	// Caso queira que o nome da coluna n�o seja o mesmo do atributo da classe fa�a:
//	@Column(name="nomecompleto")
//	private String name;

	public Pessoa() {
	}

	public Pessoa(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
