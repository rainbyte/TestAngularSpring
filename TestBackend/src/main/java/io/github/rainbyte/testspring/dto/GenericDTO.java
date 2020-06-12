package io.github.rainbyte.testspring.dto;

public interface GenericDTO<T> {
    int getId();
    void setId(int id);
    GenericDTO<T> fromEntity(T entity);
    T toEntity();
}
