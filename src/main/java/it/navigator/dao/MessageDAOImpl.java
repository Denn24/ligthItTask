package it.navigator.dao;

import it.navigator.entity.Message;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Dimas on 18.06.2017.
 */
@Repository
public class MessageDAOImpl extends GenericDAOImpl<Message> implements MessageDAO{

    @Override
    public List<Message> findMessagesOrderByDateAsc(){
        return sessionFactory.getCurrentSession().createQuery("from Message order by date DESC ").getResultList();
    }
}
