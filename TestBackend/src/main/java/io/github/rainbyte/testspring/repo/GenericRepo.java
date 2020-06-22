package io.github.rainbyte.testspring.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public interface GenericRepo<T> {
    Class<T> toEntityClass();
    EntityManager getEntityManager();

    default List<T> findAll() {
        Query<T> query = getSession().createQuery("FROM " + toEntityClass().getName(), toEntityClass());
        return query.getResultList();
    }

    default T findById(int id) {
        return getSession().get(toEntityClass(), id);
    }

    default int save(T entity) {
        return (int) getSession().save(entity);
    }

    default void update(T entity) {
        getSession().update(entity);
    }

    // FIXME: fails with custom annotated entity names
    @Transactional
    default void deleteById(int id) {
        Query<T> query = getSession().createQuery("DELETE FROM " + toEntityClass().getName() + " WHERE id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    default Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }
}