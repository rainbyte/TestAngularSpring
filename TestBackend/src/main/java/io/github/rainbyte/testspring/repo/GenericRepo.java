package io.github.rainbyte.testspring.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;

public interface GenericRepo<T> {
    Class<T> toEntityClass();
    EntityManager getEntityManager();

    default List<T> findAll() {
        Query<T> query = getSession().createQuery("FROM :table", toEntityClass());
        query.setParameter("table", toEntityClass().toString());
        return query.getResultList();
    }

    default T findById(int id) {
        return getSession().get(toEntityClass(), id);
    }

    default void save(T entity) {
        getSession().saveOrUpdate(entity);
    }

    default void deleteById(int id) {
        Query<T> query = getSession().createQuery("DELETE FROM :table WHERE id=:id");
        query.setParameter("id", id);
        query.setParameter("table", toEntityClass().toString()); // FIXME: fails with custom annotated names
        query.executeUpdate();
    }

    private Session getSession() {
        return getEntityManager().unwrap(Session.class);
    }
}