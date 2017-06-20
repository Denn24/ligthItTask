package it.navigator.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Dimas on 18.06.2017.
 */
@Entity
@Table(name = "message")
public class Message {
    String text;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date date;

    @OneToMany
            @JoinColumn(name = "message_id")
    List<Comment> commentList;

    @ManyToOne
            @JoinColumn(name = "user_id")
    User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Message(String text) {
        this.text = text;
    }

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
