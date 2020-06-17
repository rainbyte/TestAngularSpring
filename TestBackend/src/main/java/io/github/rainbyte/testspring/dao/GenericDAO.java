package io.github.rainbyte.testspring.dao;

import io.github.rainbyte.testspring.dto.GenericDTO;
import io.github.rainbyte.testspring.repo.GenericRepo;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericDAO<T> {

    GenericRepo<T> getRepo();
    GenericDTO<T> entityToDTO(T entity);

    default List<? extends GenericDTO<T>> findAll() {
        List<T> entities = getRepo().findAll();
        return entities.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    default GenericDTO<T> findById(int id) {
        return entityToDTO(getRepo().findById(id));
    }

    default void save(GenericDTO<T> dto) {
        T entity = dto.toEntity();
        if (dto.getId() == 0) {
            int id = getRepo().save(entity);
            dto.setId(id);
        } else {
            getRepo().update(entity);
        }
    }

    default void deleteById(int id) {
        getRepo().deleteById(id);
    }

}
