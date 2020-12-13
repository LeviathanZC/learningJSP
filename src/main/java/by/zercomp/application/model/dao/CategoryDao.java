package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.exception.DaoException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CategoryDao {

    void add(Map<String, Object> categoryParams) throws DaoException;

    void remove(long id) throws DaoException;

    void update(long id, Category category) throws DaoException;

    Optional<Category> findById(long id) throws DaoException;

    List<Category> findAll() throws DaoException;

}
