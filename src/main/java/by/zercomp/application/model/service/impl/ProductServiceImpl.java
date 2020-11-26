package by.zercomp.application.model.service.impl;

import by.zercomp.application.model.entity.Brand;
import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.entity.Product;
import by.zercomp.application.model.exception.ServiceException;
import by.zercomp.application.model.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    @Override
    public Optional<Product> findById(long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public List<Product> findByBrand(Brand brand) throws ServiceException {
        return null;
    }

    @Override
    public List<Product> findByCategory(Category category) throws ServiceException {
        return null;
    }

    @Override
    public List<Product> findByName(String name) throws ServiceException {
        return null;
    }

    @Override
    public void add(Product product) throws ServiceException {

    }

    @Override
    public void update(Product product, int id) throws ServiceException {

    }

    @Override
    public List<Product> findProductInRangeOfPrice(int min, int max) throws ServiceException {
        return null;
    }
}
