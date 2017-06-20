package it.navigator.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by the-red-paintings on 03.01.2017.
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {
    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> type;

    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T findById(Long id){
        return sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void save(T type){
        sessionFactory.getCurrentSession().save(type);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) sessionFactory.getCurrentSession().createQuery("from "+type.getName()).list();
    }

    @Override
    public void update(T type) {
        sessionFactory.getCurrentSession().update(type);
    }

    @Override
    public void updateAll(List<T> list) {
        list.forEach(item -> update(item));
    }

}
