package it.navigator.dao;

import it.navigator.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

    @Override
    public User findByLogin(String login){
        return (User) sessionFactory.getCurrentSession().createQuery("from User where login =?1").setParameter(1,login).getSingleResult();
    }
}
