package it.navigator.service;

import it.navigator.dao.MessageDAO;
import it.navigator.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dimas on 18.06.2017.
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDAO dao;

    @Override
    public Message findById(Long id){
        return dao.findById(id);
    }

    @Override
    public List<Message> findMessagesOrderByDateAsc(){
        return dao.findMessagesOrderByDateAsc();
    }

    @Override
    public void save(Message message){
        dao.save(message);
    }
}
