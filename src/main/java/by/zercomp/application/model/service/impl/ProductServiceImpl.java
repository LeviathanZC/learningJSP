package by.zercomp.application.model.service.impl;

import by.zercomp.application.controller.RequestParam;
import by.zercomp.application.model.dao.DaoFactory;
import by.zercomp.application.model.dao.ProductDao;
import by.zercomp.application.model.entity.Brand;
import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.entity.Product;
import by.zercomp.application.model.exception.DaoException;
import by.zercomp.application.model.exception.ServiceException;
import by.zercomp.application.model.service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = DaoFactory.getInstance().getProductDao();

    @Override
    public Optional<Product> findById(long id) throws ServiceException {
        try {
            return productDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> findByBrand(Brand brand) throws ServiceException {
        try {
            return productDao.findByBrand(brand);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> findByCategory(Category category) throws ServiceException {
        try {
            return productDao.findByCategory(category);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void add(Map<String, Object> productParams) throws ServiceException {
        try {
            productDao.addProduct(productParams);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Map<String, Object> productParams, int id) throws ServiceException {
        try {
            productParams.put(RequestParam.PRODUCT_ID, id);
            productDao.updateProduct(productParams);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> findProductInRangeOfPrice(int min, int max) throws ServiceException {
        try {
            return productDao.findInPriceRange(min, max);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
