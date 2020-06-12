package io.github.rainbyte.testspring.service;

import java.util.List;

import io.github.rainbyte.testspring.dao.GenericDAO;
import io.github.rainbyte.testspring.dto.GenericDTO;

public interface GenericService<T> {

    GenericDAO<T> getDAO();

    default List<T> findAll() {
        return getDAO().findAll();
    }

    default T findById(int id) {
        return getDAO().findById(id);
    }

    default void save(GenericDTO<T> dto) {
        getDAO().save(dto);
    }

    default void deleteById(int id) {
        getDAO().deleteById(id);
    }
}