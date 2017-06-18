package it.navigator.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dimas on 11.05.2017.
 */
@Entity
@Table(name = "statement", schema = "public")
public class Statement {
    @Id
    private Integer id;
    @Column
    private String fio;
    @Transient
    private double summ;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "statement_id")
    private List<Mark> marks;

    @PostLoad
    public void onLoad(){
        for (Mark mark: marks)
            summ += mark.getValue();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }
}
