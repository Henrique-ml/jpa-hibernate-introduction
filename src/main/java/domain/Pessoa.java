package domain;

import java.io.Serializable;

// É sempre bom manter o pacote java.persistence para garantir que o programa está atendendo perfeitamente a especificação do JPA e não outra coisa
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// - @Entity: indicar que essa classe Pessoa é uma entidade de domínio que corresponde a uma tabela 
@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	// - @GeneratedValue: mapeamento indicando que a chave de Id vai ser gerada automaticamente pelo banco de dados
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;

	// Caso queira que o nome da coluna não seja o mesmo do atributo da classe faça:
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
