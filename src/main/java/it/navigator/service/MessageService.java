package it.navigator.service;

import it.navigator.entity.Message;

import java.util.List;

/**
 * Created by Dimas on 18.06.2017.
 */
public interface MessageService {

    Message findById(Long id);

    List<Message> findMessagesOrderByDateAsc();

    void save(Message message);
}
