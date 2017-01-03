package it.navigator.dao;


import java.util.List;

/**
 * Created by the-red-paintings on 03.01.2017.
 */
public interface GenericDAO<T> {
    public List<T> getAll();

    public void update(T type);

    public void updateAll(List<T> list);
}
