package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		
		Person p1 = new Person(null, "Augusto", "augusto@gmail.com");
		Person p2 = new Person(null, "Thais", "thais@gmail.com");
		Person p3 = new Person(null, "Andressa", "andressa@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//inicia uma transação
		em.getTransaction().begin();
		
		System.out.println("Inicialização Hibernate");
		
		//persiste no banco
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		Person p4 = em.find(Person.class, 1);
		System.out.println(p4);
		
		//comita a transação
		em.getTransaction().commit();
		
		System.out.println("Operação concluída!");
		
		em.close();
		emf.close();
		
	}

}
