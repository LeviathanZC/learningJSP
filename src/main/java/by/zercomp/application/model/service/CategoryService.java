package by.zercomp.application.model.service;

import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void add(Category newCategory) throws ServiceException;

    void remove(long id) throws ServiceException;

    void update(Category category) throws ServiceException;

    Optional<Category> findById(long id) throws ServiceException;

    List<Category> findAll() throws ServiceException;

}
