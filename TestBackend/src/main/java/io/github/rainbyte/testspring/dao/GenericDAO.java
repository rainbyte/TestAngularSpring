package io.github.rainbyte.testspring.dao;

import io.github.rainbyte.testspring.dto.GenericDTO;
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

    default void save(GenericDTO<T> dto) {
        T entity = dto.toEntity();
        getRepo().save(entity);
    }

    default void deleteById(int id) {
        getRepo().deleteById(id);
    }

}
