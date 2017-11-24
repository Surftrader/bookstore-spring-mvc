package com.hillel.dao;

import java.util.List;

public interface CRUDDao<T> {

    void save(T t);

    List<T> findAll();

    T findById(Integer id);

    void delete(T t);

    void update(T t);
}
