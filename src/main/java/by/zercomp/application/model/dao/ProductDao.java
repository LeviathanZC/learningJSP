package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.Brand;
import by.zercomp.application.model.entity.Category;
import by.zercomp.application.model.entity.Product;
import by.zercomp.application.model.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    void addProduct(Product product) throws DaoException;

    void removeProduct(long id) throws DaoException;

    void updateProduct(Product product) throws DaoException;

    Optional<Product> findById(long id) throws DaoException;

    List<Product> findByCategory(Category category) throws DaoException;

    List<Product> findByBrand(Brand brand) throws DaoException;

    List<Product> findInPriceRange(int minPrice, int maxPrice) throws DaoException;
}
