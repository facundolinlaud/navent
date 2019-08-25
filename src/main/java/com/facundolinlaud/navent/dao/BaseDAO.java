package com.facundolinlaud.navent.dao;

public interface BaseDAO<T> {
    void insertOrUpdate(T t);

    void delete(T t);

    T select(int id);
}
