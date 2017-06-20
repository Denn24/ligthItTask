package it.navigator.dao;

import it.navigator.entity.User;

/**
 * Created by Dimas on 18.06.2017.
 */
public interface UserDAO extends GenericDAO<User> {
    User findByLogin(String login);
}
