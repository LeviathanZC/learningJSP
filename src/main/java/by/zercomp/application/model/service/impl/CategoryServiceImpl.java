package by.zercomp.application.model.service.impl;

import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.exception.ServiceException;
import by.zercomp.application.model.service.CategoryService;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public void add(Category newCategory) throws ServiceException {

    }

    @Override
    public void remove(long id) throws ServiceException {

    }

    @Override
    public void update(Category category) throws ServiceException {

    }

    @Override
    public Optional<Category> findById(long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() throws ServiceException {
        return null;
    }
}
