package it.navigator.entity;

import javax.persistence.*;

/**
 * Created by Dimas on 11.05.2017.
 */
@Entity
@Table(name = "mark", schema = "public")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer value;

    @ManyToOne
    @JoinColumn(name = "statement_id")
    private Statement statement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
