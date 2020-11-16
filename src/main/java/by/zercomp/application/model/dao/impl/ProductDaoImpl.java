package by.zercomp.application.model.dao.impl;

import by.zercomp.application.model.dao.GenericDao;
import by.zercomp.application.model.dao.ProductDao;
import by.zercomp.application.model.dao.builder.impl.ProductBuilder;
import by.zercomp.application.model.entity.Brand;
import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.entity.Product;
import by.zercomp.application.model.exception.DaoException;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl extends GenericDao<Product> implements ProductDao {

    private ProductDaoImpl() {
        super(new ProductBuilder());
    }

    @Override
    public void addProduct(Product product) throws DaoException {

    }

    @Override
    public Product removeProduct(long id) throws DaoException {
        return null;
    }

    @Override
    public void updateProduct(Product product) throws DaoException {

    }

    @Override
    public Optional<Product> findById(long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Product> findByCategory(Category category) throws DaoException {
        return null;
    }

    @Override
    public List<Product> findByBrand(Brand brand) throws DaoException {
        return null;
    }

    @Override
    public List<Product> findInPriceRange(int minPrice, int maxPrice) throws DaoException {
        return null;
    }

    @Override
    public void addProductQuantity(long id, int quantity) throws DaoException {

    }

    @Override
    public void subProductQuantity(long id, int quantity) throws DaoException {

    }
}
