package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Person p1 = new Person("Jønke", 1963);
        Person p2 = new Person("Blodie", 1959);

        em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);

        em.getTransaction().commit();

        System.out.println("p1: " + p1.getId() + ", " + p1.getName());
        System.out.println("p2: " + p2.getId() + ", " + p2.getName());
    }
}
