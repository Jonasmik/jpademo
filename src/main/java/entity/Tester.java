package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Tester {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Person p1 = new Person("Jønke", 1963);
        Person p2 = new Person("Blodie", 1959);
        Person p3 = new Person("Rasmus", 1977);
        Person p4 = new Person("Oliver", 1983);
        Person p5 = new Person("Robert", 1994);
        Person p6 = new Person("Tutti", 1971);
        Person p7 = new Person("Jenbo", 1969);
        Person p8 = new Person("Bobbert", 1991);
        Person p9 = new Person("Rapper", 1976);
        Person p10 = new Person("Jonas", 1982);

        Address a1 = new Address("store Tov", 2323, "Nr. Snede");
        Address a2 = new Address("Langgade 34", 1212, "Valby");
        Address a3 = new Address("storegade 31", 7612, "Lyngby");
        Address a4 = new Address("Fyrhøjvej 33", 5612, "København");
        Address a5 = new Address("Stenergade 23", 7212, "Hillerød");
        Address a6 = new Address("Skipperskrækgade 12", 4512, "Roskilde");
        Address a7 = new Address("Ligmagade 69", 8712, "Århus");
        Address a8 = new Address("storetågade 13", 7112, "Blåvand");
        Address a9 = new Address("lillemosevej 26", 4212, "Odense");
        Address a10 = new Address("Enduengade 20", 2412, "Lyngby");

        p1.setAddress(a1);
        p2.setAddress(a2);
        p3.setAddress(a3);
        p4.setAddress(a4);
        p5.setAddress(a5);
        p6.setAddress(a6);
        p7.setAddress(a7);
        p8.setAddress(a8);
        p9.setAddress(a9);
        p10.setAddress(a10);

        Fee f1 = new Fee(100);
        Fee f2 = new Fee(200);
        Fee f3 = new Fee(300);
        Fee f4 = new Fee(400);
        Fee f5 = new Fee(500);
        Fee f6 = new Fee(600);
        Fee f7 = new Fee(700);
        Fee f8 = new Fee(800);
        Fee f9 = new Fee(900);
        Fee f10 = new Fee(1000);

        p1.AddFee(f1);
        p2.AddFee(f2);
        p3.AddFee(f3);
        p4.AddFee(f4);
        p5.AddFee(f5);
        p6.AddFee(f6);
        p7.AddFee(f7);
        p8.AddFee(f8);
        p9.AddFee(f9);
        p10.AddFee(f10);

        SwimStyle s1 = new SwimStyle("Crawl");
        SwimStyle s2 = new SwimStyle("Butterfly");
        SwimStyle s3 = new SwimStyle("Breast stroke");
        SwimStyle s4 = new SwimStyle("Crawl");
        SwimStyle s5 = new SwimStyle("Butterfly");
        SwimStyle s6 = new SwimStyle("Breast stroke");
        SwimStyle s7 = new SwimStyle("Crawl");
        SwimStyle s8 = new SwimStyle("Butterfly");
        SwimStyle s9 = new SwimStyle("Breast stroke");
        SwimStyle s10 = new SwimStyle("Crawl");

        p1.addSwimStyle(s1);
        p2.addSwimStyle(s2);
        p3.addSwimStyle(s3);
        p4.addSwimStyle(s4);
        p5.addSwimStyle(s5);
        p6.addSwimStyle(s6);
        p7.addSwimStyle(s7);
        p8.addSwimStyle(s8);
        p9.addSwimStyle(s9);
        p10.addSwimStyle(s10);



        em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            em.persist(p5);
            em.persist(p6);
            em.persist(p7);
            em.persist(p8);
            em.persist(p9);
            em.persist(p10);
        em.getTransaction().commit();

        em.getTransaction().begin();
            p1.removeSwimStyle(s3);
        em.getTransaction().commit();

        System.out.println("p1: " + p1.getP_id() + ", " + p1.getName());
        System.out.println("p2: " + p2.getP_id() + ", " + p2.getName());

        System.out.println("Jønkes gade: " + p1.getAddress().getStreet());

        System.out.println("Lad os se om to-vejs virker: " + a1.getPerson().getName());

        System.out.println("Hvem har betalt f2? Det har: " + f2.getPerson().getName());

        TypedQuery<Fee> q1 = em.createQuery("SELECT f FROM Fee f", Fee.class);
        List<Fee> fees = q1.getResultList();

        for (Fee f: fees){
            System.out.println(f.getPerson().getName() + ": " + f.getAmount() + " kr. Dato: " + f.getPayDate() + " adr: " + f.getPerson().getAddress().getCity());
        }
    }
}
