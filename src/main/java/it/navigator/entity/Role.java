package it.navigator.entity;

import javax.persistence.*;

/**
 * Created by Dimas on 18.06.2017.
 */
@Entity
@Table(name = "role")
public class Role {

    String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
