package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.Brand;
import by.zercomp.application.model.exception.DaoException;

public interface BrandDao {

    void add(Brand brand) throws DaoException;

    void remove(Brand brand) throws DaoException;

    void update(long id, Brand brand) throws DaoException;

    Brand findById(long id) throws DaoException;
}
