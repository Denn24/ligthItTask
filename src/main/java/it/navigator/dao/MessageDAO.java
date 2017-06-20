package it.navigator.dao;

import it.navigator.entity.Message;

import java.util.List;

/**
 * Created by Dimas on 18.06.2017.
 */
public interface MessageDAO extends GenericDAO<Message> {
    List<Message> findMessagesOrderByDateAsc();
}
