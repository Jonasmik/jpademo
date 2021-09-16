package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Person implements Serializable {
    @Column(name = "ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;
    private String name;
    private int age;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getP_id() {
        return p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if(address != null){
            address.setPerson(this);
        }
    }
}
