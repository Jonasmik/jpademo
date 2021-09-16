package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    List<Fee> fees;

    @ManyToMany(mappedBy = "persons", cascade = CascadeType.PERSIST)
    List<SwimStyle> styles;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.fees = new ArrayList<>();
        this.styles = new ArrayList<>();
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void AddFee(Fee fee) {
        this.fees.add(fee);
        if(fee != null) {
            fee.setPerson(this);
        }
    }

    public void addSwimStyle(SwimStyle style){
        if (style != null) {
            this.styles.add(style);
            style.getPersons().add(this);
        }
    }

    public void removeSwimStyle(SwimStyle swimStyle){
        if (swimStyle != null){
            styles.remove(swimStyle);
            swimStyle.getPersons().remove(this);
        }
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
