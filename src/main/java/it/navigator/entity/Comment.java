package it.navigator.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dimas on 18.06.2017.
 */
@Entity
@Table(name = "comment")
public class Comment {
    String text;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
            @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
            @JsonIgnore
    Message message;

    public Comment() {
    }

    public Comment(String text, User user, Message message) {
        this.text = text;
        this.user = user;
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
