package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Pessoa;

public class Program {

	public static void main(String[] args) {

		// Mudar os Ids para null pois j� h� a l�gica do banco de dados para incrementar o Id automaticamente conforme os objetos forem adicionados
//		Pessoa p1 = new Pessoa(1, "Henrique Lira", "henrique.melhado@hotmail.com");
//		Pessoa p2 = new Pessoa(2, "Carlos Eduardo", "ca.edu.lira@hotmail.com");
//		Pessoa p3 = new Pessoa(3, "Giulia Lira", "giulia.melhado@hotmail.com");
		
		Pessoa p1 = new Pessoa(null, "Henrique Lira", "henrique.melhado@hotmail.com");
		Pessoa p2 = new Pessoa(null, "Carlos Eduardo", "ca.edu.lira@hotmail.com");
		Pessoa p3 = new Pessoa(null, "Giulia Lira", "giulia.melhado@hotmail.com");
		
		// EntityManagerFactory � um objeto feito para instanciar objetos EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		// EntityManager � um objeto que faz a conex�o com o banco de dados e conceitos de persist�ncia implementados
		EntityManager em = emf.createEntityManager();

		// Como n�o � uma simples leitura do banco de dados, o objeto EntityManager precisa de uma TRANSA��O
		// Inicia uma transa��o com o banco de dados
		// Ou seja, em caso de altera��es no banco de dados abra uma TRANSA��O e depois confirmar as altera��es - em.getTransaction().commit();)
		em.getTransaction().begin();
		
		// - persist(): m�todo que adiciona o objeto ao banco de dados 
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		// - find(tipo da classe do objeto no BD (a tabela), id): buscar um objeto do banco de dados
		Pessoa p4 = em.find(Pessoa.class, 2);
		System.out.println(p4);
		
		// O JPA s� consegue remover uma entitade do banco de dados se essa entidade estiver MONITORADA
		// Um objeto MONITORADO � um objeto que:
		// 1) acabou de ser inserido no banco de dados
		// 2) um objeto recuperado do banco de dados e que o EntityManager ainda n�o foi fechado - em.close();
		Pessoa p5 = em.find(Pessoa.class, 2);
		em.remove(p5);
		System.out.println("Objeto " + p5 + "removido");
		
		// Confirma as altera��es feitas
		em.getTransaction().commit();
		
		// Mensagens em vermelho s�o a inicializa��o do Hibernate
		System.out.println("Pronto!");
		
		em.close();
		emf.close();
	}

}
