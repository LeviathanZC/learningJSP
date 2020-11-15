package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.exception.DaoException;

import java.util.List;

public interface CategoryDao {

    void add(Category category) throws DaoException;

    void remove(Category category) throws DaoException;

    void update(long id, Category category) throws DaoException;

    List<Category> findById(long id) throws DaoException;

}
