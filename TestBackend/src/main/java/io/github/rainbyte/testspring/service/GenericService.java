package io.github.rainbyte.testspring.service;

import java.util.List;
import java.util.stream.Collectors;

import io.github.rainbyte.testspring.dao.GenericDAO;
import io.github.rainbyte.testspring.dto.GenericDTO;

public interface GenericService<T, U extends GenericDTO> {

    GenericDAO<T> getDAO();
    U toDTO(T entity);
    T toEntity(U dto);

    default List<U> findAll() {
        List<T> entities = getDAO().findAll();
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    default U findById(int id) {
        T entity = getDAO().findById(id);
        return toDTO(entity);
    }

    default void save(U dto) {
        if (dto.getId() == 0) {
            int id = getDAO().save(toEntity(dto));
            dto.setId(id);
        } else {
            getDAO().update(toEntity(dto));
        }
    }

    default void deleteById(int id) {
        getDAO().deleteById(id);
    }
}