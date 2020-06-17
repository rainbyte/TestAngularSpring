package io.github.rainbyte.testspring.dao;

import io.github.rainbyte.testspring.repo.GenericRepo;

import java.util.List;

public interface GenericDAO<T> {

    GenericRepo<T> getRepo();

    default List<T> findAll() {
        return getRepo().findAll();
    }

    default T findById(int id) {
        return getRepo().findById(id);
    }

    default int save(T entity) {
        return getRepo().save(entity);
    }

    default void update(T entity) {
        getRepo().update(entity);
    }

    default void deleteById(int id) {
        getRepo().deleteById(id);
    }

}
