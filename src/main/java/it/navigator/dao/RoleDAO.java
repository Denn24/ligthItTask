package it.navigator.dao;

import it.navigator.entity.Role;

/**
 * Created by Dimas on 20.06.2017.
 */
public interface RoleDAO extends GenericDAO<Role> {
    Role findByName(String name);
}
