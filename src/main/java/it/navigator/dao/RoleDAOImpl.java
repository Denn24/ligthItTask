package it.navigator.dao;

import it.navigator.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by Dimas on 20.06.2017.
 */
@Repository
public class RoleDAOImpl extends GenericDAOImpl<Role> implements RoleDAO {

    @Override
    public Role findByName(String name){
        return (Role) sessionFactory.getCurrentSession().createQuery("from Role r where r.name =?1").setParameter(1,name).getSingleResult();
    }
}
